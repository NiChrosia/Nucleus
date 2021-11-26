package nucleus.test.content

import net.minecraft.util.Identifier
import nucleus.common.Nucleus
import nucleus.common.builtin.division.content.TagRegistrar

open class TTagRegistrar(root: Nucleus) : TagRegistrar<Nucleus>(root) {
    val pickaxeMineable by memberOf(Identifier("minecraft", "pickaxe_mineable")) { tagOf(it) }
    val requiresMiningLevel4 by memberOf(Identifier("fabric", "requires_tool_level_4")) { tagOf(it) }
}