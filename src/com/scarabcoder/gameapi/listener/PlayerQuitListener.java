package com.scarabcoder.gameapi.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.manager.PlayerManager;

public class PlayerQuitListener implements Listener {
	
	@EventHandler
	public void playerQuit(PlayerQuitEvent e){
		GamePlayer player = PlayerManager.getGamePlayer(e.getPlayer());
		if(player.getGame() != null){
			if(player.getGame().getGameSettings().shouldDisableVanillaJoinLeaveMessages()){
				e.setQuitMessage("");
			}
			if(player.getGame().getGameSettings().shouldLeavePlayerOnDisconnect()){
				player.getGame().removePlayer(player);
			}
		}
	}
	
}
