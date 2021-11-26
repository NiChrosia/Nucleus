package nucleus.common.extension

import net.minecraft.util.Identifier
import net.minecraft.util.registry.SimpleRegistry

fun <T> SimpleRegistry<T>.getIdOrNull(value: T): Identifier? {
    return this.idToEntry.inverse()[value]
}