package com.scarabcoder.gameapi.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;

import com.scarabcoder.gameapi.enums.GamePlayerType;

public class Team {
	
	private List<GamePlayer> players = new ArrayList<GamePlayer>();
	
	private boolean allowTeamDamage = false;
	private String name;
	private Color color;
	private ChatColor chatColor;
	private List<Location> teamSpawns;
	
	
	public Team(Color dyeColor, ChatColor chatColor, String name){
		this.color = dyeColor;
		this.name = name;
		this.chatColor = chatColor;
		this.teamSpawns = new ArrayList<Location>();
		
	}
	
	public List<GamePlayer> getPlayersByMode(GamePlayerType type){
		List<GamePlayer> ps = new ArrayList<GamePlayer>();
		for(GamePlayer p : this.players){
			if(p.getGame().getGamePlayerType(p).equals(type)){
				ps.add(p);
			}
		}
		return ps;
	}
	
	public void sendMessage(String msg){
		for(GamePlayer player : this.getPlayers()){
			if(player.isOnline()){
				player.getOnlinePlayer().sendMessage("[" + this.getChatColor() + name + ChatColor.RESET + "] " + msg);
			}
		}
	}
	
	public List<Location> getTeamSpawns(){
		return this.teamSpawns;
	}
	
	public void addTeamSpawn(Location location){
		this.teamSpawns.add(location);
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public ChatColor getChatColor(){
		return this.chatColor;
	}
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * Whether or not players can damage each other.
	 * @return boolean
	 */
	public boolean allowTeamDamage(){
		return allowTeamDamage;
	}
	
	/**
	 * Whether or not players can damage each other
	 * @param allow
	 */
	public void setAllowTeamDamage(boolean allow){
		this.allowTeamDamage = allow;
	}
	
	
	/**
	 * Add a player to the team. Players can be on multiple teams, though it isn't recommended.
	 * @param p The GamePlayer to be added.
	 */
	public void addPlayer(GamePlayer p){
		players.add(p);
		p.setTeam(this);
	}
	
	/**
	 * Removes the player from the team.
	 * @param p Player to remove.
	 */
	public void removePlayer(GamePlayer p){
		p.setTeam(null);
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
