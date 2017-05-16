package com.scarabcoder.gameapi.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.scarabcoder.gameapi.event.AreaEvent;
import com.scarabcoder.gameapi.event.PlayerEnterAreaEvent;
import com.scarabcoder.gameapi.event.PlayerLeaveAreaEvent;
import com.scarabcoder.gameapi.game.Area;
import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.manager.PlayerManager;

public class PlayerMovementListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e){
		GamePlayer player = PlayerManager.getGamePlayer(e.getPlayer());
		if(player.isInGame()){
			for(Area area : player.getGame().getAreas()){
				Location f = e.getFrom();
				Location t = e.getTo();
				Location l1 = area.getLocation1();
				Location l2 = area.getLocation2();
				boolean fromIsIn = false;
				boolean toIsIn = false;
				if(
						(f.getX() > l1.getX() && f.getX() < l2.getX()) &&
						(f.getY() > l1.getY() && f.getY() < l2.getY()) &&
						(f.getZ() > l1.getZ() && f.getZ() < l2.getZ())){
					fromIsIn = true;
				}
				if(
						(t.getX() > l1.getX() && t.getX() < l2.getX()) &&
						(t.getY() > l1.getY() && t.getY() < l2.getY()) &&
						(t.getZ() > l1.getZ() && t.getZ() < l2.getZ())
						){
					toIsIn = true;
				}
				AreaEvent ev = null;
				if(fromIsIn && !toIsIn){
					ev = new PlayerLeaveAreaEvent(player, area);
				}else if(!fromIsIn && toIsIn){
					ev = new PlayerEnterAreaEvent(player, area);
				}
				if(ev != null){
					Bukkit.getPluginManager().callEvent(ev);
					e.setCancelled(ev.isCancelled());
				}
			}
		}
	}
	
}
