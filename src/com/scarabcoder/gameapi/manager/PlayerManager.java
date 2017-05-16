package com.scarabcoder.gameapi.manager;

import java.util.HashMap;

import org.bukkit.entity.Player;

import com.scarabcoder.gameapi.game.GamePlayer;

public class PlayerManager {
	
	private static HashMap<Player, GamePlayer> playerMap = new HashMap<Player, GamePlayer>();
	
	public static GamePlayer getGamePlayer(Player player){
		if(playerMap.containsKey(player)){
			return playerMap.get(player);
		}else{
			GamePlayer gpl = new GamePlayer(player);
			playerMap.put(player, gpl);
			return gpl;
		}
	}
	
}
