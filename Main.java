package me.flowo.lifesteal;

import me.flowo.lifesteal.Listeners.*;
import me.flowo.lifesteal.Utils.Heart;
import me.flowo.lifesteal.commands.Recipes;
import me.flowo.lifesteal.commands.giveBeacon;
import me.flowo.lifesteal.commands.withdraw;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PVPEvent(), this);
        getServer().getPluginManager().registerEvents(new HeartApply(), this);
        getServer().getPluginManager().registerEvents(new blockPlace(), this);
        getServer().getPluginManager().registerEvents(new sheepDyed(), this);
        getServer().getPluginManager().registerEvents(new GUI(), this);
        getCommand("withdraw").setExecutor(new withdraw());
        getCommand("givebeacon").setExecutor(new giveBeacon());
        getCommand("recipes").setExecutor(new Recipes());

        ShapedRecipe heartShard = new ShapedRecipe(new NamespacedKey(this, "heartShard"), Heart.getHeartShard(1));
        heartShard.shape("GGG", "TDT", "III");
        heartShard.setIngredient('G', Material.GOLD_BLOCK);
        heartShard.setIngredient('T', Material.TOTEM_OF_UNDYING);
        heartShard.setIngredient('I', Material.IRON_BLOCK);
        heartShard.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(heartShard);

        ShapedRecipe heart = new ShapedRecipe(new NamespacedKey(this, "heart"), Heart.getHeart(1));
        heart.shape("SDS", "DGD", "SDS");
        heart.setIngredient('G', Material.GOLDEN_APPLE);
        heart.setIngredient('S', new RecipeChoice.ExactChoice(Heart.getHeartShard(1)));
        heart.setIngredient('D', Material.DIAMOND_BLOCK);
        Bukkit.addRecipe(heart);

        ShapedRecipe reviveCore = new ShapedRecipe(new NamespacedKey(this, "reviveCore"), Heart.getReviveCore(1));
        reviveCore.shape("DSD", "SBS", "NSN");
        reviveCore.setIngredient('B', Material.NETHER_STAR);
        reviveCore.setIngredient('S', new RecipeChoice.ExactChoice(Heart.getHeart(1)));
        reviveCore.setIngredient('D', Material.DIAMOND_BLOCK);
        reviveCore.setIngredient('N', Material.NETHERITE_INGOT);
        Bukkit.addRecipe(reviveCore);

        ShapedRecipe reviveBeacon = new ShapedRecipe(new NamespacedKey(this, "reviveBeacon"), Heart.getBeacon(1));
        reviveBeacon.shape("HHH", "HRH", "HHH");
        reviveBeacon.setIngredient('H', new RecipeChoice.ExactChoice(Heart.getHeart(1)));
        reviveBeacon.setIngredient('R', new RecipeChoice.ExactChoice(Heart.getReviveCore(1)));
        Bukkit.addRecipe(reviveBeacon);
    }

}
