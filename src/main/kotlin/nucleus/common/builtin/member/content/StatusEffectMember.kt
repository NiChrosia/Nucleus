package nucleus.common.builtin.member.content

import net.minecraft.entity.effect.StatusEffect
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.division.content.StatusEffectRegistrar
import nucleus.common.member.PublicationMember

open class StatusEffectMember<T : StatusEffect, R : ModRoot<R>>(
    root: R,
    registrar: StatusEffectRegistrar<R>,
    key: Identifier,
    provider: (Identifier) -> T
) : PublicationMember<Identifier, StatusEffect, T, R>(root, registrar, key, provider), LangMember<R> {
    override val langCategory = "effect"
}