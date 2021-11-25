package nucleus.common.registrar.builtin.content

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import nucleus.common.registrar.type.IdRegistrar

open class ToolMaterialRegistrar(override val group: ContentGroup) : IdRegistrar<ToolMaterial>(group) {
    open fun entryOf(
        miningLevel: Int,
        durability: Int,
        miningSpeedMultiplier: Float,
        attackDamage: Float,
        enchantability: Int,
        repairIngredient: () -> Ingredient
    ): ToolMaterialEntry {
        return ToolMaterialEntry(miningLevel, durability, miningSpeedMultiplier, attackDamage, enchantability, repairIngredient)
    }
}