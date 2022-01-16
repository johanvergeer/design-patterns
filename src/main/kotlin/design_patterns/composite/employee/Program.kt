package design_patterns.composite.employee

fun main() {
    val ceo = Employee("John", "CEO", 300_000.0)
    val headSales = Employee("Robert", "Head Sales", 200_000.0)
    val headMarketing = Employee("Michael", "Head Marketing", 200_000.0)

    val clerk1 = Employee("Laura", "Marketing", 100_000.0)
    val clerk2 = Employee("Bob", "Marketing", 100_000.0)

    val salesExecutive1 = Employee("Richard", "Sales", 100_000.0)
    val salesExecutive2 = Employee("Rob", "Sales", 100_000.0)

    ceo.add(headSales)
    ceo.add(headMarketing)

    headSales.add(salesExecutive1)
    headSales.add(salesExecutive2)

    headMarketing.add(clerk1)
    headMarketing.add(clerk2)

    printEmployeeWithSubordinates(ceo)
}

fun printEmployeeWithSubordinates(employee: Employee) {
    println(employee)

    employee.subordinates.forEach(::printEmployeeWithSubordinates)
}
