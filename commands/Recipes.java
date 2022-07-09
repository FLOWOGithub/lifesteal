package me.flowo.lifesteal.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Recipes implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (sender instanceof Player) {
            Player p = (Player) sender;

            Inventory inventory = me.flowo.lifesteal.Utils.Recipes.heartRecipe(p);

            p.openInventory(inventory);
        }
        return true;
    }
}
