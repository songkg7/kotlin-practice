package com.example.demosns.domain.member.service

import com.example.demosns.domain.member.dto.CreateMemberCommand
import com.example.demosns.domain.member.entity.Member
import com.example.demosns.domain.member.repository.MemberNicknameHistoryRepository
import com.example.demosns.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberWriteService(
    private val memberRepository: MemberRepository,
    private val memberNicknameHistoryRepository: MemberNicknameHistoryRepository,
) {

    fun create(command: CreateMemberCommand) {
        Member(
            nickname = command.nickname,
            birthday = command.birthday,
            email = command.email,
        ).let {
            memberRepository.save(it)
        }
    }

    fun changeNickname(id: Long, nickname: String) {
        val member = memberRepository.findById(id).orElseThrow()
        member.changeNickname(nickname)
        memberRepository.save(member)
        memberNicknameHistoryRepository.save(member.toHistory())
    }
}
