package com.scarabcoder.gameapi.manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.Plugin;

import com.scarabcoder.gameapi.GameAPI;
import com.scarabcoder.gameapi.game.Game;

public class GameManager {
	
	private static List<Game> games = new ArrayList<Game>();

	public static void registerGame(Game game, Plugin plugin){
		games.add(game);
		GameAPI.logInfo(plugin.getName() + " registered game " + game.getID() + ".");
		
	}
	
	public static List<Game> getGames(){
		return games;
	}
	
}
