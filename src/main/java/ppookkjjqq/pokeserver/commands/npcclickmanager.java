package ppookkjjqq.pokeserver.commands;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import ppookkjjqq.pokeserver.functionmanager.manager;
import ppookkjjqq.pokeserver.gui.testshop;

public class npcclickmanager implements Listener {


    public ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE, 1);

    @EventHandler
    public void interact(PlayerInteractEntityEvent event){
        if (event.getHand().equals(EquipmentSlot.HAND)) {
            if (event.getRightClicked().getScoreboardTags().contains("tagtest")) {
                event.getPlayer().sendMessage("클릭됨");
                new testshop().open(event.getPlayer());
            }
        }
    }
}
