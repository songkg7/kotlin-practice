package converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.linecorp.armeria.common.AggregatedHttpRequest
import com.linecorp.armeria.server.ServiceRequestContext
import com.linecorp.armeria.server.annotation.RequestConverterFunction
import dto.BoardDeleteRequest
import java.lang.reflect.ParameterizedType

private val mapper = ObjectMapper()

class BoardDeleteRequestConverter: RequestConverterFunction {
    override fun convertRequest(
        ctx: ServiceRequestContext,
        request: AggregatedHttpRequest,
        expectedResultType: Class<*>,
        expectedParameterizedResultType: ParameterizedType?,
    ): Any? {
        if (expectedResultType != BoardDeleteRequest::class.java) {
            return RequestConverterFunction.fallthrough()
        }

        mapper.readTree(request.contentUtf8()).let {
            val id = it.get("id").asLong()
            val writer = it.get("writer").asText()
            return BoardDeleteRequest(id, writer)
        }
    }
}
