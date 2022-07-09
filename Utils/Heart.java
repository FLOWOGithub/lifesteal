package me.flowo.lifesteal.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Heart{
    public static ItemStack getHeart(Integer amount){
        ItemStack heart = new ItemStack(Material.RED_DYE, amount);
        ItemMeta heartM = heart.getItemMeta();
        heartM.setDisplayName(ChatColor.RED + "Papildoma širdelė");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Ji laiko gyvybę savyje.");
        lore.add(ChatColor.DARK_PURPLE + "Panaudok, kad taptum stipresnis!");
        heartM.setLore(lore);
        heartM.setCustomModelData(1);
        heart.setItemMeta(heartM);

        return heart;
    }

    public static ItemStack getBeacon(Integer amount){
        ItemStack beacon = new ItemStack(Material.BEACON, amount);
        ItemMeta beaconM = beacon.getItemMeta();
        beaconM.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "Y" + ChatColor.RED +"Atgyjimo švyturys" + ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + "L");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Žmonės visada norėjo tokios galios...");
        lore.add(ChatColor.DARK_PURPLE + "Sukurti gyvybę...");
        lore.add(ChatColor.DARK_PURPLE + "Bet dabar. Tu. Mirtingasis. Turi šią galią...");
        lore.add(ChatColor.DARK_PURPLE + "Naudok ją atsakingai.");
        lore.add(ChatColor.DARK_PURPLE + "Jei nori galia pasinaudoti.");
        lore.add(ChatColor.DARK_PURPLE + "Mane pastatyk ir pastatęs");
        lore.add(ChatColor.DARK_PURPLE + "pasirink ką nori augrąžinti");
        lore.add(ChatColor.DARK_PURPLE + "Bet būk atsargus");
        lore.add(ChatColor.DARK_PURPLE + "Mane pastačius ir nepasirikus");
        lore.add(ChatColor.DARK_PURPLE + "to kurio nori atgaivinti manęs");
        lore.add(ChatColor.DARK_PURPLE + "nesusigrąžinsi");
        beaconM.setLore(lore);
        beaconM.setCustomModelData(2);
        beacon.setItemMeta(beaconM);

        return beacon;
    }

    public static ItemStack getHeartShard(Integer amount){
        ItemStack heartShard = new ItemStack(Material.ORANGE_DYE, amount);
        ItemMeta heartShardM = heartShard.getItemMeta();
        heartShardM.setDisplayName(ChatColor.GOLD + "Širdies šukė");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "4 širdies šukės sudėtos su deimantais");
        lore.add(ChatColor.DARK_PURPLE + "ir auksiniais obuoliais sukuria gyvybę");
        heartShardM.setLore(lore);
        heartShardM.setCustomModelData(3);
        heartShard.setItemMeta(heartShardM);

        return heartShard;
    }

    public static ItemStack getReviveCore(Integer amount){
        ItemStack heartShard = new ItemStack(Material.BLACK_DYE, amount);
        ItemMeta heartShardM = heartShard.getItemMeta();
        heartShardM.setDisplayName(ChatColor.GOLD + "Atgyjimo šerdis");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_PURPLE + "Niekada nemaniau, kad pasieksi");
        lore.add(ChatColor.DARK_PURPLE + "šį tašką, kai gali atkurti gyvybę.");
        lore.add(ChatColor.DARK_PURPLE + "Tavo rankose galingiausias daiktas");
        lore.add(ChatColor.DARK_PURPLE + "Kuris kadanors buvo sukurtas");
        heartShardM.setLore(lore);
        heartShardM.setCustomModelData(4);
        heartShard.setItemMeta(heartShardM);

        return heartShard;
    }

    public static ItemStack getGUIBackground(Integer amount){
        ItemStack heartShard = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, amount);
        ItemMeta heartShardM = heartShard.getItemMeta();
        heartShardM.setDisplayName(" ");
        heartShardM.setCustomModelData(5);
        heartShard.setItemMeta(heartShardM);

        return heartShard;
    }

    public static ItemStack getNext(Integer amount){
        ItemStack heartShard = new ItemStack(Material.GREEN_TERRACOTTA, amount);
        ItemMeta heartShardM = heartShard.getItemMeta();
        heartShardM.setDisplayName(ChatColor.GREEN + "Next");
        heartShardM.setCustomModelData(6);
        heartShard.setItemMeta(heartShardM);

        return heartShard;
    }

    public static ItemStack getBack(Integer amount){
        ItemStack heartShard = new ItemStack(Material.GREEN_TERRACOTTA, amount);
        ItemMeta heartShardM = heartShard.getItemMeta();
        heartShardM.setDisplayName(ChatColor.GREEN + "Back");
        heartShardM.setCustomModelData(7);
        heartShard.setItemMeta(heartShardM);

        return heartShard;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
