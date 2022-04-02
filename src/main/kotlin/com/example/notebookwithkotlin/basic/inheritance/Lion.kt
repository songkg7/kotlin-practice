package com.example.notebookwithkotlin.basic.inheritance

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}