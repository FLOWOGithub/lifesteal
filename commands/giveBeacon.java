package me.flowo.lifesteal.commands;

import me.flowo.lifesteal.Utils.Heart;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class giveBeacon implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (p.isOp()) {
                p.getInventory().addItem(Heart.getBeacon(1));
            }else {
                p.sendMessage(ChatColor.RED + "Tu negali naudoti šios komandos, nes neesi serverio operatorius");
            }
        }

        return true;
    }
}
