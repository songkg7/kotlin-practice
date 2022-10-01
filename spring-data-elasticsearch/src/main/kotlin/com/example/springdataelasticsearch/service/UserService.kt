package com.example.springdataelasticsearch.service

import com.example.springdataelasticsearch.domain.User
import com.example.springdataelasticsearch.domain.repository.UserSearchRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userSearchRepository: UserSearchRepository) {

    fun searchAll(): List<User> {
        return userSearchRepository.findAll().toList()
    }

    fun saveUser(user: User) {
        userSearchRepository.save(user)
    }

}
