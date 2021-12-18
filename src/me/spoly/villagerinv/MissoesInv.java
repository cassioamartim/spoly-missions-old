package me.spoly.villagerinv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.spoly.config.ConfigManager;

public class MissoesInv extends ConfigManager implements Listener
{
    public static HashMap<String, Integer> valor;
    public static HashMap<String, String> apostado;
    public static HashMap<String, Integer> numero;
    
    static {
        MissoesInv.valor = new HashMap<String, Integer>();
        MissoesInv.apostado = new HashMap<String, String>();
        MissoesInv.numero = new HashMap<String, Integer>();
    }
    
    public static ItemStack getItem(final Material material, final String nome, final int quantidade, final int bite) {
        final ItemStack item = new ItemStack(material, quantidade, (short)bite);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    
    @EventHandler
    public void entitbiausdsan(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Villager) {
            final Villager v = (Villager)e.getEntity();
            if (v.getCustomName().equalsIgnoreCase("§7✽ §eMissões §7(Clique)")) {
                e.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void nsaioudnsa(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Villager) {
            final Villager v = (Villager)e.getRightClicked();
            if (v.getCustomName().equalsIgnoreCase("§7✽ §eMissões §7(Clique)")) {
                e.setCancelled(true);
                Seletor(e.getPlayer());
            }
        }
    }
    
    public static boolean containsItem(Inventory inv, String itemName) {
        return Stream.of(inv.getContents()).anyMatch(p -> p.getItemMeta().getDisplayName().equals(itemName));
     }
    
    public static void Seletor(final Player p) {
        if (MissoesInv.apostado.containsKey(p.getName())) {
            MissoesInv.apostado.remove(p.getName());
        }
        if (MissoesInv.valor.containsKey(p.getName())) {
            MissoesInv.valor.remove(p.getName());
        }
        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 36, "§7✽ §eMissões");
        
        ItemStack completo = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
        ItemMeta completom = completo.getItemMeta();
        ArrayList<String> lore3 = new ArrayList<String>();
        completom.setDisplayName("§7-");
        lore3.add("");
        lore3.add("§cVocê ja completou está missão.");
        lore3.add("");
        completom.setLore(lore3);
        completo.setItemMeta(completom);
        
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta bookm = book.getItemMeta();
        ArrayList<String> lore2 = new ArrayList<String>();
        bookm.setDisplayName("§6Ajuda§7: §fPrecisa de ajuda?");
        lore2.add("");
        lore2.add("§fOlá, este sistema foi feito para você receber");
        lore2.add("§6recompensas§f conforme o que você §3conquista§f.");
        lore2.add("");
        bookm.setLore(lore2);
        book.setItemMeta(bookm);
       
        ItemStack boss = new ItemStack(Material.MINECART);
        ItemMeta bossm = boss.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        bossm.setDisplayName("§b§lMissão 01: §fTroféu do Boss");
        lore.add("");
        lore.add("§fConsiga o troféu matando um boss, e traga-o");
        lore.add("§fPara mim, e receberá uma recompensa!");
        lore.add("");
        bossm.setLore(lore);
        boss.setItemMeta(bossm);
        
        ItemStack exp = new ItemStack(Material.MINECART);
        ItemMeta expm = exp.getItemMeta();
        ArrayList<String> lor2 = new ArrayList<String>();
        expm.setDisplayName("§b§lMissão 02: §fExpêriencia");
        lor2.add("");
        lor2.add("§fConsiga a meta de §b500 xp's§f e venha até mim");
        lor2.add("§fpara receber uma recompensa!");
        lor2.add("");
        expm.setLore(lor2);
        exp.setItemMeta(expm);
        
        
        
        
        inv.setItem(4, book);
       inv.setItem(10, boss);
       inv.setItem(11, exp);
        p.openInventory(inv);
        
        if(p.hasPermission("missao.trofeu")) {
        	inv.removeItem(boss);
        	inv.setItem(10, completo);
        }
        
        if(p.hasPermission("missao.exp")) {
        	inv.removeItem(exp);
        	inv.setItem(11, completo);
        }
    }
    
    
    	@SuppressWarnings("deprecation")
		@EventHandler
        public void onMissao(final InventoryClickEvent e) {
            final Player p = (Player)e.getWhoClicked();
            if (e.getInventory().getTitle().equalsIgnoreCase("§7✽ §eMissões") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                    e.setCancelled(true);
                    return;
                }
			
			if(e.getCurrentItem().getType() == Material.ENCHANTED_BOOK) {
				e.setCancelled(true);
				return;
			}
		     if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7-")) {
	                e.setCancelled(true);
	                p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 2.0f, 2.0f);
	                MissoesInv.Seletor(p);
	                return;
			}
		     if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lMissão 01: §fTroféu do Boss")) {
	                e.setCancelled(true);
	                p.closeInventory();
	                if(!p.getInventory().contains(Material.DIAMOND)){
	                p.sendMessage("§6§lSPOLY§f Você não tem o §bTroféu do Boss§f.");
	                p.playSound(p.getLocation(), Sound.EXPLODE, 2.0f, 2.0f);
	                return;
	                } else {
	                	p.closeInventory();
	                	p.sendMessage("§6§lSPOLY§f Você §acompletou§f a §emissão§f: §7Troféu do Boss§f.");
	                	p.getInventory().remove(Material.DIAMOND);
	                	p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 2.0f, 2.0f);
	                	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add missao.trofeu");
	                	return;
	                }
	                	}
	               }
	   		     if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lMissão 02: §fExpêriencia")) {
		                e.setCancelled(true);
		                p.closeInventory();
		                if(p.getLevel() < 500) {
		                p.sendMessage("§6§lSPOLY§f Você não tem §b500 xp's§f.");
		                p.playSound(p.getLocation(), Sound.EXPLODE, 2.0f, 2.0f);
		                return;
		                } else {
		                	p.closeInventory();
		                	p.sendMessage("§6§lSPOLY§f Você §acompletou§f a §emissão§f: §7Expêriencia§f.");
		                	p.setLevel(0);
		                	p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 2.0f, 2.0f);
		                	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add missao.exp");
		                	return;
		                }
		     }             
		     }
		     }
