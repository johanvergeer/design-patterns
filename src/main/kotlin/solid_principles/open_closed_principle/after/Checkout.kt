package solid_principles.open_closed_principle.after

fun checkOut(receipt: Receipt, items: Iterable<Item>, paymentMethod: PaymentMethod) {
    val total = Money.zero()

    items.forEach { item ->
        total += item.price
        receipt.addItem(item)
    }

    val payment = paymentMethod.acceptPayment(total)
    receipt.addPayment(payment)
}
