package xyz.bobkinn_.collectibilites;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new Handler(),this);
        Bukkit.getConsoleSender().sendMessage("Enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
