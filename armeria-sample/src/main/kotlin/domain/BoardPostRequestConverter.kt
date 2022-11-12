package domain

import com.fasterxml.jackson.databind.ObjectMapper
import com.linecorp.armeria.common.AggregatedHttpRequest
import com.linecorp.armeria.server.ServiceRequestContext
import com.linecorp.armeria.server.annotation.RequestConverterFunction
import java.lang.reflect.ParameterizedType

private val mapper = ObjectMapper()

class BoardPostRequestConverter: RequestConverterFunction {
    override fun convertRequest(
        ctx: ServiceRequestContext,
        request: AggregatedHttpRequest,
        expectedResultType: Class<*>,
        expectedParameterizedResultType: ParameterizedType?,
    ): Any? {
        if (expectedResultType != Board::class.java) {
            return RequestConverterFunction.fallthrough()
        }

        val content = request.contentUtf8()

        val jsonNode = mapper.readTree(content)
        val title = jsonNode.get("title").asText()
        val contents = jsonNode.get("content").asText()
        val writer = jsonNode.get("writer").asText()
        val id = jsonNode.get("id").asLong()

        return Board(id, title, contents, writer)
    }
}

