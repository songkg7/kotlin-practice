package com.example.demosns.domain.member.entity

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import java.time.LocalDate

internal class MemberTest : DescribeSpec({

    describe("Member") {
        it("기본 생성 검증") {
            val member = Member(
                nickname = "haril",
                birthday = LocalDate.of(1994, 7, 7),
                email = "test@email.com",
            )

            with(member) {
                id shouldBe null // 생성시에는 null 이였다가 영속화 시에 값이 들어간다.
                nickname shouldBe "haril"
                birthday shouldBe LocalDate.of(1994, 7, 7)
                email shouldBe "test@email.com"
                createAt shouldNotBe null
            }
        }
    }

})
