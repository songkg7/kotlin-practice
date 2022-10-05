package custom

abstract class CarrierService<T>(private val converter: Converter<String, List<T>>) {

    fun tracking() = "tracking"

    fun convertedTracking() = converter.convert(tracking())

}
