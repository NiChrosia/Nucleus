package nucleus.common.impl.registrar.template

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.util.registry.Registry
import nucleus.common.impl.registrar.MinecraftRegistrar

open class StatusEffectRegistrar(namespace: String) : MinecraftRegistrar<StatusEffect>(Registry.STATUS_EFFECT, namespace)