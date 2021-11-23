package nucleus.common.registrar.base.vanilla

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.member.MemberRegistrar

open class VanillaRegistrar<V>(val vanillaRegistry: Registry<V>, namespace: String) : MemberRegistrar<V>(namespace) {
    override fun publish(key: Identifier, value: V): V {
        return super.publish(key, value).also {
            Registry.register(vanillaRegistry, key, value)
        }
    }
}