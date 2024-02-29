package com.lynx.skyblocktp.commands;

import com.lynx.skyblocktp.config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import static com.lynx.skyblocktp.skyblock.*;

public class tpcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args){
       if (s.equalsIgnoreCase("skyblock")) {
           Player player = (Player) sender;
           if (usedPlayers.contains(player)) {
               sender.sendMessage("You have already used this command.");
               return true;
           }
           Location location = new Location(player.getWorld(), x, y, z);
           loadChunk(location);
           sender.sendMessage("Creating new island");
           for (int j = z; j < structure.length; j++) {
               for (int k = y; k < structure[j].length; k++) {
                   for (int l = x; l < structure[j][l].length; l++) {
                       int xPos = location.getBlockX() + l - structure[j][k].length / 2;
                       int yPos = location.getBlockY() + k;
                       int zPos = location.getBlockZ() + j - structure[j].length / 2;

                       Location blockLocation = new Location(player.getWorld(), xPos, yPos, zPos);
                       blockLocation.getBlock().setType(structure[j][k][l]);
                   }
               }
           }
           sender.sendMessage("Island is finished...  teleporting");
           player.teleport(location);
           sender.sendMessage("Teleported!");
           Location respawnLocation = new Location(player.getWorld(), x, y + 2, z);
           player.setRespawnLocation(respawnLocation);
           player.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 1));
           player.getInventory().addItem(new ItemStack(Material.ICE, 1));
           int h  = (int)(Math.random()*3)+1;
           if(h == 3){
            x += 128;
            z += 128;
           } else if (h == 2) {
               x += 128;
               z -= 128;
           } else{
               x -= 64;
               z -= 64;
           }
           config.usedPlayer(player);
       }
       return true;
    }

    public static void loadChunk(Location location) {
        if (!location.getChunk().isLoaded()) {
            location.getChunk().load();
        }
    }
}
