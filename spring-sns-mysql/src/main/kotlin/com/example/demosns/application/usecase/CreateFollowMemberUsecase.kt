package com.example.demosns.application.usecase

import com.example.demosns.domain.follow.service.FollowWriteService
import com.example.demosns.domain.member.service.MemberReadService
import org.springframework.stereotype.Service

@Service
class CreateFollowMemberUsecase(
    private val followWriteService: FollowWriteService,
    private val memberReadService: MemberReadService
) {

    fun execute(fromMemberId: Long, toMemberId: Long) {
        // 입력받은 memberId 로 회원 조회
        val fromMember = memberReadService.findById(fromMemberId)
        val toMember = memberReadService.findById(toMemberId)

        followWriteService.create(fromMember, toMember)
    }

}
