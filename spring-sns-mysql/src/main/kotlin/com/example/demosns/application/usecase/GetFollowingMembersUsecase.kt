package com.example.demosns.application.usecase

import com.example.demosns.domain.follow.service.FollowReadService
import com.example.demosns.domain.member.dto.MemberDto
import com.example.demosns.domain.member.service.MemberReadService
import org.springframework.stereotype.Service

@Service
class GetFollowingMembersUsecase(
    private val followReadService: FollowReadService,
    private val memberReadService: MemberReadService,
) {

    fun execute(memberId: Long): List<MemberDto> {
        val follows = followReadService.getFollowings(memberId)
        return memberReadService.getMembers(follows.map { it.toMemberId })
    }

}
