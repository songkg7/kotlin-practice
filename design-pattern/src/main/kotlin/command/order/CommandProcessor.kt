package command.order

class CommandProcessor {
    private val queue = mutableListOf<OrderCommand>()

    fun add(orderCommand: OrderCommand): CommandProcessor = apply {
        queue.add(orderCommand)
    }

    fun processCommands(): CommandProcessor = apply {
        queue.forEach { it.execute() }
        queue.clear()
    }
}
