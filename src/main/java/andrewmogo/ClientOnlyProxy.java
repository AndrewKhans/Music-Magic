package andrewmogo;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

/**
 * ClientProxy is used to set up the mod and start it running on normal minecraft.  It contains all the code that should run on the
 *   client side only.
 *   For more background information see here http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.html
 */
public class ClientOnlyProxy extends CommonProxy
{
    public static KeyBinding[] keyBindings;

    /**
     * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
     */
    public void preInit()
    {
        super.preInit();
        andrewmogo.item_mandolin.StartupClientOnly.preInitClientOnly();
    }

    /**
     * Do your mod setup. Build whatever data structures you care about. Register recipes,
     * send FMLInterModComms messages to other mods.
     */
    public void init()
    {
        // declare an array of key bindings
        keyBindings = new KeyBinding[3];

        // instantiate the key bindings
        keyBindings[0] = new KeyBinding("key.note1.desc", Keyboard.KEY_Z, "key.musicmagic.category");
        keyBindings[1] = new KeyBinding("key.note2.desc", Keyboard.KEY_X, "key.musicmagic.category");
        keyBindings[2] = new KeyBinding("key.note3.desc", Keyboard.KEY_C, "key.musicmagic.category");

        // register all the key bindings
        for (int i = 0; i < keyBindings.length; ++i)
        {
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }

        super.init();

        andrewmogo.item_mandolin.StartupClientOnly.initClientOnly();
    }

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    public void postInit()
    {
        super.postInit();
        andrewmogo.item_mandolin.StartupClientOnly.postInitClientOnly();
    }

    @Override
    public boolean playerIsInCreativeMode(EntityPlayer player) {
        if (player instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayerMP = (EntityPlayerMP)player;
            return entityPlayerMP.interactionManager.isCreative();
        } else if (player instanceof EntityPlayerSP) {
            return Minecraft.getMinecraft().playerController.isInCreativeMode();
        }
        return false;
    }

    @Override
    public boolean isDedicatedServer() {return false;}

}
