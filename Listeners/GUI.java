package me.flowo.lifesteal.Listeners;

import me.flowo.lifesteal.Utils.Heart;
import me.flowo.lifesteal.Utils.Recipes;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI implements Listener {
    @EventHandler
    public void onInventoryInteract(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if (e.getView().getTitle().contains("Recipes")) {
            e.setCancelled(true);
            if (item.getType() == Material.RED_DYE){
                Inventory inventory = me.flowo.lifesteal.Utils.Recipes.heartRecipe(p);
                p.openInventory(inventory);
            } else if (item.getType() == Material.ORANGE_DYE) {
                Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getHeartShard(p);
                p.openInventory(inventory);
            } else if (item.getType() == Material.BLACK_DYE) {
                Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getReviveCore(p);
                p.openInventory(inventory);
            } else if (item.getType() == Material.BEACON) {
                Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getBeacon(p);
                p.openInventory(inventory);
            } else if (item.getType() == Material.GREEN_TERRACOTTA) {
                if (item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GREEN + "back")){
                    if (e.getView().getItem(24).getType() == Material.RED_DYE){
                        Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getBeacon(p);
                        p.openInventory(inventory);
                    } else if (e.getView().getItem(24).getType() == Material.ORANGE_DYE) {
                        Inventory inventory = me.flowo.lifesteal.Utils.Recipes.heartRecipe(p);
                        p.openInventory(inventory);
                    } else if (e.getView().getItem(24).getType() == Material.BLACK_DYE) {
                        Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getHeartShard(p);
                        p.openInventory(inventory);
                    } else if (e.getView().getItem(24).getType() == Material.BEACON) {
                        Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getReviveCore(p);
                        p.openInventory(inventory);
                    }
                }else {
                    if (e.getView().getItem(24).getType() == Material.RED_DYE){
                        Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getHeartShard(p);
                        p.openInventory(inventory);
                    } else if (e.getView().getItem(24).getType() == Material.ORANGE_DYE) {
                        Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getReviveCore(p);
                        p.openInventory(inventory);
                    } else if (e.getView().getItem(24).getType() == Material.BLACK_DYE) {
                        Inventory inventory = me.flowo.lifesteal.Utils.Recipes.getBeacon(p);
                        p.openInventory(inventory);
                    } else if (e.getView().getItem(24).getType() == Material.BEACON) {
                        Inventory inventory = me.flowo.lifesteal.Utils.Recipes.heartRecipe(p);
                        p.openInventory(inventory);
                    }
                }
            }
        } else if (e.getView().getTitle().contains(ChatColor.RED + "Atgyjimo švyturys")) {
            if (item != null) {
                blockPlace beaconInstance = new blockPlace();

                p.closeInventory();

                e.setCancelled(true);
                Bukkit.getBanList(BanList.Type.NAME).getBanEntries();
                List<String> completions = new ArrayList<String>();
                for (OfflinePlayer player : Bukkit.getBannedPlayers()) {
                    String name = player.getName();
                    completions.add(name);
                }
                if (completions.get(e.getSlot()) != null) {
                    Bukkit.getBanList(BanList.Type.NAME).pardon(completions.get(e.getSlot()));
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        Location loc = online.getLocation();
                        online.playSound(loc, Sound.ENTITY_ENDER_DRAGON_DEATH, 2, 1);
                        online.sendTitle(ChatColor.RED + p.getDisplayName() + " atgaivino " + item.getItemMeta().getDisplayName(), ChatColor.RED + "Sveikas sugrįžęs");
                    }
                }
            }
        }
    }
}
