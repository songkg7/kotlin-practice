package com.haril.kotlinspring.domain

class Student() {
    lateinit var name: String
    var age: Int = 0

    constructor(name: String, age: Int) : this() {
        this.name = name
        this.age = age
    }
}
