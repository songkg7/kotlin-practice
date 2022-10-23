package com.example.demosns.domain.member.repository

import com.example.demosns.domain.member.entity.Member
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@ActiveProfiles("test")
@SpringBootTest
@Transactional
class MemberRepositoryTest @Autowired constructor(
    val memberRepository: MemberRepository,
) {

    @Test
    fun createMember() {
        // given
        val member = Member(
            nickname = "haril",
            birthday = LocalDate.of(1994, 7, 7),
            email = "test@email.com"
        )

        // when
        val savedMember = memberRepository.save(member)

        // then
        savedMember shouldBe member
    }

    @Test
    fun findMember() {
        // given
        val member = Member(
            nickname = "haril",
            birthday = LocalDate.of(1994, 7, 7),
            email = "test@email.com"
        )
        memberRepository.save(member)

        // when
        val members = memberRepository.findAll()

        // then
        members.size shouldBe 1
        members[0] shouldBe member
    }

    @Test
    fun updateMember() {
        // given
        val member = Member(
            nickname = "haril",
            birthday = LocalDate.of(1994, 7, 7),
            email = "test@email.com"
        )
        memberRepository.save(member)

        // when
        member.changeNickname("haril2")
        memberRepository.save(member)
        val members = memberRepository.findAll()

        // then
        members.size shouldBe 1
        members[0].nickname shouldBe "haril2"
    }

}
