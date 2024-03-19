package com.lynx.skyblocktp.commands;

import com.lynx.skyblocktp.config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static com.lynx.skyblocktp.config.loadChunk;
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
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++) {
                    int xPos = x + i;
                    int zPos = z + j;

                    Location grassLocation = new Location(player.getWorld(), xPos, y - 3, zPos);
                    grassLocation.getBlock().setType(grass[i][j]);
                    Location grassLocation2 = new Location(player.getWorld(), xPos, y - 2, zPos);
                    grassLocation2.getBlock().setType(grass[i][j]);
                    Location strLoc = new Location(player.getWorld(),xPos,y - 1,zPos);
                    strLoc.getBlock().setType(str[i][j]);
               }
            }
            loadChunk(location);
            sender.sendMessage("Island is finished...  teleporting");
            player.teleport(location);
            sender.sendMessage("Teleported!");
            Location respawn = new Location(player.getWorld(), x,y + 2,z);
            //todo not sure why since its in the docs but this isn't a method
            player.setRespawnLocation(respawn);
            player.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET, 1));
            player.getInventory().addItem(new ItemStack(Material.ICE, 1));
            player.getInventory().addItem(new ItemStack(Material.BONE_MEAL, 16));
            int h  = (int) (Math.random() * 3) + 1;
            if (h == 3) {
                x += 256;
                z += 256;
                y = 64;
            } else if (h == 2) {
                x += 256;
                z -= 64;
                y = 32;
            } else {
                x -= 128;
                z -= 128;
                y = 128;
            }
            config.usedPlayer(player);
        }
        return true;
    }
}
