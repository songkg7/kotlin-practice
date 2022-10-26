package com.example.demosns.domain.post.service

import com.example.demosns.domain.post.dto.DailyPostCount
import com.example.demosns.domain.post.dto.DailyPostCountRequest
import com.example.demosns.domain.post.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostReadService(
    val postRepository: PostRepository,
) {

    fun getDailyPostCounts(request: DailyPostCountRequest): List<DailyPostCount> {
        return postRepository.findDailyCounts(
            memberId = request.memberId,
            startDate = request.startDate,
            endDate = request.endDate,
        )
    }

}
