package com.example.notebookwithkotlin.designpattern.decorator

abstract class Decorator(private val coffee: Coffee) : Coffee {

    override fun recipe(): String {
        return coffee.recipe()
    }
}

class Milk(coffee: Coffee) : Decorator(coffee) {

    override fun recipe(): String {
        return super.recipe() + " + 우유"
    }
}

class Water(coffee: Coffee) : Decorator(coffee) {

    override fun recipe(): String {
        return super.recipe() + " + 물"
    }
}

fun main() {
    val espresso = Espresso()
    println("espresso = ${espresso.recipe()}")

    val americano = Water(Espresso())
    println("americano = ${americano.recipe()}")

    val latte = Milk(Espresso())
    println("latte = ${latte.recipe()}")

    val weirdCoffee = Milk(Water(Espresso()))
    println("weirdCoffee = ${weirdCoffee.recipe()}")
}