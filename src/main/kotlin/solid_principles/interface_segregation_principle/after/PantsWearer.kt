package solid_principles.interface_segregation_principle.after

interface PantsWearer {
    val pants: Pants
}

class PantsWearerImpl(override val pants: Pants) : PantsWearer