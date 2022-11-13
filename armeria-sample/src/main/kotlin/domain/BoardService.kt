package domain

import com.linecorp.armeria.common.HttpResponse
import com.linecorp.armeria.common.HttpStatus
import com.linecorp.armeria.common.MediaType
import com.linecorp.armeria.server.annotation.*
import converter.BoardDeleteRequestConverter
import converter.BoardPostRequestConverter
import handler.GlobalExceptionHandler
import input.BoardDeleteRequest

@ExceptionHandler(GlobalExceptionHandler::class)
class BoardService(
    private val mutableBoards: MutableMap<Long, Board> = mutableMapOf(),
) {

    private val isExist = mutableBoards::containsKey

    @Post("/boards")
    @RequestConverter(BoardPostRequestConverter::class)
    fun createBoard(board: Board): HttpResponse {
        mutableBoards[board.id]?.let {
            return HttpResponse.of(HttpStatus.CONFLICT)
        }
        mutableBoards[board.id] = board
        return HttpResponse.ofJson(HttpStatus.CREATED, board)
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

    @Delete("/boards")
    @RequestConverter(BoardDeleteRequestConverter::class)
    fun deleteBoards(request: BoardDeleteRequest): HttpResponse {
        // TODO: exception catch test = webclient test
        check(isExist(request.id)) { "Board not found" }

        val board = mutableBoards[request.id]!!
        check(request.writer hasOwnerShip board) { "Board writer is not matched" }

        mutableBoards.remove(request.id)
        return HttpResponse.of(
            HttpStatus.OK,
            MediaType.ANY_APPLICATION_TYPE,
            "Board deleted"
        )
    }

    @Put("/boards/:id")
    fun updateBoard(@Param("id") id: Long, @RequestObject board: Board): HttpResponse {
        check(isExist(id)) { "Board not found" }
        val existsBoard = mutableBoards[id]!!
        check(board.writer hasOwnerShip existsBoard) { "Board writer is not matched" }

        mutableBoards[id] = board
        return HttpResponse.ofJson(board)
    }

}
