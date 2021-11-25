package nucleus.test.group.tag

import nucleus.common.extension.with
import nucleus.common.registrar.builtin.tag.BlockTagRegistrar

open class TBlockTagRegistrar(override val group: TTagGroup) : BlockTagRegistrar(group) {
    open val pickaxeMineable by member("minecraft" with "mineable/pickaxe") { entryOf(it) }
    open val needsToolLevel4 by member("fabric" with "needs_tool_level_4") { entryOf(it) }
}