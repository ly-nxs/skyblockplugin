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
    public static int x = 256;
    public static int y = 0;
    public  static int z = 0;
    Location loc = new Location(world,x,y,z);


    @Override
    public void onEnable(){
     getServer().getConsoleSender().sendMessage("SkyblockTP v1.0");
     getCommand("skyblock").setExecutor(new tpcommand());

    }



    @Override
    public void onDisable(){

    }
}
