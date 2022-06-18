package designpattern.strategy

interface SurvivalStrategy {
    fun action()
}

class SwimStrategy : SurvivalStrategy {
    override fun action() = println("Swimming!")
}

class FlyStrategy : SurvivalStrategy {
    override fun action() = println("Flying!")
}

class RunStrategy : SurvivalStrategy {
    override fun action() = println("Running!")
}

abstract class Animal(private val strategies: List<SurvivalStrategy>) {

    fun move() = strategies.forEach { it.action() }
}

class Lion(abilities: List<SurvivalStrategy>) : Animal(abilities)

class Eagle(abilities: List<SurvivalStrategy>) : Animal(abilities)

fun main() {
    val lion = Lion(listOf(SwimStrategy(), RunStrategy()))
    val eagle = Eagle(listOf(FlyStrategy()))

    lion.move()
    eagle.move()
}