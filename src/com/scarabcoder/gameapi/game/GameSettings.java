package com.scarabcoder.gameapi.game;

public class GameSettings {
	
	private int minPlayers = 2;
	private int maxPlayers = 8;
	private int countdownTimer = 60;
	private int teamSize = 2;
	private boolean setMOTD = false;
	private boolean setListPlayerCount = false;
	private boolean ignorePlayerLimit = false;
	
	public GameSettings(){
		
	}
	
	/**
	 * Reset defaults.
	 */
	public void loadDefaults(){
		this.minPlayers = 2;
		this.maxPlayers = 8;
		this.countdownTimer = 60;
		this.teamSize = 2;
		this.setMOTD = false;
		this.setListPlayerCount = false;
		this.ignorePlayerLimit = false;
	}
	
	public boolean shouldIgnorePlayerLimit(){
		return this.ignorePlayerLimit;
	}
	
	public void shouldIgnorePlayerLimit(boolean shouldIgnore){
		this.ignorePlayerLimit = shouldIgnore;
	}
	
	/**
	 * Get whether or not the Game should set the MOTD (Message Of The Day) to the GameStatus.
	 * Default: false
	 * @return doesSetMOTD
	 */
	public boolean doesSetMOTD(){
		return setMOTD;
	}
	
	/**
	 * Set whether or not the Game should set the MOTD (Message Of The Day) for the server to the GameStatus.
	 * Default: false
	 * @param motd
	 */
	public void setMOTD(boolean motd){
		this.setMOTD = motd;
	}
	
	/**
	 * Whether or not the game should set the max players allowed for the server to the the Maximum Players.
	 * @return boolean
	 */
	public boolean doesSetListPlayerCount(){
		return this.setListPlayerCount;
	}
	
	/**
	 * Set whether or not the game should set hte max players allowed for the server to the maximum players.
	 * @param should set.
	 */
	public void shouldSetListPlayerCount(boolean should){
		this.setListPlayerCount = should;
	}
	
	/**
	 * Get the minimum players required the start this game.
	 * @return int number of players
	 */
	public int getMinimumPlayers(){
		return this.minPlayers;
	}
	
	/**
	 * Get the maximum amount of players that can join a game.
	 * You can define what happens when a player attempts to join when the limit is filled with GameSettings.setLimitedPlayerJoinAction().
	 * @return int max players.
	 */
	public int getMaximumPlayers(){
		return maxPlayers;
	}
	
	/**
	 * Get the maximum team size. Set to 1 to disable teams.
	 * @return
	 */
	public int getTeamSize(){
		return teamSize;
	}
	
	/**
	 * When the minimum player count is met, it will start the countdown timer. 
	 * 
	 * @return countdown time in seconds.
	 */
	public int getCountdownTime(){
		return countdownTimer;
	}
	
	/**
	 * Get the minimum players required the start this game.
	 * @param min minimum amount of players.
	 */
	public void setMinimumPlayers(int min){
		this.minPlayers = min;
	}
	
	/**
	 * Get the maximum amount of players that can join a game.
	 * You can define what happens when a player attempts to join when the limit is filled with GameSettings.setLimitedPlayerJoinAction().
	 * @param max
	 */
	public void setMaximumPlayers(int max){
		this.maxPlayers = max;
	}
	
	/**
	 * Get the maximum team size. Set to 1 to disable teams.
	 * @param size
	 */
	public void setTeamSize(int size){
		this.teamSize = size;
	}
	
	/**
	 * When the minimum player count is met, it will start the countdown timer. 
	 * @param seconds
	 */
	public void setCountdownTime(int seconds){
		this.countdownTimer = seconds;
	}
	
}
