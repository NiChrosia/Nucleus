package nucleus.common.member.type

import net.devtech.arrp.json.models.JModel
import net.devtech.arrp.json.models.JTextures
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import nucleus.common.extension.split
import nucleus.common.extension.throwMissingEntryException
import nucleus.common.extension.within
import nucleus.common.member.Member
import nucleus.common.registrar.builtin.content.ItemRegistrar

open class ItemMember<T : Item>(
    override val registrar: ItemRegistrar,
    key: Identifier,
    provider: (Identifier) -> T
) : Member<Identifier, Item, T>(registrar, key, provider), LangMember<Item, T>, ModelMember<Item, T>, LootableMember<T>, TagMember<Item, T>, TransitionalMember<Item, T> {
    override val group = registrar.group
    override val category = "item"
    override val folder = "item"

    open fun generatedModel(): JModel {
        val textures = JTextures()
        textures.layer0(key.within(folder).split())

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

    open fun <T : Block> blockModel(block: T): JModel {
        return blockModel(registrar.group.block.identify(block) ?: throwMissingEntryException())
    }
}