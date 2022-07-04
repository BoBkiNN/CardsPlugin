package xyz.bobkinn_.collectibilites;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;

public class Handler implements Listener {
    Plugin plugin;

    public Handler(Plugin plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        if (event.getAction() != Action.RIGHT_CLICK_AIR){
            return;
        }
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

        //cardgive
        if (clItem.isSimilar(cardItem)){

            ArrayList<Card> commons = CardMaker.getCommon(plugin);
            int var = Utils.randInt(0,commons.size()-1);
            Card choosen = commons.get(var);
            p.sendMessage(var+" card");
            int amountOld = p.getInventory().getItemInMainHand().getAmount();
            p.getInventory().getItemInMainHand().setAmount(amountOld-1);

            //card give
            ItemStack card = new ItemStack(Material.PAPER);
            card.setAmount(1);
            ItemMeta meta1 = card.getItemMeta();
            meta1.setDisplayName(choosen.getName());
            meta1.setLore(Arrays.asList(choosen.getLore()));
            meta1.setCustomModelData(choosen.getCmd());
            card.setItemMeta(meta1);
            p.getInventory().addItem(card);
        }
    }
}
