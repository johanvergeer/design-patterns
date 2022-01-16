package solid_principles.liskov_substitution_principle.before.before

open class Rectangle(open var width: Int, open var height: Int) {
    val area
        get() = this.width * this.height

    val perimiter
        get() = (width + height) * 2
}

class Square(side: Int) : Rectangle(side, side) {
    override var width = side
        set(value) {
            this.height = value
            field = value
        }

    override var height = side
        set(value) {
            this.width = value
            field = value
        }
}
