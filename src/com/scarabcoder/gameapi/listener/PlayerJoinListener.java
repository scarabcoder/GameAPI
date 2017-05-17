package com.scarabcoder.gameapi.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.scarabcoder.gameapi.manager.PlayerManager;

public class PlayerJoinListener implements Listener{
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		PlayerManager.getGamePlayer(e.getPlayer());
	}
	
}
