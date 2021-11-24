package nucleus.common.registrar.base.vanilla

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.member.MemberRegistrar

open class SimpleVanillaRegistrar<V>(
    namespace: String,
    override val vanillaRegistry: Registry<V>
) : MemberRegistrar<V>(namespace), VanillaRegistrar<V> {
    override fun publish(key: Identifier, value: V): V {
        return super.publish(key, value).also {
            registerToVanilla(key, value)
        }
    }
}