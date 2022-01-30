package solid_principles.open_closed_principle.before

class Money private constructor() {
    var amount: Double = 0.0
        private set

    companion object {
        fun zero() = Money()
    }

    operator fun plusAssign(amount: Double) {
        this.amount += amount
    }
}

data class Payment(val total: Money)

data class Item(val price: Double)

class Receipt {
    private var items = mutableListOf<Item>()
    private var payments = mutableListOf<Payment>()

    fun addItem(item: Item) {
        this.items.add(item)
    }

    fun addPayment(payment: Payment) {
        this.payments.add(payment)
    }
}

fun acceptCash(total: Money) = Payment(total)

fun checkOut(receipt: Receipt, items: Iterable<Item>) {
    val total = Money.zero()

    items.forEach { item ->
        total += item.price
        receipt.addItem(item)
    }

    val payment = acceptCash(total)
    receipt.addPayment(payment)
}
