package com.example.demosns.domain.member.service

import com.example.demosns.domain.member.dto.CreateMemberCommand
import com.example.demosns.domain.member.repository.MemberNicknameHistoryRepository
import com.example.demosns.domain.member.repository.MemberRepository
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import java.time.LocalDate

internal class MemberWriteServiceTest : DescribeSpec({

    val memberRepository = mockk<MemberRepository>()
    val memberHistoryRepository = mockk<MemberNicknameHistoryRepository>()
    val memberWriteService = MemberWriteService(memberRepository, memberHistoryRepository)

    describe("create") {
        it("회원 생성") {
            // given
            val command = CreateMemberCommand(
                nickname = "haril",
                birthday = LocalDate.of(1994, 7, 7),
                email = "test@email.com"
            )

            // when
            every { memberRepository.save(any()) } returns command.toEntity()
            memberWriteService.create(command)

            // then
            verify(exactly = 1) { memberRepository.save(any()) }
        }
    }

})
