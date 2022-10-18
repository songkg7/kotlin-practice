package com.example.demosns.domain.member.service

import com.example.demosns.domain.member.entity.Member
import com.example.demosns.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberReadService(
    private val memberRepository: MemberRepository,
) {
    fun findAll(): List<Member> = memberRepository.findAll()

    fun findById(id: Long): Member = memberRepository.findById(id).orElseThrow()
}
