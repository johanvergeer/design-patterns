package solid_principles.interface_segregation_principle.before

fun pay(person: Person, amount: Double): List<Money> {
    return person.getMoney(amount)
}
