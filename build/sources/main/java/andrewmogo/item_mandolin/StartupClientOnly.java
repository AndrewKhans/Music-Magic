package andrewmogo.item_mandolin;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class StartupClientOnly
{
    public static void preInitClientOnly()
    {
        // required in order for the renderer to know how to render your item.
        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("musicmagic:item_mandolin", "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(StartupCommon.mandolin, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
    }

    public static void initClientOnly()
    {
    }

    public static void postInitClientOnly()
    {
    }
}