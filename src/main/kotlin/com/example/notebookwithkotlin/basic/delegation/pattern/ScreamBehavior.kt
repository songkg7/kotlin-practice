package com.example.notebookwithkotlin.basic.delegation.pattern

class ScreamBehavior(val n: String) : SoundBehavior {

    override fun makeSound() = println(n.uppercase())

}