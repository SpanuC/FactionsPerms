package com.peNNNk.FactionsPerms;

import com.peNNNk.FactionsPerms.Listeners.PermsListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public class main extends JavaPlugin implements Listener {
	  private static main instance;
	  
	  public void onEnable() {
	    (instance = this).info();
	    getServer().getPluginManager().registerEvents((Listener)new PermsListener(), (Plugin)this);
	    getConfig().options().copyDefaults(true);
	    saveDefaultConfig();
	  }
	  
	  public static main getInstance() {
	    return instance;
	  }
	  
	  
	  public boolean findHook() {
	    return (getServer().getPluginManager().getPlugin("Factions") != null);
	  }
	  
	  public void info() {
	    getServer().getLogger().info("=============[FactionsPerms]=============");
	    getServer().getLogger().info("Searching for a factions plugin...");
	    getServer().getLogger().info(findHook() ? "A factions plugin has been found!" : "No factions plugin was found! stopping plugin...");
	    if (!findHook()) {
	      getServer().getPluginManager().disablePlugin((Plugin)this);
	    } else {
	      getServer().getLogger().info("[FactionsPerms] Plugin started successfully!");
	    } 
	  }
	}
