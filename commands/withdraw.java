package me.flowo.lifesteal.commands;

import me.flowo.lifesteal.Utils.Heart;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class withdraw implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0) {
                if (p.getMaxHealth() > 2) {
                    p.setMaxHealth(p.getMaxHealth() - 2);
                    p.getInventory().addItem(Heart.getHeart(1));
                } else {
                    p.sendMessage(ChatColor.RED + "Jūs neturite pakankamai širdučių!");
                }
            }else {
                p.sendMessage(ChatColor.RED + "Įvedėte komandą neteisingai. pabandykite dar kartą");
            }
        }

        return true;
    }


}
