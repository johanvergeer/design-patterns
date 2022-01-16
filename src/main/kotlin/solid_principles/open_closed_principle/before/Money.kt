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