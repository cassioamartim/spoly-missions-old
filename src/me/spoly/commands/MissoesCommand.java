package me.spoly.commands;

import org.bukkit.command.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;

import me.spoly.api.ItemAPI;
import me.spoly.config.ConfigManager;

public class MissoesCommand extends ConfigManager implements CommandExecutor
{
	
	
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cEntre no servidor!");
            return true;
        }
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("setmissoes")) {
            return false;
        }
        if (p.hasPermission("spoly.missao")) {
            spawnarVillager(p.getLocation());
            p.sendMessage("§6§lSPOLY§f Você setou o §cvillager§f de §emissões§f.");
            p.playSound(p.getLocation(), Sound.ANVIL_USE, 2f, 2f);
            ItemAPI.nextItens(p);
            return true;
        } else {
        	p.sendMessage("§6§lSPOLY§f Você não tem §cpermissão§f para setar o §cvillager§f de §emissões§f.");
        	p.playSound(p.getLocation(), Sound.EXPLODE, 2.0f, 2.0f);
        }
        return false;
    }
    
    @SuppressWarnings("deprecation")
	public static void spawnarVillager(final Location local) {
        final Villager v = (Villager)Bukkit.getServer().getWorld(local.getWorld().getName()).spawnEntity(local, EntityType.VILLAGER);
        v.setCanPickupItems(false);
        v.setAdult();
        v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 9999999, 255));
        v.setHealth(20);
        v.setCustomName("§7✽ §eMissões §7(Clique)");
        v.setProfession(Villager.Profession.PRIEST);
    }
}
