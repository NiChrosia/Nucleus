package nucleus.common.builtin.division.content

import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.member.content.BlockMember
import nucleus.common.registrar.type.VanillaRegistrar

open class BlockRegistrar<R : ModRoot<R>>(root: R) : VanillaRegistrar<Block, R>(root, Registry.BLOCK) {
    override fun <T : Block> memberOf(key: Identifier, provider: (Identifier) -> T): BlockMember<T, R> {
        return BlockMember(root, this, key, provider)
    }
}