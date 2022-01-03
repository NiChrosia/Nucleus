package nucleus.common.test.content

import net.minecraft.util.Identifier
import nucleus.common.builtin.division.content.TagRegistrar
import nucleus.common.test.NucleusTest

open class TTagRegistrar(root: NucleusTest) : TagRegistrar<NucleusTest>(root) {
    val pickaxeMineable by memberOf(Identifier("minecraft", "pickaxe_mineable")) { tagOf(it) }
    val requiresMiningLevel4 by memberOf(Identifier("fabric", "requires_tool_level_4")) { tagOf(it) }
}