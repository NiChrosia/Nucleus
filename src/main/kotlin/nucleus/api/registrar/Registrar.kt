package nucleus.api.registrar

import net.minecraft.util.Identifier

interface Registrar<T> {
    fun <V : T> register(key: Identifier, value: V): V

    operator fun get(key: Identifier): T
}