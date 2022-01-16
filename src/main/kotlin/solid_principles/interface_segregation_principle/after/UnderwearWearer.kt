package solid_principles.interface_segregation_principle.after

interface UnderwearWearer {
    val underwear: Underwear
}

class UnderwearWearerImpl(override val underwear: Underwear) : UnderwearWearer
