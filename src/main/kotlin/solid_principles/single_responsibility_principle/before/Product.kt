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