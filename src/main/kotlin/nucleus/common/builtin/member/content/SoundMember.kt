package nucleus.common.builtin.member.content

import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.division.content.SoundRegistrar
import nucleus.common.member.PublicationMember

open class SoundMember<T : SoundEvent, R : ModRoot<R>>(
    root: R,
    registrar: SoundRegistrar<R>,
    key: Identifier,
    provider: (Identifier) -> T
) : PublicationMember<Identifier, SoundEvent, T, R>(root, registrar, key, provider), LangMember<R> {
    override val langCategory = "subtitles"
}