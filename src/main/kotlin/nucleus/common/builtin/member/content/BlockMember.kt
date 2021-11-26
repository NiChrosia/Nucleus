package nucleus.common.builtin.member.content

import net.devtech.arrp.json.models.JModel
import net.devtech.arrp.json.models.JTextures
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.division.content.BlockRegistrar
import nucleus.common.extension.split
import nucleus.common.extension.within
import nucleus.common.member.PublicationMember

open class BlockMember<T : Block, R : ModRoot<R>>(
    root: R,
    registrar: BlockRegistrar<R>,
    key: Identifier,
    provider: (Identifier) -> T
) : PublicationMember<Identifier, Block, T, R>(root, registrar, key, provider), LangMember<R>, TransitionMember<R>, ModelMember<R>, BlockstateMember<R>, TagMember<R> {
    override val langCategory = "block"
    override val modelFolder = "block"

    open fun omnidirectionalModel(): JModel {
        val textures = JTextures()
        textures.`var`("all", key.within(modelFolder).split())

        val model = JModel()
        model.parent("block/cube_all")
        model.textures(textures)

        return model
    }
}