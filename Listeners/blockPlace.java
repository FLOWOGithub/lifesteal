package me.flowo.lifesteal.Listeners;

import me.flowo.lifesteal.Main;
import org.bukkit.*;
import org.bukkit.block.Beacon;
import org.bukkit.block.Skull;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class blockPlace implements Listener {
    HashMap<Player, Location> beaconLoc = new HashMap<>();

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if (e.getItemInHand().getItemMeta().hasCustomModelData()) {
            if (e.getItemInHand().getItemMeta().getCustomModelData() == 2) {
                Location loca = e.getBlock().getLocation();
                beaconLoc.put(p, loca);

                System.out.println(beaconLoc);

                Bukkit.getBanList(BanList.Type.NAME).getBanEntries();
                List<String> completions = new ArrayList<String>();
                for (OfflinePlayer player : Bukkit.getBannedPlayers()) {
                    String name = player.getName();
                        completions.add(name);
                }
                Inventory banGUI = Bukkit.createInventory(p, 45, ChatColor.RED + "Atgyjimo švyturys");
                for (int i = 0; i<completions.size(); i++){
                    if (!Bukkit.getBanList(BanList.Type.NAME).getBanEntry(completions.get(i)).getReason().contains("Jūs praradote visas širdeles, todėl nebegalite atsirasti iš naujo!")){
                        completions.set(i, null);
                    }
                }
                for (int i = 0; i<completions.size(); i++){
                    if (completions.get(i) != null) {
                        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                        SkullMeta meta = (SkullMeta) playerHead.getItemMeta();

                        meta.setDisplayName(completions.get(i));
                        meta.setOwner(completions.get(i));
                        ArrayList<String> lore = new ArrayList<>();
                        lore.add("Paspauskite, kad sugrąžintumėte šį žaidėją");
                        lore.add("į žaidimą");
                        meta.setLore(lore);

                        playerHead.setItemMeta(meta);
                        banGUI.addItem(playerHead);
                    }
                }
                p.openInventory(banGUI);
            }
        }

    }
    @EventHandler
    public void onPlayerGUI(InventoryClickEvent e) {
        if (e.getView().getTitle().contains(ChatColor.RED + "Atgyjimo švyturys")) {
            Player p = (Player) e.getWhoClicked();
            ItemStack item = e.getCurrentItem();
            Location loca = beaconLoc.get(p);
            if (item != null) {
                blockPlace beaconInstance = new blockPlace();

                Bukkit.getWorld("world").setType(loca, Material.AIR);
                Bukkit.getWorld("world").spawnEntity(loca, EntityType.LIGHTNING);
                Bukkit.getWorld("world").spawnParticle(Particle.TOTEM, loca, 1000);

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
