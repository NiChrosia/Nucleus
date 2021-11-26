package nucleus.common.member

import nucleus.common.division.RegistrarRoot
import nucleus.common.registrar.Registrar

open class Member<K, V, T : V, R : RegistrarRoot<R>>(val root: R, open val registrar: Registrar<K, V, R>, val key: K, val provider: (K) -> T) : Lazy<T> by lazy({ provider(key) }) {
    init {
        root.register.listeners.add {
            register()
        }
    }

    open fun register() {
        registrar.register(key, value)
    }
}