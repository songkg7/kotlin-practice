package observer.v1

class Lewin : Crew {
    override fun update(message: String) {
        println("Lewin received: $message")
    }
}

class Tiber : Crew {
    override fun update(message: String) {
        println("Tiber received: $message")
    }
}

class Jay : Crew {
    override fun update(message: String) {
        println("Jay received: $message")
    }
}
