package nucleus.common.builtin.member.content

import net.devtech.arrp.json.models.JModel
import net.devtech.arrp.json.models.JTextures
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.division.content.ItemRegistrar
import nucleus.common.extension.getIdOrNull
import nucleus.common.extension.split
import nucleus.common.extension.within
import nucleus.common.member.PublicationMember

open class ItemMember<T : Item, R : ModRoot<R>>(
    root: R,
    registrar: ItemRegistrar<R>,
    key: Identifier,
    provider: (Identifier) -> T
) : PublicationMember<Identifier, Item, T, R>(root, registrar, key, provider), LangMember<R>, TransitionMember<R>, ModelMember<R>, LootableMember<R>, TagMember<R> {
    override val langCategory = "item"
    override val modelFolder = "item"

    open fun generatedModel(): JModel {
        val textures = JTextures()
        textures.layer0(key.within(modelFolder).split())

        val model = JModel()
        model.parent("item/generated")
        model.textures(textures)

        return model
    }

    open fun blockModel(block: Identifier): JModel {
        val model = JModel()
        model.parent(block.within("block").split())

        return model
    }

    open fun blockModel(block: Block): JModel {
        return blockModel(root.content.block.identify(block) ?: Registry.BLOCK.getIdOrNull(block) ?: throw IllegalArgumentException("Given block is not registered."))
    }
}