package decorator.tree

class Garlands(private val tree: ChristmasTree) : ChristmasTree by tree {

    override fun decorate(): String {
        return tree.decorate() + decorateWithGarlands()
    }

    private fun decorateWithGarlands() = " with Garlands"
}
