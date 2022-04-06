package com.example.notebookwithkotlin.basic.delegation

class ScreamBehavior(val n: String) : SoundBehavior {

    override fun makeSound() = println(n.uppercase())

}