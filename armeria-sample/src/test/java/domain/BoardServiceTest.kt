package domain

import com.linecorp.armeria.common.HttpStatus
import com.navercorp.fixturemonkey.LabMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import dto.BoardDeleteRequest
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

private val labMonkey = LabMonkey.labMonkeyBuilder()
    .plugin(KotlinPlugin())
    .build()

class BoardServiceTest : DescribeSpec({

    val boardService = BoardService()
    val board = labMonkey.giveMeOne(Board::class.java)

    describe("BoardService") {
        context("저장된 Board 가 없을 때") {
            it("조회하면 NO_CONTENT 가 반환된다.") {
                val response = boardService.getBoards()
                val result = response.aggregate().join()

                result.status() shouldBe HttpStatus.NO_CONTENT
            }
        }

        context("Board 를 저장했을 때") {
            it("성공하면 201 CREATED 가 반환된다.") {
                val response = boardService.createBoard(board)

                val result = response.aggregate().join()

                result.status() shouldBe HttpStatus.CREATED
            }

            it("같은 id 가 이미 존재하면 409 CONFLICT 가 반환된다.") {
                val response = boardService.createBoard(board)

                val result = response.aggregate().join()

                result.status() shouldBe HttpStatus.CONFLICT
            }

            it("저장된 board 를 id 로 조회할 수 있다.") {
                val response = boardService.getBoard(board.id)

                val result = response.aggregate().join()

                result.status() shouldBe HttpStatus.OK
            }

            it("전체 board 를 조회할 수 있다.") {
                val response = boardService.getBoards()

                val result = response.aggregate().join()

                result.status() shouldBe HttpStatus.OK
            }
        }

        context("Board 를 삭제하고 싶을 때") {
            it("입력한 id 가 존재하지 않으면 IllegalStateException 이 발생한다.") {
                val request = BoardDeleteRequest(
                    id = 100L,
                    writer = "writer"
                )

                val exception = shouldThrow<IllegalStateException> {
                    boardService.deleteBoards(request)
                }

                exception.message shouldBe "Board not found"
            }

            it("입력한 id 와 writer 가 일치하지 않는다면 삭제되지 않는다.") {
                val request = BoardDeleteRequest(board.id, "not matched writer")

                val exception = shouldThrow<IllegalStateException> {
                    boardService.deleteBoards(request)
                }

                exception.message shouldBe "Board writer is not matched"
            }

            it("입력한 id 와 writer 가 저장되어 board 와 일치하면 삭제할 수 있다.") {
                val boardDeleteRequest = BoardDeleteRequest(board.id, board.writer)
                val response = boardService.deleteBoards(boardDeleteRequest)

                val result = response.aggregate().join()

                result.status() shouldBe HttpStatus.OK
            }
        }
    }
})
