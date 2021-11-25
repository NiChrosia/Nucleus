package nucleus.common.member.type

import net.devtech.arrp.json.loot.JCondition
import net.devtech.arrp.json.loot.JEntry
import net.devtech.arrp.json.loot.JLootTable
import net.devtech.arrp.json.loot.JPool
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import nucleus.common.extension.split
import nucleus.common.extension.throwMissingEntryException
import nucleus.common.extension.within
import nucleus.common.member.Member
import nucleus.common.registrar.builtin.content.ItemRegistrar

interface LootableMember<T : Item> {
    val registrar: ItemRegistrar
    val datagenListeners: MutableList<Member<Identifier, Item, T>.() -> Unit>
    val key: Identifier

    fun itemLoot(block: Identifier): TableEntry {
        val entry = JEntry()
        entry.type("minecraft:item")
        entry.name(key.split())

        val condition = JCondition("minecraft:survives_explosion")

        val pool = JPool()
        pool.rolls(1)
        pool.entry(entry)
        pool.condition(condition)

        val table = JLootTable("minecraft:block")
        table.pool(pool)

        return TableEntry(block, table)
    }

    fun <T : Block> itemLoot(block: T): TableEntry {
        return itemLoot(registrar.group.block.identify(block) ?: throwMissingEntryException())
    }

    fun loot(provider: () -> TableEntry) {
        datagenListeners.add {
            val table = provider()
            registrar.group.pack.addLootTable(table.blockId.within("blocks"), table.table)
        }
    }

    open class TableEntry(val blockId: Identifier, val table: JLootTable)
}