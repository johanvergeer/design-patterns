package solid_principles.interface_segregation_principle.before

class Person(
    money: Collection<Money>,
    val pants: Pants,
    val underwear: Underwear,
    val shirt: Shirt
) {
    val money = money.toMutableList()

    fun getMoney(amount: Double): List<Money> {
        val moneyToGive = mutableListOf<Money>()
        var remainingAmount = amount

        for (m in this.money.sortedByDescending { m -> m.amount }) {
            if (remainingAmount <= 0) break

            moneyToGive.add(m)
            this.money.remove(m)

            remainingAmount -= m.amount
        }

        if (remainingAmount > 0.0) throw OutOfFundsError()

        return moneyToGive
    }

    fun addMoney(money: Iterable<Money>) {
        this.money.addAll(money)
    }
}