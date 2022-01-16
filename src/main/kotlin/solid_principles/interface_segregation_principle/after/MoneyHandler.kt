package solid_principles.interface_segregation_principle.after

interface MoneyHandler {
    fun getMoney(amount: Double): List<Money>

    fun addMoney(money: Iterable<Money>)
}

class MoneyHandlerImpl(money: Collection<Money>): MoneyHandler {
    val money = money.toMutableList()

    override fun getMoney(amount: Double): List<Money> {
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

    override fun addMoney(money: Iterable<Money>) {
        this.money.addAll(money)
    }
}