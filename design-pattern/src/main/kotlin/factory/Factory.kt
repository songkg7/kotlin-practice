package factory

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Circle draw method.")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Rectangle draw method.")
    }
}

class Square : Shape {
    override fun draw() {
        println("Square draw method.")
    }
}

enum class ShapeEnum {
    CIRCLE, RECTANGLE, SQUARE
}

class ShapeFactory {
    fun getShape(shapeEnum: ShapeEnum): Shape {
        if (shapeEnum == ShapeEnum.CIRCLE) {
            return Circle()
        }
        if (shapeEnum == ShapeEnum.RECTANGLE) {
            return Rectangle()
        }
        if (shapeEnum == ShapeEnum.SQUARE) {
            return Square()
        }
        throw UnsupportedClassVersionError()
    }
}

fun main() {
    val shapeFactory = ShapeFactory()
    val shape = shapeFactory.getShape(ShapeEnum.RECTANGLE)
    shape.draw()
}