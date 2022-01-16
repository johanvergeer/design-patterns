package solid_principles.open_closed_principle.after

interface PaymentMethod {
    fun acceptPayment(amount: Money): Payment
}

class CashPaymentMethod : PaymentMethod {
    override fun acceptPayment(amount: Money) = Payment(amount)
}

class CreditCardPaymentMethod : PaymentMethod {
    override fun acceptPayment(amount: Money) = Payment(amount)
}
