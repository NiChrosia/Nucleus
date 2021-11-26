package nucleus.common.builtin.division.content

import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient

open class ToolMaterialEntry(
    @JvmField
    val miningLevel: Int,
    @JvmField
    val durability: Int,
    @JvmField
    val miningSpeedMultiplier: Float,
    @JvmField
    val attackDamage: Float,
    @JvmField
    val enchantability: Int,
    repairIngredient: () -> Ingredient
) : ToolMaterial {
    val repairIngredient = lazy(repairIngredient)

    override fun getDurability(): Int {
        return durability
    }

    override fun getMiningSpeedMultiplier(): Float {
        return miningSpeedMultiplier
    }

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
        return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.value
    }
}