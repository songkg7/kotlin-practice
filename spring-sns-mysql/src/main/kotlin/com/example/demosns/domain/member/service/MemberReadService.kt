package com.example.demosns.domain.member.service

import com.example.demosns.domain.member.dto.MemberDto
import com.example.demosns.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberReadService(
    private val memberRepository: MemberRepository,
) {
    fun findAll(): List<MemberDto> {
        val members = memberRepository.findAll()
        return members.map { MemberDto.of(it) }
    }

    fun findById(id: Long): MemberDto {
        val member = memberRepository.findById(id).orElseThrow()
        return MemberDto.of(member)
    }

    fun getMembers(memberIds: List<Long>): List<MemberDto> {
        val members = memberRepository.findAllById(memberIds)
        return members.map { MemberDto.of(it) }
    }
}
