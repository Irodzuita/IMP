package com.irodzuita.imp.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class FreyaxOre extends Block {

    public FreyaxOre() {
        super(Properties.create(Material.IRON)
            .harvestLevel(5)
            .hardnessAndResistance(3.0f)
            .sound(SoundType.STONE)
        );
        setRegistryName("freyaxore");
    }
}
