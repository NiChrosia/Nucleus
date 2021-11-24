package nucleus.common.registrar.type.content.world.block

import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.member.type.world.BlockMember
import nucleus.common.registrar.base.datagen.PackRegistrar
import nucleus.common.registrar.base.vanilla.TypedVanillaRegistrar

open class BlockRegistrar(
    namespace: String,
    override val pack: RegistrarPack
) : TypedVanillaRegistrar<Block, BlockMember>(namespace, Registry.BLOCK), PackRegistrar {
    override val member: (Identifier, (Identifier) -> Block) -> BlockMember = { ID, provider ->
        BlockMember(pack, ID, provider)
    }
}