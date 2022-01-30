package solid_principles.open_closed_principle.after

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

interface PaymentMethod {
    fun acceptPayment(amount: Money): Payment
}

class CashPaymentMethod : PaymentMethod {
    override fun acceptPayment(amount: Money): Payment {
        println("Putting the money in the cash drawer")
        return Payment(amount)
    }
}

class CreditCardPaymentMethod : PaymentMethod {

    override fun acceptPayment(amount: Money): Payment {
        println("Adding the money to my bank account")
        return Payment(amount)
    }
}

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

fun checkOut(receipt: Receipt, items: Iterable<Item>, paymentMethod: PaymentMethod) {
    val total = Money.zero()

    items.forEach { item ->
        total += item.price
        receipt.addItem(item)
    }

    val payment = paymentMethod.acceptPayment(total)
    receipt.addPayment(payment)
}
