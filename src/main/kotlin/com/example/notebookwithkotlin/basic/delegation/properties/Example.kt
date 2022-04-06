package com.example.notebookwithkotlin.basic.delegation.properties

class Example {
    var p: String by Delegate()

    override fun toString() = "Example Class"
}

fun main() {
    val e = Example()
    println(e.p)
    e.p = "NEW"
}