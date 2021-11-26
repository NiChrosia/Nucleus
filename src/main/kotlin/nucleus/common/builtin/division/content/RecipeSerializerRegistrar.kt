package nucleus.common.builtin.division.content

import net.minecraft.recipe.RecipeSerializer
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.type.VanillaRegistrar

open class RecipeSerializerRegistrar<R : ModRoot<R>>(root: R) : VanillaRegistrar<RecipeSerializer<*>, R>(root, Registry.RECIPE_SERIALIZER)