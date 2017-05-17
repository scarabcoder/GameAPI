package com.scarabcoder.gameapi.game;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Player;

import com.scarabcoder.gameapi.util.ColorUtil;

public class Team {
	
	private List<GamePlayer> players;
	
	private boolean allowTeamDamage = false;
	private String name;
	private DyeColor color;
	private ChatColor chatColor;
	
	
	public Team(DyeColor color, String name){
		this.color = color;
		this.name = name;
		this.chatColor = ColorUtil.dyeColorToChatColor(color);
	}
	
	public Team(DyeColor dyeColor, ChatColor chatColor, String name){
		this.color = dyeColor;
		this.name = name;
		this.chatColor = chatColor;
		
	}
	
	public DyeColor getDyeColor(){
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
