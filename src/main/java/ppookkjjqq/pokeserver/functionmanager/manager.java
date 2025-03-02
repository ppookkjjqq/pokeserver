package ppookkjjqq.pokeserver.functionmanager;

import net.minecraft.server.v1_16_R3.IRegistry;
import net.minecraft.server.v1_16_R3.Item;
import net.minecraft.server.v1_16_R3.MinecraftKey;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class manager {
    public static void itemremove(Player player, Material material){
        for(ItemStack item : player.getInventory().getContents()){
            if(item != null && item.getType() == material){


                item.setAmount(item.getAmount()-1);
                break;
            }
        }
    }

    public static Material getModdedMaterial(String modNamespace, String itemName){
        MinecraftKey key = new MinecraftKey(modNamespace, itemName);
        net. minecraft. server. v1_16_R3.Item nmsItem = IRegistry.ITEM.get(key);

        if (nmsItem == null) {
            System.out.println("❌ 모드 아이템을 찾을 수 없습니다: " + modNamespace + ":" + itemName);
            return null;
        }

        // NMS Item을 Bukkit ItemStack으로 변환
        return CraftItemStack.asBukkitCopy(new net.minecraft.server.v1_16_R3.ItemStack(nmsItem)).getType();
    }

    public static ItemStack buildItem(Material type, int amount , String displayName, String... lore) {
        ItemStack stack = new ItemStack(type, amount);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setLore(Arrays.asList(lore));
        stack.setItemMeta(meta);
        return stack;
    }


}
