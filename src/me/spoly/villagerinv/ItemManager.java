package me.spoly.villagerinv;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static ArrayList<String> lore = new ArrayList();
    public static ItemStack Brite() {
        lore.clear();
        lore.add("");
        lore.add("§bClique com o botão direito para poder spawnar.");
        lore.add("§bEle não poderá te atacar, fique tranquilo.");
        lore.add("§b");
        lore.add("§f§oBoss de Nível: I");
        lore.add("§f§oRaridade: Super Baixa");
        lore.add("");
        ItemStack i = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§b§lBOSS BRITE");
        m.setLore(lore);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack Electra() {
        lore.clear();
        lore.add("");
        lore.add("§bClique com o botão direito para poder spawnar.");
        lore.add("§bEle não poderá te atacar, fique tranquilo.");
        lore.add("§b");
        lore.add("§f§oBoss de Nível: II");
        lore.add("§f§oRaridade: Baixa");
        lore.add("");
        ItemStack i = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§b§lBOSS ELECTRA");
        m.setLore(lore);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack Musk() {
        lore.clear();
        lore.add("");
        lore.add("§bClique com o botão direito para poder spawnar.");
        lore.add("§bEle não poderá te atacar, fique tranquilo.");
        lore.add("§b");
        lore.add("§f§oBoss de Nível: III");
        lore.add("§f§oRaridade: Comúm");
        lore.add("");
        ItemStack i = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§b§lBOSS MUSK");
        m.setLore(lore);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack Albanus() {
        lore.clear();
        lore.add("");
        lore.add("§bClique com o botão direito para poder spawnar.");
        lore.add("§bEle não poderá te atacar, fique tranquilo.");
        lore.add("§b");
        lore.add("§f§oBoss de Nível: IV");
        lore.add("§f§oRaridade: Alta");
        lore.add("");
        ItemStack i = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§b§lBOSS ALBANUS");
        m.setLore(lore);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack Cash() {
        lore.clear();
        lore.add("");
        lore.add("§bClique com o botão direito para poder ativar.");
        lore.add("§bPapel de cash recebido ao matar entity.");
        lore.add("§b");
        lore.add("§f§oValor do Cash: ✪ 100");
        lore.add("§f§oRaridade: Rara");
        lore.add("");
        ItemStack i = new ItemStack(Material.PAPER);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§b§l✪ Papel de Cash");
        m.setLore(lore);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack Ticket() {
        lore.clear();
        lore.add("");
        lore.add("§4Vá até a warp trocas para utilizar este item.");
        lore.add("§4Ticket arcânico, recebido ao matar entity.");
        lore.add("§b");
        lore.add("§f§oRaridade: Alta");
        lore.add("");
        ItemStack i = new ItemStack(Material.PAPER);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§4§l✪ Ticket Arcânico");
        m.setLore(lore);
        i.setItemMeta(m);
        return i;
    }

    public static ItemStack Trofeu() {
        lore.clear();
        lore.add("");
        lore.add("§fTroféu obtido ao matar um boss.");
        lore.add("§fUse-o para completar sua missão no spawn.");
        lore.add("§fDepois de completar-la, você pode vende-lo na warp drops.");
        lore.add("");
        ItemStack i = new ItemStack(Material.DIAMOND);
        ItemMeta m = i.getItemMeta();
        m.setDisplayName("§4§lTroféu do Boss");
        m.setLore(lore);
        i.setItemMeta(m);
        return i;
    }
}