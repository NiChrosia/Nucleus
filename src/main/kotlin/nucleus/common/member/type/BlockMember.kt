package nucleus.common.member.type

import net.devtech.arrp.json.models.JModel
import net.devtech.arrp.json.models.JTextures
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import nucleus.common.extension.split
import nucleus.common.extension.within
import nucleus.common.member.Member
import nucleus.common.registrar.builtin.content.BlockRegistrar

open class BlockMember<T : Block>(
    override val registrar: BlockRegistrar,
    key: Identifier,
    provider: (Identifier) -> T
) : Member<Identifier, Block, T>(registrar, key, provider), LangMember<Block, T>, ModelMember<Block, T>, BlockstateMember<T>, TagMember<Block, T>, TransitionalMember<Block, T> {
    override val group = registrar.group
    override val category = "block"
    override val folder = "block"

    open fun omnidirectionalModel(): JModel {
        val textures = JTextures()
        textures.`var`("all", key.within(folder).split())

        val model = JModel()
        model.parent("block/cube_all")
        model.textures(textures)

        return model
    }
}