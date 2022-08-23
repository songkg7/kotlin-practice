package command.order

class OrderAddCommand(private val id: Long) : OrderCommand {
    override fun execute() {
        println("Adding order with id: $id")
    }
}
