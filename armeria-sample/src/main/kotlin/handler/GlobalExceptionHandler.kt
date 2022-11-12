package handler

import com.linecorp.armeria.common.HttpRequest
import com.linecorp.armeria.common.HttpResponse
import com.linecorp.armeria.common.HttpStatus
import com.linecorp.armeria.common.MediaType
import com.linecorp.armeria.server.ServiceRequestContext
import com.linecorp.armeria.server.annotation.ExceptionHandlerFunction

class GlobalExceptionHandler: ExceptionHandlerFunction {

    override fun handleException(
        ctx: ServiceRequestContext,
        req: HttpRequest,
        cause: Throwable,
    ): HttpResponse {
        if (cause is IllegalStateException) {
            return HttpResponse.of(
                HttpStatus.BAD_REQUEST,
                MediaType.PLAIN_TEXT_UTF_8,
                cause.message!!)
        }
        return HttpResponse.of(cause.message!!)
    }
}
