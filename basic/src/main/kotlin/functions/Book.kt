package functions

class Book(author: Person) {
    val author = author.also {
        check(it.name.isNotEmpty()) { "빈 작가명은 허용하지 않습니다." }
        println(it.name)
    }
}
