package com.scarabcoder.gameapi.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.scarabcoder.gameapi.util.LocationUtil;

public class GamePlayer {
	
	private OfflinePlayer player;
	
	private Team team;
	
	private Game game;
	
	public GamePlayer(OfflinePlayer player){
		this.player = player;
	}
	
	
	public void setPlayer(OfflinePlayer player){
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
	 * Get the Bukkit (offline) player.
	 * For the online player, use getOnlinePlayer(). Make sure you check if the player is online with isOnline()!
	 * @return OfflinePlayer
	 */
	public OfflinePlayer getPlayer(){
		return player;
	}
	
	/**
	 * Get the online Bukkit Player.
	 * @return Player if online, null if otherwise.
	 */
	public Player getOnlinePlayer(){
		return player.getPlayer();
	}
	
	/**
	 * Checks whether or not the player is online.
	 * @return boolean online
	 */
	public boolean isOnline(){
		return getOnlinePlayer() != null;
	}
	
	/**
	 * Set the team this player is in. This is an internal API method, bad things might happen if you set this yourself!
	 * @param team Team to be set.
	 */
	protected void setTeam(Team team){
		Team oldTeam = this.team;
		this.team = team;
		if(oldTeam != null){
			oldTeam.removePlayer(this);
		}
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
	 * @return List<Area> of areas. Only null if the player is not in a game, or is offline.
	 */
	public List<Area> getAreas(){
		if(!this.isInGame()) return null;
		if(!this.isOnline()) return null;
		List<Area> areas = new ArrayList<Area>();
		for(Area area : this.getGame().getAreas()){
			if(LocationUtil.isInArea(this.getOnlinePlayer().getLocation(), area.getLocation1(), area.getLocation2()))
				areas.add(area);
			
		}
		return areas;
	}
	
}
