package me.spoly;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.spoly.commands.MissoesCommand;
import me.spoly.config.MyConfigManager;
import me.spoly.villagerinv.MissoesInv;

@SuppressWarnings("all")
public class Main extends JavaPlugin
{

public static MyConfigManager manager;
public static ArrayList<String> score = new ArrayList();


public static String prefix;
public static Plugin plugin;
public static String motd;
public static String motd2;
public static Main instance;
public static Main getInstace() {
	return instance;
}

public static Main getPlugin() {
    return (Main)JavaPlugin.getProvidingPlugin((Class<?>)Main.class);
}
public static Plugin Plugin()
{
  return plugin;
}

  public void onEnable()
  {
	  instance = this;
	  instance = this;
      
      try {
          saveDefaultConfig();
        }
        catch (Exception localException) {
        }
      
      
    ConsoleCommandSender e = Bukkit.getConsoleSender();
    e.sendMessage("§aPlugin de missoes inicializado.");
    
    manager = new MyConfigManager(this);
    Eventos();
    Comandos();
  }
  
  public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
      if (!(sender instanceof Player)) {
          return false;
      }
      if (args.length == 0) {
          return false;
      }
      final Player p = (Player)sender;
      final ByteArrayOutputStream b = new ByteArrayOutputStream();
      final DataOutputStream out = new DataOutputStream(b);
      try {
          out.writeUTF("Connect");
          out.writeUTF(args[0]);
      }
      catch (IOException ex) {}
      p.sendPluginMessage((Plugin)this, "BungeeCord", b.toByteArray());
      return true;
  }

  public void onDisable()
  {
    ConsoleCommandSender e = Bukkit.getConsoleSender();
    e.sendMessage("§cPlugin de missoes desativado");
  }

  public void Eventos()
  {
    PluginManager Eventos = Bukkit.getPluginManager();
    Eventos.registerEvents(new MissoesInv(), this);
  }

  void Comandos()
  {
	  getCommand("setmissoes").setExecutor(new MissoesCommand());
  }
}
