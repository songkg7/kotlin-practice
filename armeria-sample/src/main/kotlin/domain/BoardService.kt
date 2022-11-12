package domain

import com.linecorp.armeria.common.HttpResponse
import com.linecorp.armeria.common.HttpStatus
import com.linecorp.armeria.common.MediaType
import com.linecorp.armeria.server.annotation.Get
import com.linecorp.armeria.server.annotation.Param
import com.linecorp.armeria.server.annotation.Post
import com.linecorp.armeria.server.annotation.RequestConverter

class BoardService(
    private val mutableBoards: MutableMap<Long, Board> = mutableMapOf(),
) {

    @Post("/boards")
    @RequestConverter(BoardPostRequestConverter::class)
    fun createBoard(board: Board): HttpResponse {
        mutableBoards[board.id] = board
        return HttpResponse.ofJson(board)
    }

    @Get("/boards/:id")
    fun getBoard(@Param("id") id: Long): HttpResponse {
        mutableBoards[id]?.let {
            return HttpResponse.ofJson(it)
        }
        return HttpResponse.of(
            HttpStatus.NO_CONTENT,
            MediaType.ANY_APPLICATION_TYPE,
            "Board not found"
        )
    }

    @Get("/boards")
    fun getBoards(): HttpResponse {
        if (mutableBoards.isEmpty()) {
            return HttpResponse.of(
                HttpStatus.NO_CONTENT
            )
        }
        return HttpResponse.ofJson(mutableBoards.values)
    }
}
