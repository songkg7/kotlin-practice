package observer.v3

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Sensor {
    var temperature: Int by Delegates.observable(0) { property, oldValue, newValue ->
        onChange(property, oldValue, newValue)
    }

    private fun onChange(property: KProperty<*>, oldValue: Int, newValue: Int) {
        println("Sensor: ${property.name} is changed from $oldValue to $newValue")
    }

}

fun main() {
    val sensor = Sensor()
    sensor.temperature = 10
    sensor.temperature = 20
}
