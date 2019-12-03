package andrewmogo.item_mandolin;


import andrewmogo.SoundHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mandolin extends Item
{
    public boolean strumMode = false;


    public Mandolin() {
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }

    public int ticks = 0;
    public ArrayList<String> noteOrder = new ArrayList<>();
    public boolean noteAdded = false; // Is set to true by KeyInputHandler when a note is played

    @Override
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5)
    {
        if (!par2World.isRemote) {
            if (noteAdded) {
                noteAdded = false;
                ticks = 200; // 20 ticks = 1 second
            } else {
                ticks--;
                if (ticks == 0)
                    System.out.println("Noteorder before clearing:" + noteOrder);
                System.out.println("cleared");
                noteOrder.clear();
            }
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!world.isRemote) {

            System.out.println("noteOrder:" + noteOrder);

            if (noteOrder.equals(new ArrayList<String>() {{
                add("Pluck1");
                add("Pluck2");
                add("Pluck3");
            }})) {
                spellTeleport(world, player, hand);
            }


            // put mandolin on cooldown?
            noteOrder.clear();
        }
        ItemStack stack = player.getHeldItem(hand);
        return ActionResult.newResult(EnumActionResult.PASS, stack);
    }


    // This code is mainly taken from "Not Enough Wands" (https://github.com/romelo333/notenoughwands1.8.8)
    public void spellTeleport(World world, EntityPlayer player, EnumHand hand) {

        ItemStack stack = player.getHeldItem(hand);
//        if (!world.isRemote) {        // Already done in the onRightClickMethod

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
//                        return ActionResult.newResult(EnumActionResult.PASS, stack);
                        return;
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
//                            return ActionResult.newResult(EnumActionResult.PASS, stack);
                            return;
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

            // Play teleporting sound here

//        }
//        return ActionResult.newResult(EnumActionResult.PASS, stack);

    }

    //      Adds a tooltip to the mandolin
//    @Override
//    public void addInformation(ItemStack stack, World player, List list, ITooltipFlag b) {
//        super.addInformation(stack, player, list, b);
//        list.add("Note 1: C#");
//        list.add("Note 2: D");
//        list.add("Note 3: E");
//    }
}