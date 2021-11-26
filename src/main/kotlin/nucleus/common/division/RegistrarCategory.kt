package nucleus.common.division

import nucleus.common.registrar.Registrar

open class RegistrarCategory<R : RegistrarRoot<R>>(val root: R) {
    val categories = mutableListOf<RegistrarCategory<R>>()
    val registrars = mutableListOf<Registrar<*, *, R>>()

    open fun <T : RegistrarCategory<R>> T.collected(): T {
        return also(this@RegistrarCategory.categories::add)
    }

    open fun <K, V, T : Registrar<K, V, R>> T.collected(): T {
        return also(registrars::add)
    }
}