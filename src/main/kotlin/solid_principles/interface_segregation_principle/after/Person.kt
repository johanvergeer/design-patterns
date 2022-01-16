package solid_principles.interface_segregation_principle.after

class Person(
    moneyHandler: MoneyHandler,
    pantsWearer: PantsWearer,
    underwearWearer: UnderwearWearer,
    shirtWearer: ShirtWearer
) : MoneyHandler by moneyHandler,
    PantsWearer by pantsWearer,
    UnderwearWearer by underwearWearer,
    ShirtWearer by shirtWearer