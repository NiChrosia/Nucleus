package nucleus.common.builtin.division.content

import net.minecraft.block.Material
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.Registrar

open class MaterialRegistrar<R : ModRoot<R>>(root: R) : Registrar<Identifier, Material, R>(root)