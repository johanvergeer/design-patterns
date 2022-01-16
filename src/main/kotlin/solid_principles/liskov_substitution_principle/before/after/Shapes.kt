package solid_principles.liskov_substitution_principle.before.after

data class Rectangle(var width: Int, var height: Int) {
    val area
        get() = this.width * this.height

    val perimiter
        get() = (this.width + this.height) * 2
}

data class Square(var side: Int) {
    val area
        get() = this.side * this.side

    val perimiter
        get() = this.side * 4
}
