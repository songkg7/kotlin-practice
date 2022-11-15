import com.linecorp.armeria.server.Server
import com.linecorp.armeria.server.docs.DocService
import domain.BoardService
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
    logger.info("Serving DocService at http://127.0.0.1:{}/docs", activeLocalPort())
}

private fun newServer(httpPort: Int = 8080, httpsPort: Int = 8443): Server {
    return Server.builder()
        .http(httpPort)
        .https(httpsPort)
        .tlsSelfSigned()
        .annotatedService(BoardService())
        .serviceUnder("/docs", docService())
        .build()
}

private fun docService(): DocService {
    return DocService.builder()
        .exampleRequests(BoardService::class.java,
            "createBoard",
            "{\"title\": \"title\", \"content\": \"Hello, Armeria!\"}")
        .build()
}
