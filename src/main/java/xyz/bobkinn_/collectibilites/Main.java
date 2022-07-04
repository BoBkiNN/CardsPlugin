package xyz.bobkinn_.collectibilites;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.apache.commons.io.IOUtils;

import java.io.*;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            getDataFolder().mkdir();
            File cardsFile =  new File(getDataFolder(),"cards.json");
            cardsFile.createNewFile();
            InputStream jarStream = getResource("cards.json");
            OutputStream fileStream;
            fileStream = new FileOutputStream(new File(getDataFolder(),"cards.json"));
            IOUtils.copy(jarStream,fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        getConfig();

        new MainConfig(getPlugin(Main.class));
        Bukkit.getPluginManager().registerEvents(new Handler(),this);
        getLogger().info("Enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
