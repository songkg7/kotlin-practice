val fruits = listOf("Apple", "Banana", "Cherry", "Durian")

fun main() {
    fruits.forEachIndexed { index, fruit ->
        println("$index: $fruit")
    }
}