package com.scarabcoder.gameapi.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.scarabcoder.gameapi.game.Game;
import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.manager.GameManager;
import com.scarabcoder.gameapi.manager.PlayerManager;

public class PlayerJoinListener implements Listener{
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		GamePlayer player = PlayerManager.getGamePlayer(e.getPlayer());
		player.setPlayer(e.getPlayer());
		
		for(Game game : GameManager.getGames()){
			
			
			if(game.getGameSettings().usesBungee()){
				
				game.addPlayer(player);
				
				break;
			}
		}
		if(player.getGame().getGameSettings().shouldDisableVanillaJoinLeaveMessages()){
			e.setJoinMessage("");
		}
		
	}
	
}
