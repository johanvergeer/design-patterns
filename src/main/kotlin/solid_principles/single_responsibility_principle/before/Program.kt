package solid_principles.single_responsibility_principle.before

class Product(
    val id: Int,
    var name: String,
    var description: String
) {
    fun save() {
        println("Saving '${this.name}' to a SQL Server database")
    }
}

fun main() {
    val product = Product(1, "Ham", "A nice slice of ham to put on a sandwich")

    product.save()
}
