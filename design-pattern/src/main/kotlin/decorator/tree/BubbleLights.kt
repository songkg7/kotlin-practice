package decorator.tree

class BubbleLights(tree: TreeDecorator) : TreeDecorator(tree) {

    override fun decorate(): String {
        return super.decorate() + decorateWithBubbleLights()
    }

    private fun decorateWithBubbleLights() = " with bubble lights"
}
