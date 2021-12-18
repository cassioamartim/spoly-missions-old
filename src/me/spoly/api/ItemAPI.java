package me.spoly.api;

import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.*;
import org.bukkit.inventory.meta.*;

public class ItemAPI
{
	public static void nextItens(Player p) {
		
		ItemStack kits = new ItemStack(Material.CHEST);
		ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("§eOiee");
		kits.setItemMeta(kitsm);
	
		
		p.getInventory().setItem(4, kits);
	}
}