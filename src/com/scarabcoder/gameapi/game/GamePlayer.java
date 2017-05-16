package com.scarabcoder.gameapi.game;

import java.util.List;

import org.bukkit.entity.Player;

public class GamePlayer {
	
	private Player player;
	
	private Team team;
	
	private Game game;
	
	public GamePlayer(Player player){
		this.player = player;
	}
	
	/**
	 * Set the game this player is in. 
	 * Used by the internal API, bad things might happen if you set this yourself!
	 * @param game Game to be set.
	 */
	protected void setGame(Game game){
		this.game = game;
	}
	
	
	/**
	 * Get the Bukkit player.
	 * @return Player
	 */
	public Player getPlayer(){
		return player;
	}
	
	/**
	 * Set the team this player is in. This is an internal API method, bad things might happen if you set this yourself!
	 * @param team Team to be set.
	 */
	protected void setTeam(Team team){
		this.team = team;
	}
	
	/**
	 * Get the team this player is in. If the player is not in a team, returns null.
	 * @return Team object or null.
	 */
	public Team getTeam(){
		return team;
	}
	
	/**
	 * Get the game the player is in. 
	 * @return Game object if the player is in a game, null otherwise (see GamePlayer.isInGame())
	 */
	public Game getGame(){
		return game;
	}
	
	/**
	 * Returns whether or not the player is in a game.
	 * @return true if in a game, false otherwise.
	 */
	public boolean isInGame(){
		return this.game != null;
	}
	
	/**
	 * Get the list of areas this player is in. 
	 * @return List<Area> of areas. Only null if the player is not in a game.
	 */
	public List<Area> getAreas(){
		return null;
	}
	
}
