package nucleus.common.api.registrar.capability

import net.minecraft.util.Identifier

/** A registrar capability that allows value-to-key identification. */
interface Reversible<T> {
    fun identify(value: T): Identifier

    fun noKeyFound(value: T): IllegalArgumentException {
        return IllegalArgumentException("No such key found for given value '$value.'")
    }
}