package cn.wxd.build;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class Screen{



    /**
     *  在点击的方块的上方一个方块，沿着x方向创建一个13*16（英文字符13*8）的建筑
     *
     * @param event     玩家点击事件
     * @param setence   要创建的句子
     */
    public void createFlowSetence(PlayerInteractEvent event,String setence){
        Plugin plugin = event.getPlayer().getServer().getPluginManager().getPlugin("MyPlugin");
            Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin,new Create(event,setence),10,10);

}


    /**
     *  在点击的方块的上方一个方块，沿着x方向创建一个13*16（英文字符13*8）的建筑
     *
     * @param event     玩家点击事件
     * @param setence   要创建的句子
     */
    public void createSetence(PlayerInteractEvent event,String setence){
        Location location = event.getClickedBlock().getLocation();
            Location location1 = location;
        (new Create(event,setence)).createSetence(location,setence);
    }






}
