package nucleus.common.builtin.division.content

import net.minecraft.recipe.RecipeType
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.type.VanillaRegistrar

open class RecipeTypeRegistrar<R : ModRoot<R>>(root: R) : VanillaRegistrar<RecipeType<*>, R>(root, Registry.RECIPE_TYPE)