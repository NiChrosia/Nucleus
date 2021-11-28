package nucleus.common.builtin.division.content

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.member.content.StatusEffectMember
import nucleus.common.registrar.type.VanillaRegistrar

open class StatusEffectRegistrar<R : ModRoot<R>>(root: R) : VanillaRegistrar<StatusEffect, R>(root, Registry.STATUS_EFFECT) {
    override fun <T : StatusEffect> memberOf(
        key: Identifier,
        provider: (Identifier) -> T
    ): StatusEffectMember<T, R> {
        return StatusEffectMember(root, this, key, provider)
    }
}