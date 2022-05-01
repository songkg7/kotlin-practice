package com.example.notebookwithkotlin.designpattern.abstractfactory

abstract class Product(val name: String, val price: Int)

class Computer(name: String, price: Int) : Product(name, price)

class Ticket(name: String, price: Int) : Product(name, price)

interface ProductAbstractFactory {
    fun produce(): Product
}

class ComputerFactory(val name: String, val price: Int) : ProductAbstractFactory {
    override fun produce(): Product = Computer(name, price)
}

class TicketFactory(val name: String, val price: Int) : ProductAbstractFactory {
    override fun produce(): Product = Ticket(name, price)
}

class ProductFactory {
    companion object {
        fun getProduct(factory: ProductAbstractFactory): Product {
            return factory.produce()
        }
    }
}

fun main() {
    val computer = ProductFactory.getProduct(ComputerFactory("iMac", 20000))
    val ticket = ProductFactory.getProduct(TicketFactory("ticket", 3000))

    println("computer.price = ${computer.price}")
}