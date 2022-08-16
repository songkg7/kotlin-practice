package functions

fun getPerson(): Person = Person().apply {
    name = "song"
    age = 27
}

class Person(var name: String?, var age: Int?) {
    constructor() : this(null, null)
}
