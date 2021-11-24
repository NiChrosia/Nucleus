package nucleus.common.registrar.base.vanilla

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

interface VanillaRegistrar<T> {
    val vanillaRegistry: Registry<T>

    fun registerToVanilla(key: Identifier, value: T): T {
        return Registry.register(vanillaRegistry, key, value)
    }
}