package com.irodzuita.imp;

import com.irodzuita.imp.blocks.*;
import com.irodzuita.imp.items.FreyaxIngot;
import com.irodzuita.imp.setup.ClientProxy;
import com.irodzuita.imp.setup.IProxy;
import com.irodzuita.imp.setup.ModSetup;
import com.irodzuita.imp.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("imp")
public class Imp {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public Imp() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new TestBlock());
            event.getRegistry().register(new FreyaxOre());
            event.getRegistry().register(new DirtGenerator());
            GlowGlass obj = new GlowGlass();
            event.getRegistry().register(obj);
            RenderTypeLookup.setRenderLayer(obj, RenderType.func_228645_f_());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);
            event.getRegistry().register(new BlockItem(ModBlocks.TESTBLOCK, properties).setRegistryName("testblock"));
            event.getRegistry().register(new BlockItem(ModBlocks.FREYAXORE, properties).setRegistryName("freyaxore"));
            event.getRegistry().register(new BlockItem(ModBlocks.GLOWGLASS, properties).setRegistryName("glowglass"));
            event.getRegistry().register(new BlockItem(ModBlocks.DIRTGENERATOR, properties).setRegistryName("dirtgenerator"));
            event.getRegistry().register(new FreyaxIngot());
        }

        @SubscribeEvent
        public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
            event.getRegistry().register(TileEntityType.Builder.create(DirtGeneratorTile::new, ModBlocks.DIRTGENERATOR).build(null).setRegistryName("dirtgenerator"));
        }
    }
}
