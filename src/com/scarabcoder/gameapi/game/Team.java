package com.scarabcoder.gameapi.game;

import java.util.List;

import org.bukkit.DyeColor;
import org.bukkit.entity.Player;

public class Team {
	
	private List<GamePlayer> players;
	
	public Team(DyeColor color, String name){
		
	}
	
	/**
	 * Add a player to the team. Players can be on multiple teams, though it isn't recommended.
	 * @param p The Bukkit Player player to be added.
	 */
	public void addPlayer(Player p){
		players.add(new GamePlayer(p));
	}
	
	
	/**
	 * Add a player to the team. Players can be on multiple teams, though it isn't recommended.
	 * @param p The GamePlayer to be added.
	 */
	public void addPlayer(GamePlayer p){
		players.add(p);
	}
	
	/**
	 * Removes the player from the team.
	 * @param p Player to remove.
	 */
	public void removePlayer(GamePlayer p){
		players.remove(p);
	}
	
	/**
	 * Get a list of players on the team.
	 * @return List of players on the team.
	 */
	public List<GamePlayer> getPlayers(){
		return players;
	}
	
}
