package nucleus.common.registrar.base.vanilla

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.member.Member
import nucleus.common.registrar.base.member.TypedMemberRegistrar

abstract class TypedVanillaRegistrar<V, M : Member<V>>(
    namespace: String,
    override val vanillaRegistry: Registry<V>
) : TypedMemberRegistrar<V, M>(namespace), VanillaRegistrar<V> {
    override fun publish(key: Identifier, value: V): V {
        return super.publish(key, value).also {
            registerToVanilla(key, value)
        }
    }
}