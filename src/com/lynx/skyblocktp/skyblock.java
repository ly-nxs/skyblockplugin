package com.lynx.skyblocktp;

import com.lynx.skyblocktp.commands.tpcommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.block.data.BlockData;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.*;

public class skyblock extends JavaPlugin {
    public static int x = 0;
    public static int y = 0;
    public  static int z = 0;
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

     getServer().getConsoleSender().sendMessage("SkyblockTP v1.0");
     getCommand("skyblock").setExecutor(new tpcommand());
    loadUsedLocation();
    }



    @Override
    public void onDisable(){
        saveUsedLocation(x,y,z);

    }
    public static void loadUsedLocation() {
        try {
            FileReader reader = new FileReader("saveloc.txt");
            BufferedReader br = new BufferedReader(reader);

            String line1 = br.readLine();
            x = Integer.parseInt(line1);

            String line2 = br.readLine();
            y = Integer.parseInt(line2);

            String line3 = br.readLine();
            z = Integer.parseInt(line3);

            br.close();
            reader.close();

            // Replace "null" with the appropriate world
        } catch (IOException e) {
            // Handle potential exceptions like file not found or invalid data
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle invalid data format in the file
            e.printStackTrace();
        }
    }

    public void saveUsedLocation(int x, int y, int z) {
        try {
            FileWriter writer = new FileWriter("saveloc.txt", true);
            writer.write(x + "\n" + y + "\n" + z + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
