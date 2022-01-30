package solid_principles.liskov_substitution_principle.before.after

interface HasArea {
    val area: Int
}

interface HasPerimeter {
    val perimeter: Int
}

data class Rectangle(var width: Int, var height: Int) : HasArea, HasPerimeter {
    override val area
        get() = this.width * this.height

    override val perimeter
        get() = (this.width + this.height) * 2
}

data class Square(var side: Int) : HasArea, HasPerimeter {
    override val area
        get() = this.side * this.side

    override val perimeter
        get() = this.side * 4
}

fun totalArea(shapes: Iterable<HasArea>): Int {
    return shapes.sumOf { shape -> shape.area }
}

fun totalPerimeter(shapes: Iterable<HasPerimeter>): Int {
    return shapes.sumOf { shape -> shape.perimeter }
}

fun main() {
    val shapes = listOf(
        Rectangle(10, 10),
        Rectangle(20, 10),
        Square(20),
    )

    println(totalArea(shapes))

    println(totalPerimeter(shapes))
}
