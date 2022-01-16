package solid_principles.dependency_inversion_principle.after

fun main() {
    val storage = createStorage()

    val service = Service(storage)

    service.doSomething()
}
