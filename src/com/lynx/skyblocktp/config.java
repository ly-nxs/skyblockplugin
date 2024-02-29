package com.lynx.skyblocktp;

import static com.lynx.skyblocktp.skyblock.usedPlayers;
import java.io.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import static com.lynx.skyblocktp.skyblock.*;

public class config {
    public static void createFile(){
        File file = new File("saveloc.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
                FileWriter writer = new FileWriter("saveloc.txt", true);
                writer.write(x + "\n" + y + "\n" + z + "\n");
                writer.close();
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
    }
     public static void loadUsedPlayers() {
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
    public static void saveUsedPlayers() {
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

            skyblock.x = x;
            skyblock.y = y;
            skyblock.z = z;


            // Replace "null" with the appropriate world
        } catch (IOException e) {
            // Handle potential exceptions like file not found or invalid data
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Handle invalid data format in the file
            e.printStackTrace();
        }
    }

    public static void saveUsedLocation(int x, int y, int z) {
         x = skyblock.x;
         y = skyblock.y;
         z = skyblock.z;


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
