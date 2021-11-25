package nucleus.common.registrar.builtin.content

import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.member.type.BlockMember
import nucleus.common.registrar.type.VanillaRegistrar

open class BlockRegistrar(override val group: ContentGroup) : VanillaRegistrar<Block>(group, Registry.BLOCK) {
    override fun <T : Block> member(key: Identifier, provider: (Identifier) -> T) = BlockMember(this, key, provider).also(members::add)
    override fun <T : Block> member(path: String, provider: (Identifier) -> T) = member(group.identify(path), provider)
}