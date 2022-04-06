package com.example.notebookwithkotlin.basic.delegation

class RockAndRollBehavior(val n: String) : SoundBehavior {

    override fun makeSound() = println("I'm The King of Rock 'N' Roll: $n")

}