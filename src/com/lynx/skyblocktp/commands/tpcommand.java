package com.lynx.skyblocktp.commands;

import com.lynx.skyblocktp.skyblock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class tpcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args){
       if(s.equalsIgnoreCase("skyblock")) {
           sender.sendMessage("SkyblockTP Help");
           sender.sendMessage("skyblock start : send to a new island");
           if(args[0].equalsIgnoreCase("tp")){
               sender.sendMessage("Creating new island");
               for(int i = 0; i < 2; i++){
                   for(int j = 0; j < 3; j++){
                       for(int k = 0; k < 3; k++){
                           
                       }
                   }
               }

           }
       }
       return true;
    }
}
