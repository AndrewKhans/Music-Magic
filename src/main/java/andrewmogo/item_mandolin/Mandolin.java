package andrewmogo.item_mandolin;


import andrewmogo.Sounds.SoundRegistrator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nullable;
import java.util.List;

public class Mandolin extends Item
{

    public Mandolin() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }

    ResourceLocation location = new ResourceLocation("musicmagic", "guitar_noise.ogg");
    SoundEvent event = new SoundEvent(location);


//    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
//        // IMPORTANT! Only spawn new entities on the server. If the world is not remote,
//        // that means you are on the server:
//       if (!worldIn.isRemote) {
//           EntityEnderPearl entityenderpearl = new EntityEnderPearl(worldIn, playerIn);
//           entityenderpearl.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3F, 0.0F);
//           worldIn.spawnEntity(entityenderpearl);
//        }
//        ItemStack itemstack = playerIn.getHeldItem(handIn);
//
//        worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundRegistrator.guitarSound, SoundCategory.PLAYERS, 1.0F, 1.0F);
//        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
//
//    }

    // This onItemRightClick code is mainly taken from "Not Enough Wands" (https://github.com/romelo333/notenoughwands1.8.8)

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(player.getGameProfile().getName() == "paul325") {    //maybe use get id?
            // Give infinite nausea
        }
        ItemStack stack = player.getHeldItem(hand);
        if (!world.isRemote) {
//            if (!checkUsage(stack, player, 1.0f)) {
//                return ActionResult.newResult(EnumActionResult.PASS, stack);
//            }
            Vec3d lookVec = player.getLookVec();
            Vec3d start = new Vec3d(player.posX, player.posY + player.getEyeHeight(), player.posZ);
            int distance = 50; // This is the max distance
            boolean gothrough = false;
            if (player.isSneaking()) {
                    gothrough = true;
                distance /= 2;
            }

            Vec3d end = start.addVector(lookVec.x * distance, lookVec.y * distance, lookVec.z * distance);
            RayTraceResult position = gothrough ? null : world.rayTraceBlocks(start, end);
            if (position == null) {
                if (gothrough) {
                    // First check if the destination is safe
                    BlockPos blockPos = new BlockPos(end.x, end.y, end.z);
                    if (!(world.isAirBlock(blockPos) && world.isAirBlock(blockPos.up()))) {
//                        Tools.error(player, "You will suffocate if you teleport there!");
                        return ActionResult.newResult(EnumActionResult.PASS, stack);
                    }
                }
                player.setPositionAndUpdate(end.x, end.y, end.z);
            } else {
                BlockPos blockPos = position.getBlockPos();
                int x = blockPos.getX();
                int y = blockPos.getY();
                int z = blockPos.getZ();
                if (world.isAirBlock(blockPos.up()) && world.isAirBlock(blockPos.up(2))) {
                    player.setPositionAndUpdate(x+.5, y + 1, z+.5);
                } else {
                    switch (position.sideHit) {
                        case DOWN:
                            player.setPositionAndUpdate(x+.5, y - 2, z+.5);
                            break;
                        case UP:
//                            Tools.error(player, "You will suffocate if you teleport there!");
                            return ActionResult.newResult(EnumActionResult.PASS, stack);
                        case NORTH:
                            player.setPositionAndUpdate(x+.5, y, z - 1 + .5);
                            break;
                        case SOUTH:
                            player.setPositionAndUpdate(x+.5, y, z + 1+.5);
                            break;
                        case WEST:
                            player.setPositionAndUpdate(x - 1+.5, y, z+.5);
                            break;
                        case EAST:
                            player.setPositionAndUpdate(x + 1+.5, y, z+.5);
                            break;
                    }
                }
            }
            //registerUsage(stack, player, 1.0f);

            // Play teleporting sound here

        }
        return ActionResult.newResult(EnumActionResult.PASS, stack);
    }

    /*
    @Override
    public void addInformation(ItemStack stack, World player, List list, ITooltipFlag b) {
        super.addInformation(stack, player, list, b);
        list.add("Right click to teleport forward");
        list.add("until a block is hit or maximum");
        list.add("distance is reached.");
        if ( If you know a certain spell ) {     // If you know a certain spell, add it to the tooltip
            list.add("Sneak to teleport through walls");
        } else {
            list.add("Sneak for half distance");
        }
    }
    */

}