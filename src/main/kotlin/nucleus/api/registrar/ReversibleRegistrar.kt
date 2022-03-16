package nucleus.api.registrar

import net.minecraft.util.Identifier

interface ReversibleRegistrar<T> : Registrar<T> {
    fun identify(value: T): Identifier
}