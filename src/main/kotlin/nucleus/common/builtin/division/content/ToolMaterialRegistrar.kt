package nucleus.common.builtin.division.content

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.Registrar

open class ToolMaterialRegistrar<R : ModRoot<R>>(root: R) : Registrar<Identifier, ToolMaterial, R>(root) {
    open fun toolMaterialOf(
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