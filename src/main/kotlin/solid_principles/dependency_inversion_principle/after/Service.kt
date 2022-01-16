package solid_principles.dependency_inversion_principle.after

class Service(private val storage: Storage) {
    fun doSomething() {}
}
