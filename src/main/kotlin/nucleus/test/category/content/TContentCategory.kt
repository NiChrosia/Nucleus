package nucleus.test.category.content

import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.registrar.category.RegistrarCategory

open class TContentCategory(namespace: String, pack: RegistrarPack) : RegistrarCategory(namespace, pack) {
    val block by registrar(::TBlockRegistrar)
    val item by registrar(::TItemRegistrar)

    val itemGroup by registrar(::TItemGroupRegistrar)
}