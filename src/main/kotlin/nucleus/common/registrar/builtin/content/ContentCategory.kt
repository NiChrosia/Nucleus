package nucleus.common.registrar.builtin.content

import nucleus.common.registrar.category.RegistrarCategory

/** The subcategory for content registrars, e.g. items, blocks, etc. */
open class ContentCategory(namespace: String) : RegistrarCategory(namespace) {
    val block by registrar(::BlockRegistrar)
    val item by registrar(::ItemRegistrar)

    val screenType by registrar(::ScreenTypeRegistrar)
}