package nucleus.client.registrar.builtin.content

import nucleus.common.registrar.category.RegistrarCategory

open class ClientContentCategory(namespace: String) : RegistrarCategory(namespace) {
    val screen by registrar(::ScreenRegistrar)
}