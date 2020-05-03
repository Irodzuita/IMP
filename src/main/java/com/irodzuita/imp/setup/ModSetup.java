package com.irodzuita.imp.setup;

import com.irodzuita.imp.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModSetup {

    public ItemGroup itemGroup = new ItemGroup("imp") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.TESTBLOCK);
        }
    };

    public void init() {

    }
}
