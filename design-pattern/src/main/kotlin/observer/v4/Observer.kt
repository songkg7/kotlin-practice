package observer.v4

class Signal<TType> {

    class Connection

    private val callbacks = mutableMapOf<Connection, (TType) -> Unit>()

    fun emit(newValue: TType) {
        callbacks.forEach { it.value(newValue) }
    }

    fun connect(callback: (TType) -> Unit): Connection {
        val connection = Connection()
        callbacks[connection] = callback
        return connection
    }

    fun disconnect(connection: Connection) {
        callbacks.remove(connection)
    }
}

class Sensor {
    val temperatureChanged = Signal<Int>()
}

class Monitor {
    fun onTemperatureChanged(newValue: Int) {
        println("Monitor: Temperature is changed to $newValue")
    }
}

fun main() {
    val sensor = Sensor()
    val monitor = Monitor()
    sensor.temperatureChanged.connect { monitor.onTemperatureChanged(it) }

    sensor.temperatureChanged.emit(10)
}
