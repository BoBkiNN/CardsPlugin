package xyz.bobkinn_.collectibilites;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Handler implements Listener {

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        Player p = event.getPlayer();
        ItemStack clItem = event.getItem();
        if (clItem == null ||  clItem.getType() == Material.AIR){
            return;
        }
        ItemStack cardItem = new ItemStack(Material.PAPER,1);
        ItemMeta meta = cardItem.getItemMeta();
        assert meta != null;
        meta.addEnchant(Enchantment.MENDING,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setCustomModelData(1000000);
        meta.setDisplayName("§b§lНеизвестная карта");
        meta.setLore(Arrays.asList("§eНажмите ПКМ для открытия", "описание"));
        cardItem.setItemMeta(meta);



        if (clItem.getType() == Material.DIAMOND){
            int amountOld = p.getInventory().getItemInMainHand().getAmount();
            p.getInventory().getItemInMainHand().setAmount(amountOld-1);
            event.getPlayer().getInventory().addItem(cardItem);
        }
        if (clItem.isSimilar(cardItem)){
            int var = Utils.randInt(0,5);

            p.sendMessage(var+" card");
            int amountOld = p.getInventory().getItemInMainHand().getAmount();
            p.getInventory().getItemInMainHand().setAmount(amountOld-1);
        }
    }
}
