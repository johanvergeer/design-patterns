package solid_principles.single_responsibility_principle.after

data class Product(
    val id: Int,
    var name: String,
    var description: String
) {
    override fun equals(other: Any?): Boolean {
        return other is Product && other.hashCode() == this.hashCode()
    }

    override fun hashCode(): Int {
        return this.id
    }
}
