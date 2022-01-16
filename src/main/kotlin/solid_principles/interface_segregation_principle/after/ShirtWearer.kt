package solid_principles.interface_segregation_principle.after

interface ShirtWearer {
    val shirt: Shirt
}

class ShirtWearerImpl(override val shirt: Shirt) : ShirtWearer
