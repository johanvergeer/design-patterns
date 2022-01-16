package solid_principles.single_responsibility_principle.after

class ProductRepository {
    private val products = mutableSetOf<Product>()


    fun add(product: Product) {
        if (products.contains(product)) {
            throw Exception("Product with id '${product.id}' already exists")
        }
        this.products.add(product)
    }

    fun exists(product: Product): Boolean {
        return this.products.contains(product)
    }

    fun update(product: Product) {
        if (!products.contains(product)) {
            throw Exception("Product with id '${product.id}' does not exist yet")
        }
        this.products.add(product)
    }

    fun all(): Set<Product> {
        return this.products
    }
}
