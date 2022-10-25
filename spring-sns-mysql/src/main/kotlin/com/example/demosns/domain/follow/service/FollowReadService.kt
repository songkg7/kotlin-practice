package com.example.demosns.domain.follow.service

import com.example.demosns.domain.follow.repository.FollowRepository
import org.springframework.stereotype.Service

@Service
class FollowReadService(
    private val followRepository: FollowRepository
) {

    fun getFollowings(fromMemberId: Long) = followRepository.findAllByFromMemberId(fromMemberId)

}
