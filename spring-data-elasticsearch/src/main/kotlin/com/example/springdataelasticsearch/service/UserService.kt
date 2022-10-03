package com.example.springdataelasticsearch.service

import com.example.springdataelasticsearch.domain.User
import com.example.springdataelasticsearch.domain.repository.UserSearchRepository
import org.springframework.stereotype.Service

@Service
class UserService(val userSearchRepository: UserSearchRepository) {

    fun searchAll(): List<User> {
        return userSearchRepository.findAll().toList()
    }

    fun saveUser(user: User): User {
        return userSearchRepository.save(user)
    }

    fun updateUser(user: User): User {
        return userSearchRepository.save(user)
    }

    fun deleteUser(id: Long) {
        userSearchRepository.deleteById(id)
    }

    fun deleteAll() = userSearchRepository.deleteAll()

}
