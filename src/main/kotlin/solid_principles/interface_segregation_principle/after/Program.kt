package solid_principles.interface_segregation_principle.after

class OutOfFundsError : Exception()

class Pants

interface PantsWearer {
    val pants: Pants
}

class PantsWearerImpl(override val pants: Pants) : PantsWearer

class Shirt

interface ShirtWearer {
    val shirt: Shirt
}

class ShirtWearerImpl(override val shirt: Shirt) : ShirtWearer

class Underwear

interface UnderwearWearer {
    val underwear: Underwear
}

class UnderwearWearerImpl(override val underwear: Underwear) : UnderwearWearer

data class Money(val amount: Double)

interface MoneyHandler {
    fun getMoney(amount: Double): List<Money>

    fun addMoney(money: Iterable<Money>)
}

class HumanMoneyHandler(vararg money: Money) : MoneyHandler {
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

class Person(
    moneyHandler: MoneyHandler,
    pantsWearer: PantsWearer,
    underwearWearer: UnderwearWearer,
    shirtWearer: ShirtWearer
) : MoneyHandler by moneyHandler,
    PantsWearer by pantsWearer,
    UnderwearWearer by underwearWearer,
    ShirtWearer by shirtWearer

fun pay(person: MoneyHandler, amount: Double): List<Money> {
    return person.getMoney(amount)
}

fun main() {
    val person = Person(
        HumanMoneyHandler(Money(10.0), Money(10.0), Money(5.0)),
        PantsWearerImpl(Pants()),
        UnderwearWearerImpl(Underwear()),
        ShirtWearerImpl(Shirt())
    )

    val payment = pay(person, 20.0)

    println(payment)
}
