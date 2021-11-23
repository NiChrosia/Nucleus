package nucleus.common.registrar.type.content.world

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.VanillaRegistrar

open class StatusEffectRegistrar(namespace: String) : VanillaRegistrar<StatusEffect>(Registry.STATUS_EFFECT, namespace) {
}