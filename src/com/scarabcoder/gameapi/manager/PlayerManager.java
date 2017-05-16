package com.scarabcoder.gameapi.manager;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.OfflinePlayer;

import com.scarabcoder.gameapi.game.GamePlayer;

public class PlayerManager {
	
	private static HashMap<UUID, GamePlayer> playerMap = new HashMap<UUID, GamePlayer>();
	
	/**
	 * Get the GamePlayer given a Bukkit Player. GamePlayers are initiated once per server session, and are saved whether or not a player is online.
	 * @param player
	 * @return
	 */
	public static GamePlayer getGamePlayer(OfflinePlayer player){
		if(playerMap.containsKey(player.getUniqueId())){
			return playerMap.get(player);
		}else{
			GamePlayer gpl = new GamePlayer(player);
			playerMap.put(player.getUniqueId(), gpl);
			return gpl;
		}
	}
	
}
