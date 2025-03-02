package ppookkjjqq.pokeserver.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import ppookkjjqq.pokeserver.Pokeserver;
import ppookkjjqq.pokeserver.functionmanager.itemmanager;
import ppookkjjqq.pokeserver.functionmanager.manager;

public class testshopevent implements Listener {

    Pokeserver plugin;

    public testshopevent(Pokeserver instance){
        plugin = instance;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        int money = plugin.getConfig().getInt(player.getName());

        if(e.getView().getTitle().equalsIgnoreCase("TESTSHOP")){
            if(e.getCurrentItem().isSimilar(testshop.sellcopper)){
                if(player.getInventory().contains(manager.getModdedMaterial("pixelmon","relic_copper"))){
                    manager.itemremove(player, manager.getModdedMaterial("pixelmon","relic_copper"));
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 10 ,1);
                    plugin.getConfig().set(player.getName(),money + 100);
                    plugin.saveConfig();
                    e.setCancelled(true);
                }
                else{
                    e.setCancelled(true);
                }
            }
            else if(e.getCurrentItem().isSimilar(testshop.buyupgradestone)){
                if(money >= 2000){
                    player.getInventory().addItem(itemmanager.upgradestone);
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 10 ,1);
                    plugin.getConfig().set(player.getName(),money - 2000);
                    plugin.saveConfig();
                    e.setCancelled(true);
                }
                else{
                    e.setCancelled(true);
                }
            }
            else if(e.getCurrentItem().isSimilar(testshop.pane)){
                e.setCancelled(true);
                if(player.getOpenInventory().getTopInventory().contains(Material.GRAY_STAINED_GLASS_PANE)){
                    player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 10 ,1);
                }
            }
        }
    }
}
