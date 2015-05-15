package io.github.thelonedevil.bosstest;

import io.github.thelonedevil.bosstest.entity.FirstBoss;
import io.github.thelonedevil.bosstest.entity.SecondBoss;
import io.github.thelonedevil.bosstest.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.Random;

@Mod(modid = BossTestMod.MODID)
public class BossTestMod {
    public static final String MODID = "bosstest";
    @Mod.Instance(MODID)
    public static BossTestMod instance;

    @SidedProxy(clientSide = "io.github.thelonedevil.bosstest.proxy.ClientProxy", serverSide = "io.github.thelonedevil.bosstest.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs Tab = new CreativeTabs(MODID) {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.bedrock);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        registerEntity(FirstBoss.class, MODID + ":FirstBoss");
        registerEntity(SecondBoss.class, MODID + ":SecondBoss");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.registerRenderers();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @SuppressWarnings("unchecked")
    public static void registerEntity(Class entityClass, String name) {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityList.entityEggs.put(entityID, new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }

    @SuppressWarnings("unchecked")
    public static void registerEntity(Class entityClass, String name, int primaryColor, int secondaryColor) {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityList.entityEggs.put(entityID, new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
}
