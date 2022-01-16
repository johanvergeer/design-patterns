package design_patterns.composite.employee

data class Employee(val name: String, var department: String, var salary: Double) {
    private val _subordinates = mutableListOf<Employee>()

    val subordinates
        get() = this._subordinates.toList()

    fun add(employee: Employee) = this._subordinates.add(employee)

    fun remove(employee: Employee) = this._subordinates.remove(employee)
}