package com.lynx.skyblocktp;

import com.lynx.skyblocktp.commands.tpcommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.util.*;

public class skyblock extends JavaPlugin {
    public static int x = 0;
    public static int y = 0;
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

        getServer().getConsoleSender().sendMessage("SkyblockTP v1.0");
        getCommand("skyblock").setExecutor(new tpcommand());
        loadUsedLocation();
        // check for saveloc.txt and usedplayers.txt, creating them if they don't exist
        File file = new File("saveloc.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file2 = new File("usedplayers.txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        loadUsedPlayers();
    }

    // loads all players who have used the command from the text file to the arraylist
    private void loadUsedPlayers() {
        try {
            FileReader reader = new FileReader("usedplayers.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null) {
                usedPlayers.add(Bukkit.getPlayer(line));
            }

            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // saves all players who have used the command to the text file
    public void saveUsedPlayers() {
        try {
            FileWriter writer = new FileWriter("usedplayers.txt", false);
            StringBuilder toWrite = new StringBuilder();
            for (Player player : usedPlayers) {
                toWrite.append(player.getName()).append("\n");
            }
            writer.write(toWrite.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable(){
        saveUsedLocation(x,y,z);
        saveUsedPlayers();
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

    // add a player to the usedPlayers arraylist to indicate they have used the cmd before
    public static void usedPlayer(Player player) {
        usedPlayers.add(player);
    }

}
