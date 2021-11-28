package nucleus.common.builtin.member.content

import net.devtech.arrp.json.loot.JCondition
import net.devtech.arrp.json.loot.JEntry
import net.devtech.arrp.json.loot.JLootTable
import net.devtech.arrp.json.loot.JPool
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.extension.getIdOrNull
import nucleus.common.extension.split
import nucleus.common.extension.within

interface LootableMember<R : ModRoot<R>> {
    val root: R
    val key: Identifier

    fun blockLoot(block: Identifier): Pair<Identifier, JLootTable> {
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

        return block to table
    }

    fun blockLoot(block: Block): Pair<Identifier, JLootTable> {
        return blockLoot(root.content.block.identify(block) ?: Registry.BLOCK.getIdOrNull(block) ?: throw IllegalArgumentException("Given block is not registered."))
    }

    fun loot(provider: () -> Pair<Identifier, JLootTable>) {
        root.dispatcher.datagen.listeners.add {
            val (blockId, table) = provider()

            it.pack.addLootTable(blockId.within("blocks"), table)
        }
    }
}