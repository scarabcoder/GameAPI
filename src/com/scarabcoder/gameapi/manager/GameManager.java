package com.scarabcoder.gameapi.manager;

import java.util.ArrayList;
import java.util.List;

import com.scarabcoder.gameapi.game.Game;

public class GameManager {
	
	private static List<Game> games = new ArrayList<Game>();

	public static void registerGame(Game game){
		games.add(game);
		
	}
	
	public static List<Game> getGames(){
		return games;
	}
	
}
