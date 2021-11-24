package nucleus.common.registrar.type.content.world

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.SimpleVanillaRegistrar

open class StatusEffectRegistrar(namespace: String) : SimpleVanillaRegistrar<StatusEffect>(namespace, Registry.STATUS_EFFECT)