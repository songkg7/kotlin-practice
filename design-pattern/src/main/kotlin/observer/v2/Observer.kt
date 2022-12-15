package observer.v2

open class Subject {

    private val observers = mutableListOf<Observer>()

    fun callObserver() {
        observers.forEach { it.update() }
    }

    fun attach(observer: Observer) {
        observers.add(observer)
    }

    fun detach(observer: Observer) {
        observers.remove(observer)
    }

}

interface Observer {
    fun update()
}

class Sensor : Subject() {
    var temperature: Int = 0
        set(value) {
            field = value
            callObserver()
        }
}

class Monitor(private val sensor: Sensor) : Observer {
    init {
        sensor.attach(this)
    }

    override fun update() {
        val newTemperature = sensor.temperature
        println("Monitor: Temperature is changed to $newTemperature")
    }
}

fun main() {
    val sensor = Sensor()
    val monitor = Monitor(sensor)

    sensor.temperature = 10
}
