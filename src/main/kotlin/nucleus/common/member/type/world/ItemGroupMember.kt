package nucleus.common.member.type.world

import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.member.base.ContentLangMember

open class ItemGroupMember(pack: RegistrarPack, ID: Identifier, provider: (Identifier) -> ItemGroup) : ContentLangMember<ItemGroup>("itemGroup", pack, ID, provider) {
    override fun toReadable(ID: Identifier): String {
        return ID.namespace.capitalize()
    }

    open fun toReadableWithPath(ID: Identifier): String {
        return "${toReadable(ID)}: ${ID.path.capitalize()}"
    }

    override fun readableEnglishLang() {
        return readableEnglishLang(false)
    }

    open fun readableEnglishLang(withPath: Boolean = false) {
        lang(if (withPath) toReadableWithPath(ID) else toReadable(ID))
    }
}