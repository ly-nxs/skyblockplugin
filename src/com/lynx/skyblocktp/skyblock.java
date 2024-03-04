package com.lynx.skyblocktp;

import com.lynx.skyblocktp.commands.tpcommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;
import static com.lynx.skyblocktp.config.*;

public class skyblock extends JavaPlugin {
    public static int x = 0;
    public static int y = 64;
    public static int z = 0;
    public static List<Player> usedPlayers = new ArrayList<>();
    public static Material[][] grass = {
            {Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK},
            {Material.GRASS_BLOCK,Material.BEDROCK,Material.GRASS_BLOCK},
            {Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK}
    };
    public static Material[][] str = {
            {Material.AIR,Material.CHEST,Material.AIR},
            {Material.AIR,Material.AIR,Material.AIR},
            {Material.AIR,Material.OAK_SAPLING,Material.AIR}
    };

    @Override
    public void onEnable(){
        getServer().getConsoleSender().sendMessage("SkyblockTP Enabled");
        Objects.requireNonNull(getCommand("skyblock")).setExecutor(new tpcommand());
        createFile();
        loadUsedLocation();
        loadUsedPlayers();
    }

    @Override
    public void onDisable(){
        saveUsedLocation(x,y,z);
        saveUsedPlayers();
    }

}
