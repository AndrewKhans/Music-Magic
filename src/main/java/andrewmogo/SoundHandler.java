package andrewmogo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SoundHandler {

//    private static ResourceLocation location = new ResourceLocation("musicmagic", "mandolinStrum");
//    private static SoundEvent mandolinStrum = new SoundEvent(location);
////    location = new ResourceLocation("musicmagic", "guitarSound");
//    private static SoundEvent mandolinPluck = new SoundEvent(location);

    private static SoundEvent mandolinStrum = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinStrum")
    );

    public static void playMandolinStrum(EntityPlayer player, float volume, int pitch) {
        WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(player.dimension);
        if (pitch == 1)
            worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, mandolinStrum, SoundCategory.PLAYERS, volume, 1.0F);
        if (pitch == 2)
            worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, mandolinStrum, SoundCategory.PLAYERS, volume, 1.0F);
        if (pitch == 3)
            worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, mandolinStrum, SoundCategory.PLAYERS, volume, 1.0F);
    }

    // Mandolin Pluck

    // G is the lowest
    // D
    // A is the highest

    private static SoundEvent mandolinPluckA = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinPluckA")
    );
    private static SoundEvent mandolinPluckD = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinPluckD")
    );
    private static SoundEvent mandolinPluckG = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinPluckG")
    );

    public static void playMandolinPluck(EntityPlayer player, float volume, int pitch) {
        WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(player.dimension);
        if (pitch == 1)
            worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, mandolinPluckG, SoundCategory.PLAYERS, volume, 1.0F);
        if (pitch == 2)
            worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, mandolinPluckD, SoundCategory.PLAYERS, volume, 1.0F);
        if (pitch == 3)
            worldServer.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, mandolinPluckA, SoundCategory.PLAYERS, volume, 1.0F);
    }
}
