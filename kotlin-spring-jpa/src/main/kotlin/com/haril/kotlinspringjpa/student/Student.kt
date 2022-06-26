package com.haril.kotlinspringjpa.student

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Student {

    @Id
    @GeneratedValue
    var id: Long? = null

    var name: String? = null

    var age: Int? = null
}