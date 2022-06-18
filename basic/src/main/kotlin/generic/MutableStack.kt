package generic

class MutableStack<E>(vararg items: E) {

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek() = elements.last()

    fun pop() = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    infix operator fun plus(element: E) = elements.add(element)

    override fun toString() = "MutableStack(${elements.joinToString()})"

    operator fun iterator() = elements.iterator()

}