package com.example.notebookwithkotlin

fun main() {
    val logger = Logger("Main")
    val notificationSender = NotificationSender()

    val loggerContext = object : LoggerContext {
        override val logger = logger
    }

    val notificationContext = object : NotificationContext {
        override val notificationSender = notificationSender
    }

    with(loggerContext) {
        with(notificationContext) {
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
    fun log(s: String) = println("NOTIFY: $s")
}

interface LoggerContext {
    val logger: Logger
}

interface NotificationContext {
    val notificationSender: NotificationSender
}

context(LoggerContext, NotificationContext)
fun store(s: String) {
    logger.log("Stored $s on disk (via ${logger.name}).")
    notificationSender.log("Successful storage event.")
}
