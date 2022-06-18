package com.example.kotlinpractice

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
class Repository {
    fun store(s: String) {
        logStorageEvent(s)
        notificationSender.log("Successful storage event.")
    }
}

context(LoggerContext)
fun logStorageEvent(s: String) {
    logger.log("Stored $s on disk (via ${logger.name}).")
}

fun main() {
    val logger = Logger("Main")
    val notificationSender = NotificationSender()

    val loggerContext = object : LoggerContext {
        override val logger = logger
    }

    val notificationContext = object : NotificationContext {
        override val notificationSender = notificationSender
    }

    val repository = with(loggerContext) {
        with(notificationContext) {
            Repository()
        }
    }

    repository.store("An idea")
}
