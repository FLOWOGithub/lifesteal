package me.flowo.lifesteal.Listeners;

import me.flowo.lifesteal.Utils.Heart;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;


public class HeartApply implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if (e.getItem() != null) {
            if (e.getItem().getItemMeta().hasCustomModelData()) {
                if (e.getItem().getItemMeta().getCustomModelData() == 1) {
                    if (p.getMaxHealth() < 40) {
                        e.getItem().setAmount(e.getItem().getAmount() - 1);
                        p.setMaxHealth(p.getMaxHealth() + 2);
                    } else {
                        p.sendMessage(ChatColor.RED + "Tu jau pasiekiai 20 širdučių.");
                    }
                }
            }
        }
    }
}
