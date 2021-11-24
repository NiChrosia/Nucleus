package nucleus.common.member.base

import net.minecraft.util.Identifier
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.member.Member

abstract class PackMember<V>(val pack: RegistrarPack, ID: Identifier, provider: (Identifier) -> V) : Member<V>(ID, provider)