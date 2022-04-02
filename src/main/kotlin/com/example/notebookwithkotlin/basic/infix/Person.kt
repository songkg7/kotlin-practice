package com.example.notebookwithkotlin.basic.infix

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()

    infix fun likes(other: Person) = likedPeople.add(other)
}