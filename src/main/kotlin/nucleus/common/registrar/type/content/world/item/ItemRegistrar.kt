package nucleus.common.registrar.type.content.world.item

import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.member.type.world.ItemMember
import nucleus.common.registrar.base.datagen.PackRegistrar
import nucleus.common.registrar.base.vanilla.TypedVanillaRegistrar

open class ItemRegistrar(
    namespace: String,
    override val pack: RegistrarPack
) : TypedVanillaRegistrar<Item, ItemMember>(namespace, Registry.ITEM), PackRegistrar {
    override val member = { ID: Identifier, provider: (Identifier) -> Item ->
        ItemMember(pack, ID, provider)
    }
}