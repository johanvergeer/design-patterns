package solid_principles.open_closed_principle.before


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