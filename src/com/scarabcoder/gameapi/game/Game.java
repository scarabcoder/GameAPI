package com.scarabcoder.gameapi.game;

import java.util.List;

import com.scarabcoder.gameapi.enums.GameStatus;
import com.scarabcoder.gameapi.manager.PlayerManager;
import com.scarabcoder.gameapi.manager.TeamManager;

public class Game {
	
	private String id;
	
	private GameStatus status;
	
	private Arena arena;
	
	private GameSettings settings;
	
	private TeamManager teamManager;
	
	private PlayerManager playerManager;
	
	private List<Area> areas;
	
	private List<GamePlayer> players;
	
	public Game(String id, Arena arena, GameStatus status){
		this.id = id;
		this.arena = arena;
		this.teamManager = new TeamManager();
		this.playerManager = new PlayerManager();
		
		
	}
	
	/**
	 * Get all the areas registered to this Game.
	 * @return List<Area>
	 */
	public List<Area> getAreas(){
		return areas;
	}
	
	public Arena getArena(){
		return this.arena;
	}
	
}
