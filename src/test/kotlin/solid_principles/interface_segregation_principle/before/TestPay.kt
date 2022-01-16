package solid_principles.interface_segregation_principle.before

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestPay {
    @Test
    fun testPay() {
        val money1 = Money(10.0)
        val money2 = Money(5.0)

        val money = listOf(money1, money2)

        val pants = Pants()
        val underwear = Underwear()
        val shirt = Shirt()

        val person = Person(money, pants, underwear, shirt)

        val receivedMoney = pay(person, 15.0)

        assertEquals(receivedMoney, listOf(money1, money2))

        assertTrue { person.money.isEmpty() }
    }
}
