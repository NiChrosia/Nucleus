package nucleus.common.member

import net.minecraft.util.Identifier
import nucleus.common.division.RegistrarRoot
import nucleus.common.registrar.Registrar

/** The core of registering individual content entries. */
open class Member<K, V, T : V, R : RegistrarRoot<R>>(
    /** The root reference. Used for adding listeners to dispatcher phases. */
    val root: R,
    /** The registrar reference. Used for registering content to them during the register phase. */
    open val registrar: Registrar<K, V, R>,
    /** The key. Typically an [Identifier]. */
    val key: K,
    /** The provider for the content, used to make this object initialize lazily. */
    val provider: (K) -> T
) : Lazy<T> by lazy({ provider(key) }) {
    init {
        root.dispatcher.register.listeners.add {
            register()
        }
    }

    /** Method for adding contained content to the registrar reference. */
    open fun register() {
        registrar.register(key, value)
    }
}