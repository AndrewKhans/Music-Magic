package andrewmogo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class SoundHandler {

    // Pluck

    private static SoundEvent mandolinPluckA = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinPluckA")
    );
    private static SoundEvent mandolinPluckD = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinPluckD")
    );
    private static SoundEvent mandolinPluckG = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinPluckG")
    );

    public static void playMandolinPluck(EntityPlayer player, float volume, char note) {
        WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(player.dimension);
        switch (note) {
            case 'A':
                worldServer.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, mandolinPluckA, SoundCategory.PLAYERS, volume, 1.0F);
                break;
            case 'D':
                worldServer.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, mandolinPluckD, SoundCategory.PLAYERS, volume, 1.0F);
                break;
            case 'G':
                worldServer.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, mandolinPluckG, SoundCategory.PLAYERS, volume, 1.0F);
                break;
        }
    }

    // Strum

    private static SoundEvent mandolinStrumA = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinStrumA")
    );
    private static SoundEvent mandolinStrumD = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinStrumD")
    );
    private static SoundEvent mandolinStrumG = new SoundEvent(
            new ResourceLocation("musicmagic", "mandolinStrumG")
    );

    public static void playMandolinStrum(EntityPlayer player, float volume, char note) {
        WorldServer worldServer = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(player.dimension);
        switch (note) {
            case 'A':
                worldServer.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, mandolinStrumA, SoundCategory.PLAYERS, volume, 1.0F);
                break;
            case 'D':
                worldServer.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, mandolinStrumD, SoundCategory.PLAYERS, volume, 1.0F);
                break;
            case 'G':
                worldServer.playSound((EntityPlayer) null, player.posX, player.posY, player.posZ, mandolinStrumG, SoundCategory.PLAYERS, volume, 1.0F);
                break;
        }
    }
}
