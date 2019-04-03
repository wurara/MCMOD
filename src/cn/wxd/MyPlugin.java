package cn.wxd;

import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin {
    @Override
    public void onDisable() {
        getLogger().info("插件摧毁");
    }

    @Override
    public void onEnable() {
        getLogger().info("插件调用");
        getServer().getPluginManager().registerEvents(new MyEventListener(),this);


    }
}
