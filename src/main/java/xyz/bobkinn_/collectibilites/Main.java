package xyz.bobkinn_.collectibilites;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new MainConfig(getPlugin(Main.class));
        Bukkit.getPluginManager().registerEvents(new Handler(),this);
        getLogger().info("Enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
