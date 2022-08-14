package enums

enum class GarbageType(val koName: String, val calculate: (Int) -> Int) {
    PLASTIC("플라스틱", {
        when (it) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..Int.MAX_VALUE -> 200
            else -> throw IllegalArgumentException()
        }
    }),
    GLASS("유리", {
        when (it) {
            in 0..10 -> 150
            in 10..29 -> 250
            in 30..Int.MAX_VALUE -> 300
            else -> throw IllegalArgumentException()
        }
    }),
    IRON("고철", {
        when (it) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..Int.MAX_VALUE -> 200
            else -> throw IllegalArgumentException()
        }
    })
}
