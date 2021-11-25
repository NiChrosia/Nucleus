package nucleus.common.member

import nucleus.common.registrar.Registrar
import nucleus.common.registrar.RegistrarStage

open class Member<K, V, T : V>(open val registrar: Registrar<K, V>, val key: K, val provider: (K) -> T) : RegistrarStage.User(), Lazy<T> by lazy({ provider(key) }) {
    val registrationListeners = mutableListOf<Member<K, V, T>.() -> Unit>()
    val datagenListeners = mutableListOf<Member<K, V, T>.() -> Unit>()

    override fun register() {
        super.register()

        registrar.register(key, value)
        registrationListeners.forEach { it(this) }
    }

    override fun datagen() {
        super.datagen()

        datagenListeners.forEach { it(this) }
    }

    @Suppress("unused") // used in abstract shadowing
    open fun onDatagen(action: Member<K, V, T>.() -> Unit) {
        datagenListeners.add(action)
    }
}