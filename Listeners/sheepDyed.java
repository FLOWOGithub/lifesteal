package me.flowo.lifesteal.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.SheepDyeWoolEvent;

public class sheepDyed implements Listener {
    @EventHandler
    public void onSheepDyed(SheepDyeWoolEvent e){
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 3 || p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 4){
            e.setCancelled(true);
        } else if ( p.getInventory().getItemInMainHand().getItemMeta().getCustomModelData() == 1) {
            e.setCancelled(true);

            if(p.getMaxHealth()<40) {
                p.getItemInHand().setAmount(p.getItemInHand().getAmount()-1);
                p.setMaxHealth(p.getMaxHealth()+2);
            }else {
                p.sendMessage(ChatColor.RED + "Tu jau pasiekiai 20 širdučių.");
            }

        }else{
            return;
        }
    }
}
