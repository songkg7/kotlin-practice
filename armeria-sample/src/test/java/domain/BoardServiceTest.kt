package domain

import com.linecorp.armeria.common.HttpStatus
import com.navercorp.fixturemonkey.LabMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

private val labMonkey = LabMonkey.labMonkeyBuilder()
    .plugin(KotlinPlugin())
    .build()

class BoardServiceTest : DescribeSpec({

    val boardService = BoardService()

    describe("BoardService") {
        context("저장된 Board 가 없을 때") {
            it("조회하면 NO_CONTENT 가 반환된다.") {
                val response = boardService.getBoards()
                val result = response.aggregate().join()

                result.status() shouldBe HttpStatus.NO_CONTENT
            }
        }

        context("Board 를 저장했을 때") {
            val board = labMonkey.giveMeOne(Board::class.java)
            it("성공하면 200 이 반환된다.") {
                val response = boardService.createBoard(board)

                val result = response.aggregate().join()

                result.status() shouldBe HttpStatus.OK
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
    }
})
