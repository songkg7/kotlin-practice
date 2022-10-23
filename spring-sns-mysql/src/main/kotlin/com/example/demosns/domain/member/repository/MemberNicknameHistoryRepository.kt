package com.example.demosns.domain.member.repository

import com.example.demosns.domain.member.entity.MemberNicknameHistory
import org.springframework.data.jpa.repository.JpaRepository

interface MemberNicknameHistoryRepository : JpaRepository<MemberNicknameHistory, Long> {
}
