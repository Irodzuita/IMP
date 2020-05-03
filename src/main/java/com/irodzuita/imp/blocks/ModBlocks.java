package com.irodzuita.imp.blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModBlocks {

    @ObjectHolder("imp:testblock")
    public static TestBlock TESTBLOCK;

    @ObjectHolder("imp:freyaxore")
    public static FreyaxOre FREYAXORE;

    @ObjectHolder("imp:glowglass")
    public static GlowGlass GLOWGLASS;

    @ObjectHolder("imp:dirtgenerator")
    public static DirtGenerator DIRTGENERATOR;

    @ObjectHolder("imp:dirtgenerator")
    public static TileEntityType<DirtGeneratorTile> DIRTGENERATOR_TILE;

}
