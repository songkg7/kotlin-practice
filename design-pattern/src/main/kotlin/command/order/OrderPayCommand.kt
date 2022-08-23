package command.order

class OrderPayCommand(private val id: Long) : OrderCommand {
    override fun execute() {
        println("Paying for order with id: $id")
    }
}
