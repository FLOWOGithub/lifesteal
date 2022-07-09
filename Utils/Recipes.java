package me.flowo.lifesteal.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Recipes {
    public static Inventory heartRecipe(Player p){
        Inventory inventory = Bukkit.createInventory(p, 45, "Recipes");

        ItemStack[] recipe = new ItemStack[10];
        recipe[0] = Heart.getHeartShard(1);
        recipe[1] = new ItemStack(Material.DIAMOND_BLOCK);
        recipe[2] = Heart.getHeartShard(1);
        recipe[3] = new ItemStack(Material.DIAMOND_BLOCK);
        recipe[4] = new ItemStack(Material.GOLDEN_APPLE);
        recipe[5] = new ItemStack(Material.DIAMOND_BLOCK);
        recipe[6] = Heart.getHeartShard(1);
        recipe[7] = new ItemStack(Material.DIAMOND_BLOCK);
        recipe[8] = Heart.getHeartShard(1);
        recipe[9] = Heart.getHeart(1);

        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, Heart.getGUIBackground(1));
        }

        inventory.setItem(44, Heart.getNext(1));
        inventory.setItem(36, Heart.getBack(1));

        ItemStack air = new ItemStack(Material.AIR, 1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inventory.setItem(i*9+j+11, recipe[i*3+j]);
            }
        }
        inventory.setItem(24, recipe[9]);


        return inventory;
    }

    public static Inventory getHeartShard(Player p){
        Inventory inventory = Bukkit.createInventory(p, 45, "Recipes");

        ItemStack[] recipe = new ItemStack[10];
        recipe[0] = new ItemStack(Material.GOLD_BLOCK);
        recipe[1] = new ItemStack(Material.GOLD_BLOCK);
        recipe[2] = new ItemStack(Material.GOLD_BLOCK);
        recipe[3] = new ItemStack(Material.TOTEM_OF_UNDYING);
        recipe[4] = new ItemStack(Material.DIAMOND);
        recipe[5] = new ItemStack(Material.TOTEM_OF_UNDYING);
        recipe[6] = new ItemStack(Material.IRON_BLOCK);
        recipe[7] = new ItemStack(Material.IRON_BLOCK);
        recipe[8] = new ItemStack(Material.IRON_BLOCK);
        recipe[9] = Heart.getHeartShard(1);

        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, Heart.getGUIBackground(1));
        }

        inventory.setItem(44, Heart.getNext(1));
        inventory.setItem(36, Heart.getBack(1));

        ItemStack air = new ItemStack(Material.AIR, 1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inventory.setItem(i*9+j+11, recipe[i*3+j]);
            }
        }
        inventory.setItem(24, recipe[9]);


        return inventory;
    }

    public static Inventory getReviveCore(Player p){
        Inventory inventory = Bukkit.createInventory(p, 45, "Recipes");

        ItemStack[] recipe = new ItemStack[10];
        recipe[0] = new ItemStack(Material.DIAMOND_BLOCK);
        recipe[1] = Heart.getHeart(1);
        recipe[2] = new ItemStack(Material.DIAMOND_BLOCK);
        recipe[3] = Heart.getHeart(1);
        recipe[4] = new ItemStack(Material.NETHER_STAR);
        recipe[5] = Heart.getHeart(1);
        recipe[6] = new ItemStack(Material.NETHERITE_INGOT);
        recipe[7] = Heart.getHeart(1);
        recipe[8] = new ItemStack(Material.NETHERITE_INGOT);
        recipe[9] = Heart.getReviveCore(1);

        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, Heart.getGUIBackground(1));
        }

        inventory.setItem(44, Heart.getNext(1));
        inventory.setItem(36, Heart.getBack(1));

        ItemStack air = new ItemStack(Material.AIR, 1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inventory.setItem(i*9+j+11, recipe[i*3+j]);
            }
        }
        inventory.setItem(24, recipe[9]);


        return inventory;
    }

    public static Inventory getBeacon(Player p){
        Inventory inventory = Bukkit.createInventory(p, 45, "Recipes");

        ItemStack[] recipe = new ItemStack[10];
        recipe[0] = Heart.getHeart(1);
        recipe[1] = Heart.getHeart(1);
        recipe[2] = Heart.getHeart(1);
        recipe[3] = Heart.getHeart(1);
        recipe[4] = Heart.getReviveCore(1);
        recipe[5] = Heart.getHeart(1);
        recipe[6] = Heart.getHeart(1);
        recipe[7] = Heart.getHeart(1);
        recipe[8] = Heart.getHeart(1);
        recipe[9] = Heart.getBeacon(1);

        for (int i = 0; i < 45; i++) {
            inventory.setItem(i, Heart.getGUIBackground(1));
        }

        inventory.setItem(44, Heart.getNext(1));
        inventory.setItem(36, Heart.getBack(1));

        ItemStack air = new ItemStack(Material.AIR, 1);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inventory.setItem(i*9+j+11, recipe[i*3+j]);
            }
        }
        inventory.setItem(24, recipe[9]);


        return inventory;
    }
}
