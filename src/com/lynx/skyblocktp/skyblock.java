package com.lynx.skyblocktp;

import com.lynx.skyblocktp.commands.tpcommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;

public class skyblock extends JavaPlugin {
    public static int x = 0;
    public static int y = 64;
    public static int z = 0;
    public static List<Player> usedPlayers = new ArrayList<>();
    public static Material[][][] structure = {
            {{Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK},
            {Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK},
                {Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK}},
            {{Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK},
            {Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK},
                {Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK}},
            {{Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK},
            {Material.GRASS_BLOCK,Material.BEDROCK,Material.GRASS_BLOCK},
                {Material.GRASS_BLOCK,Material.GRASS_BLOCK,Material.GRASS_BLOCK}},
            {{Material.AIR,Material.CHEST,Material.AIR},
            {Material.AIR,Material.AIR,Material.AIR},
            {Material.AIR,Material.OAK_SAPLING,Material.AIR}}
    };




    @Override
    public void onEnable(){
        getServer().getConsoleSender().sendMessage("SkyblockTP Enabled");
        getCommand("skyblock").setExecutor(new tpcommand());
        config.createFile();
        config.loadUsedLocation();
        config.loadUsedPlayers();
        // check for saveloc.txt and usedplayers.txt, creating them if they don't exist
    }

    // loads all players who have used the command from the text file to the arraylist


    // saves all players who have used the command to the text file


    @Override
    public void onDisable(){
        config.saveUsedLocation(x,y,z);
        config.saveUsedPlayers();
    }

}
