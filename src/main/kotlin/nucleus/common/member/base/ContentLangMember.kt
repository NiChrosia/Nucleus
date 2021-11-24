package nucleus.common.member.base

import net.minecraft.util.Identifier
import nucleus.common.datagen.lang.RegistrarPack

/** A member for a piece of content that can be identified by translatable text. */
open class ContentLangMember<T>(override val category: String, pack: RegistrarPack, ID: Identifier, provider: (Identifier) -> T) : PackMember<T>(pack, ID, provider), LangMember