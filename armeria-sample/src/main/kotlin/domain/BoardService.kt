package domain

import com.linecorp.armeria.common.HttpResponse
import com.linecorp.armeria.server.annotation.Post
import com.linecorp.armeria.server.annotation.RequestConverter

class BoardService(
    private val boards: Map<Long, Board> = mapOf(),
) {

    @Post("/boards")
    @RequestConverter(BoardPostRequestConverter::class)
    fun createBoard(board: Board): HttpResponse {
        boards.plus(board.id to board)
        return HttpResponse.ofJson(board)
    }
}
