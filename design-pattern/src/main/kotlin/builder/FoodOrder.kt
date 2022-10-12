package builder

class FoodOrder private constructor(
    val bread: String?,
    val condiments: String?,
    val meat: String?,
    val cheese: String?,
    val vegetables: String?,
) {
    data class Builder(
        private var bread: String? = null,
        private var condiments: String? = null,
        private var meat: String? = null,
        private var cheese: String? = null,
        private var vegetables: String? = null,
    ) {
        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun cheese(cheese: String) = apply { this.cheese = cheese }
        fun vegetables(vegetables: String) = apply { this.vegetables = vegetables }
        fun build() = FoodOrder(bread, condiments, meat, cheese, vegetables)
    }
}
