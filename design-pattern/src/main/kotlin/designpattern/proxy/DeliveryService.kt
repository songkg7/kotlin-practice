package designpattern.proxy

class DeliveryService(private val rider: Rider) {
    fun delivery() = rider.delivery()
    fun getRider() = rider.getPersonal(1)
}

fun main() {
    val deliveryService = DeliveryService(ProxyRider("alex"))
    deliveryService.delivery()
}