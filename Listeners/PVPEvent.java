package me.flowo.lifesteal.Listeners;

import me.flowo.lifesteal.Utils.Heart;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;

public class PVPEvent implements Listener {
    HashMap<Player, Long> pvpTime = new HashMap<>();
    HashMap<Player, Player> inPVPWith = new HashMap<>();

    public void kill(Player killer, Player dead){
        if (killer != null && dead != null) {
            if (killer.getMaxHealth() < 39) {
                killer.setMaxHealth(killer.getMaxHealth() + 2);
            } else {
                killer.getInventory().addItem(Heart.getHeart(1));
            }
            if (dead.getMaxHealth() < 3) {
                dead.setMaxHealth(20.0);
                Bukkit.getServer().broadcastMessage(ChatColor.RED + dead.getDisplayName() + " prarado visas savo širdeles!");
                dead.kickPlayer(dead.getDisplayName());
                dead.getServer().getBanList(BanList.Type.NAME).addBan(dead.getDisplayName(), "Jūs praradote visas širdeles, todėl nebegalite atsirasti iš naujo!", null, null);
            } else {
                dead.setMaxHealth(dead.getMaxHealth() - 2);
            }
        }
    }
    @EventHandler
    public void onPlayerPVPEvent(EntityDamageByEntityEvent e){
        Entity damager = e.getDamager();
        Entity damaged = e.getEntity();
        if (damager instanceof Player && damaged instanceof Player){
            if (((Player) damager).getGameMode() != GameMode.CREATIVE) {
                Player hitter = (Player) damager;
                Player hitted = (Player) damaged;
                pvpTime.put(hitter, System.currentTimeMillis());
                pvpTime.put(hitted, System.currentTimeMillis());
                inPVPWith.put(hitter, hitted);
                inPVPWith.put(hitted, hitter);
            }
        }
    }
    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent e){
        Player dead = e.getEntity();
        if (dead.getKiller() != null){
            Player killer = dead.getKiller();
            pvpTime.remove(killer);
            pvpTime.remove(dead);
            kill(killer, dead);
        } else if (pvpTime.get(dead) != null){
            if (System.currentTimeMillis()-pvpTime.get(dead) < 10000) {
                Player killer = inPVPWith.get(dead);
                pvpTime.remove(killer);
                pvpTime.remove(dead);
                kill(killer, dead);
            }
        }
    }
}
