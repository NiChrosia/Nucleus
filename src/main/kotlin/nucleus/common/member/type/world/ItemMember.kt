package nucleus.common.member.type.world

import net.minecraft.item.Item
import net.minecraft.util.Identifier
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.member.base.ContentLangMember

open class ItemMember(pack: RegistrarPack, ID: Identifier, provider: (Identifier) -> Item) : ContentLangMember<Item>("item", pack, ID, provider)