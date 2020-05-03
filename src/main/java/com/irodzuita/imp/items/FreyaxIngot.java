package com.irodzuita.imp.items;

import com.irodzuita.imp.Imp;
import com.sun.org.apache.bcel.internal.generic.IMPDEP1;
import net.minecraft.item.Item;

public class FreyaxIngot extends Item {
    public FreyaxIngot() {
        super(new Item.Properties()
            .group(Imp.setup.itemGroup)
            .maxStackSize(64)
        );
        setRegistryName("freyaxingot");
    }
}
