package nucleus.common.member.type.world

import net.minecraft.block.Block
import net.minecraft.util.Identifier
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.member.base.ContentLangMember

open class BlockMember(pack: RegistrarPack, ID: Identifier, provider: (Identifier) -> Block) : ContentLangMember<Block>("block", pack, ID, provider)