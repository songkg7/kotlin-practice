package com.example.demosns.domain.follow.service

import com.example.demosns.domain.follow.entity.Follow
import com.example.demosns.domain.follow.repository.FollowRepository
import com.example.demosns.domain.member.dto.MemberDto
import org.springframework.stereotype.Service

@Service
class FollowWriteService(
    private val followRepository: FollowRepository
) {

    fun create(fromMember: MemberDto, toMember: MemberDto) {
        // from <-> to validation
        check(fromMember.id != toMember.id) { "자기 자신을 팔로우 할 수 없습니다." }

        Follow(
            toMemberId = toMember.id,
            fromMemberId = fromMember.id,
        ).let {
            followRepository.save(it)
        }
    }

}
