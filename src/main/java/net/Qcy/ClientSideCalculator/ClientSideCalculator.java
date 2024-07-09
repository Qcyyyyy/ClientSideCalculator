package net.Qcy.ClientSideCalculator;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.logging.LogUtils;

import net.Qcy.ClientSideCalculator.KeyBinding.CalcOpenBinding;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Lazy;

@Mod(ClientSideCalculator.MODID)
public class ClientSideCalculator {
    public static final String MODID = "clientsidecalculator";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final Lazy<KeyMapping> CALCKEYMAPPING = Lazy
            .of(() -> new KeyMapping("key.clientsidecalculator.calckeymap", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G,
                    "key.categories.ClientSideCalc"));

    public ClientSideCalculator() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        // Register client-side event bus subscriber
        modEventBus.register(ClientModEvents.class);

        // Register to the Minecraft Forge event bus
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new CalcOpenBinding());
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // This can be used for common setup if needed in the future
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }

        @SubscribeEvent
        public static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
            // Register the key mapping
            event.register(CALCKEYMAPPING.get());
        }
    }
}