package andrewmogo;

import andrewmogo.Sounds.SoundRegisterListener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

/**
 * CommonProxy is used to set up the mod and start it running.  It contains all the code that should run on both the
 *   Standalone client and the dedicated server.
 *   For more background information see here http://greyminecraftcoder.blogspot.com/2013/11/how-forge-starts-up-your-code.html
 */
public abstract class CommonProxy {

    /**
     * Run before anything else. Read your config, create blocks, items, etc, and register them with the GameRegistry
     */
    public void preInit()
    {
        //read config first
        // This should call the preInitCommon() of all the items/blocks

        andrewmogo.item_mandolin.StartupCommon.preInitCommon();
        MinecraftForge.EVENT_BUS.register(new SoundRegisterListener());
    }

    /**
     * Do your mod setup. Build whatever data structures you care about. Register recipes,
     * send FMLInterModComms messages to other mods.
     */
    public void init()
    {
        // THis should call the initCommon of all the items/blocks
        andrewmogo.item_mandolin.StartupCommon.initCommon();

    }

    /**
     * Handle interaction with other mods, complete your setup based on this.
     */
    public void postInit()
    {
        // This should call the postInitCommon() of each item/block
        andrewmogo.item_mandolin.StartupCommon.postInitCommon();

    }

    // helper to determine whether the given player is in creative mode
    //  not necessary for most examples
    abstract public boolean playerIsInCreativeMode(EntityPlayer player);

    /**
     * is this a dedicated server?
     * @return true if this is a dedicated server, false otherwise
     */
    abstract public boolean isDedicatedServer();
}