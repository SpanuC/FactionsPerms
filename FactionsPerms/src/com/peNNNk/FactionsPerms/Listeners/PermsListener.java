package com.peNNNk.FactionsPerms.Listeners;

import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.Role;
import com.peNNNk.FactionsPerms.main;
import com.peNNNk.FactionsPerms.Utils.ColorUtil;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PermsListener implements Listener {
  @EventHandler
  public void onPlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
	boolean fopen = main.getInstance().getConfig().getBoolean("factions-open");
	if(fopen == true) {
    if (e.getMessage().toLowerCase().equalsIgnoreCase("/f open") || e.getMessage().toLowerCase().equalsIgnoreCase("/factions open")) {
      FPlayer player = FPlayers.getInstance().getByPlayer(e.getPlayer());
      if (player.hasFaction() && 
        !player.getRole().equals(Role.LEADER)) {
        e.setCancelled(true);
        e.getPlayer().sendMessage(ColorUtil.colour(main.getInstance().getConfig().getString("cannot-do-that")));
      } 
      return;
    } 
    }
	boolean ftag = main.getInstance().getConfig().getBoolean("factions-tag");
	if(ftag == true) {
    if (e.getMessage().toLowerCase().startsWith("/f tag") || e.getMessage().toLowerCase().startsWith("/factions tag")) {
      FPlayer player = FPlayers.getInstance().getByPlayer(e.getPlayer());
      if (player.hasFaction() && !player.getRole().equals(Role.LEADER)) {
        e.setCancelled(true);
        e.getPlayer().sendMessage(ColorUtil.colour(main.getInstance().getConfig().getString("cannot-do-that")));
      } 
      return;
    } 
	}
	boolean unclaimall = main.getInstance().getConfig().getBoolean("factions-unclaimall");
	if(unclaimall == true) {
    if (e.getMessage().toLowerCase().equalsIgnoreCase("/f unclaimall") || e.getMessage().equalsIgnoreCase("/factions unclaimall")) {
      FPlayer player = FPlayers.getInstance().getByPlayer(e.getPlayer());
      if (player.hasFaction() && !player.getRole().equals(Role.LEADER)) {
        e.setCancelled(true);
        e.getPlayer().sendMessage(ColorUtil.colour(main.getInstance().getConfig().getString("cannot-unclaimall")));
      }
      return;
    }
	}
  }
}

