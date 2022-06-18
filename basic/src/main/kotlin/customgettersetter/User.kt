package customgettersetter

class User {
    var name: String = "test"
        get() = field.repeat(2)
        set(value) {
            field = value.uppercase()
        }

    var age: Int = 20
        private set
}

fun main() {
    val user = User()
    println(user.name)

    user.name = "change"
    println(user.name)
    println(user.age)
}