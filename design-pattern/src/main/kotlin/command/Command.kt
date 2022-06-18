package command

interface Command {
    fun execute()
}

class Button(private val command: Command) {
    fun pressed() = command.execute()
}

class Alarm {
    fun alarmOn() = println("Alarming!!")
}

class Lamp {
    fun turnOn() = println("turn on the lamp.")
}

class AlarmOnCommand : Command {
    private val alarm = Alarm()

    override fun execute() = alarm.alarmOn()
}

class LampOnCommand : Command {
    private val lamp = Lamp()

    override fun execute() = lamp.turnOn()
}

fun main() {
    val alarmButton = Button(AlarmOnCommand())
    val lampButton = Button(LampOnCommand())

    alarmButton.pressed()
    lampButton.pressed()
}