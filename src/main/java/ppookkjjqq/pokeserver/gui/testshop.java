package ppookkjjqq.pokeserver.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import ppookkjjqq.pokeserver.functionmanager.manager;

public class testshop implements Listener {
    private final Inventory inv;

    public static ItemStack sellcopper = manager.buildItem(manager.getModdedMaterial("pixelmon","relic_copper"),1, ChatColor.RESET + "동화 팔기",ChatColor.RESET +"판매가:100원");
    public static ItemStack buyupgradestone = manager.buildItem(manager.getModdedMaterial("pixelmon","sky_tumblestone"),1, ChatColor.RESET + "강화석 구매",ChatColor.RESET +"구매가:2000원");
    public static ItemStack pane = manager.buildItem(Material.GRAY_STAINED_GLASS_PANE,1," "," ");

    private void initItemSetting(){
        for (int a=0;a<27;a++){
            if (a == 11){
                inv.setItem(11,sellcopper);
            }
            else if (a == 15){
                inv.setItem(15,buyupgradestone);
            }
            else {
                inv.setItem(a,pane);
            }
        }
    }

    public testshop() {
        this.inv = Bukkit.createInventory(null,9 * 3 , "TESTSHOP");
        initItemSetting();
    }

    public void open(Player player){
        player.openInventory(inv);
    }
}
