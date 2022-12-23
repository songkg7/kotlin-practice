package composite

// component
interface Node {
    fun name(): String
    fun print()
}

// leaf
class File(private val name: String) : Node {
    override fun name() = name
    override fun print() {
        println(name)
    }
}

// composite
class Directory(
    private val name: String,
    private val children: MutableList<Node> = mutableListOf(),
) : Node {

    override fun name() = name
    override fun print() {
        println(name)
        println("├── ")
        children.forEach { it.print() }
    }

    fun add(node: Node) {
        children.add(node)
    }
}

// client
fun main() {
    val dir = Directory("root")
    dir.add(File("file1"))
    dir.add(File("file2"))
    dir.add(Directory("dir1"))
    val dir2 = Directory("dir2")

    dir2.add(dir)
    println(dir2.print())
}
