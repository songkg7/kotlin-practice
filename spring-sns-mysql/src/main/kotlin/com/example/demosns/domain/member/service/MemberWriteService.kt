package com.example.demosns.domain.member.service

import com.example.demosns.domain.member.dto.RegistMemberCommand
import com.example.demosns.domain.member.entity.Member
import com.example.demosns.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberWriteService(val memberRepository: MemberRepository) {

    fun create(command: RegistMemberCommand) {
        Member(
            nickname = command.nickname,
            birthday = command.birthday,
            email = command.email,
        ).let {
            memberRepository.save(it)
        }
    }

}
