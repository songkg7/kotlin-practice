package com.example.notebookwithkotlin

fun main() {
    val logger = Logger("Main")
    val notificationSender = NotificationSender()
    with(logger) {
        with(notificationSender) {
            store("An image")
            store("A text file")
            store("A cheese berger")
        }
    }
}

class Logger(val name: String) {
    fun log(s: String) {
        println("$name: $s")
    }
}

class NotificationSender {
    fun send(s: String) = println("NOTIFY: $s")
}

context(Logger, NotificationSender)
fun store(s: String) {
    log("Stored $s on disk (via $name).")
    send("Successful storage event.")
}
