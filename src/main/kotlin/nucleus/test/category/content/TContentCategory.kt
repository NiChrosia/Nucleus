package nucleus.test.category.content

import nucleus.common.registrar.category.RegistrarCategory

open class TContentCategory(namespace: String) : RegistrarCategory(namespace) {
    val block by registrar(::TBlockRegistrar)
    val item by registrar(::TItemRegistrar)
}