package solid_principles.open_closed_principle.before

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
