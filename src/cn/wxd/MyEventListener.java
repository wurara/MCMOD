package cn.wxd;

import cn.wxd.build.Screen;
import cx.wxd.entry.MyZombie;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_9_R1.CraftWorld;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

public class MyEventListener implements Listener {
    Player player ;

    @EventHandler
    public void onjoin(PlayerJoinEvent event){
        this.player = event.getPlayer();
       event.setJoinMessage ("勇士，你好"+event.getPlayer().getName());
        PlayerInventory playerInventory = player.getInventory();
        ItemStack itemStack = new ItemStack(Material.WOOD_SWORD,64);
        if(!playerInventory.contains(itemStack)){
            playerInventory.addItem(itemStack);
            itemStack.setType(Material.STICK);
            itemStack.setAmount(64);
            playerInventory.addItem(itemStack);
            itemStack.setType(Material.TNT);
            itemStack.setAmount(64);
            playerInventory.addItem(itemStack);
            itemStack.setType(Material.FLINT_AND_STEEL);
            itemStack.setAmount(64);
            playerInventory.addItem(itemStack);
        }
        Location location = player.getLocation();
        World world = player.getWorld();
        world.spawn(location,Cow.class);
        player.setAllowFlight(true);
    }


    @EventHandler
    public void PlayerClickBlock(PlayerInteractEvent event){
        Plugin plugin = player.getServer().getPluginManager().getPlugin("MyPlugin");
        if(event.getMaterial()==Material.WOOD_SWORD&&event.getClickedBlock()!=null){
            Pig pig = event.getClickedBlock().getWorld().spawn(event.getClickedBlock().getLocation().add(0,1,0),Pig.class);
            pig.setCustomName("123");
            pig.setCustomNameVisible(true);
        }



        if(event.getMaterial()==Material.STICK&&event.getClickedBlock()!=null){
            if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
                (new Screen()).createFlowSetence(event,"Love");
            }else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                Bukkit.getScheduler().cancelTasks(plugin);
            }
        }
    }
}
