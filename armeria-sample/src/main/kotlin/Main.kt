import com.linecorp.armeria.common.HttpResponse
import com.linecorp.armeria.server.Server
import mu.KotlinLogging

private val logger = KotlinLogging.logger {}

fun main() {
    newServer().startServer()
}

private fun Server.startServer() {
    Runtime.getRuntime().addShutdownHook(Thread {
        logger.info { "Shutting down the server..." }
        stop().join()
        logger.info { "Server has been stopped." }
    })
    start().join()
    logger.info(
        "Server has been started. Serving dummy Service at http://127.0.0.1:{}",
        activeLocalPort()
    )
}

private fun newServer(httpPort: Int = 8080, httpsPort: Int = 8443): Server {
    return Server.builder()
        .http(httpPort)
        .https(httpsPort)
        .tlsSelfSigned()
        .service("/") { _, _ -> HttpResponse.of("Hello, Armeria!") }
        .build()
}


