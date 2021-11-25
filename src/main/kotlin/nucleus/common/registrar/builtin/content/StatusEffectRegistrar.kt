package nucleus.common.registrar.builtin.content

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.type.VanillaRegistrar

open class StatusEffectRegistrar(override val group: ContentGroup) : VanillaRegistrar<StatusEffect>(group, Registry.STATUS_EFFECT)