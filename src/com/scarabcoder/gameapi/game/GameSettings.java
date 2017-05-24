package com.scarabcoder.gameapi.game;

import org.bukkit.GameMode;
import org.bukkit.Location;

import com.scarabcoder.gameapi.enums.PlayerJoinLimitAction;
import com.scarabcoder.gameapi.enums.TeamSpreadType;

public class GameSettings {
	
	private int minPlayers;
	private int maxPlayers;
	private int countdownTimer;
	private boolean setMOTD;
	private boolean setListPlayerCount;
	private boolean enableBungee;
	private Location lobbySpawn;
	private String lobbyServer;
	private PlayerJoinLimitAction limitAction;
	private boolean shouldLeavePlayerOnDisconnect;
	private boolean useTeams;
	private TeamSpreadType spreadType;
	private GameMode mode;
	private GameMode spectatorMode;
	private boolean teleportPlayersOnGameStart;
	private boolean automaticCountdown;
	private int foodLevel;
	private double healthLevel;
	private int minTeamSize;
	private int maxTeamSize;
	private boolean autoTeamCompensation;
	private boolean disableVanillaJoinLeaveMessages;
	private boolean displayVanillaDeathMessages;
	private boolean resetWorlds;
	
	public GameSettings(){
		loadDefaults();
	}
	
	/**
	 * Reset defaults.
	 */
	public void loadDefaults(){
		this.minPlayers = 2;
		this.maxPlayers = 8;
		this.countdownTimer = 60;
		this.setMOTD = false;
		this.setListPlayerCount = false;
		this.limitAction = PlayerJoinLimitAction.DISALLOW;
		this.shouldLeavePlayerOnDisconnect = true;
		this.useTeams = false;
		this.spreadType = TeamSpreadType.EVEN;
		this.mode = GameMode.SURVIVAL;
		this.spectatorMode = GameMode.SPECTATOR;
		this.setTeleportPlayersOnGameStart(true);
		this.setAutomaticCountdown(true);
		this.foodLevel = 20;
		this.healthLevel = 20.0d;
		this.minTeamSize = 1;
		this.maxTeamSize = 4;
		this.autoTeamCompensation = false;
		this.disableVanillaJoinLeaveMessages = true;
		this.enableBungee = false;
		this.displayVanillaDeathMessages = true;
		this.resetWorlds = false;
	}
	
	public boolean shouldResetWorlds(){
		return this.resetWorlds;
	}
	
	public void setResetWorlds(boolean reset){
		this.resetWorlds = reset;
	}
	
	public boolean shouldDisableVanillaDeathMessages(){
		return this.displayVanillaDeathMessages;
	}
	
	public void setDisableVanillaDeathMessages(boolean display){
		this.displayVanillaDeathMessages = display;
	}
	
	/**
	 * Get whether or not teams should automatically be re-arranged if the team spread type is set to EVEN.
	 * Auto compensation occurs when during the PlayerLeaveGameEvent.
	 * Default: false
	 * @return
	 */
	public boolean getAutomaticTeamSizeCompensationEnabled(){
		return this.autoTeamCompensation;
	}
	
	/**
	 * Whether or not the vanilla "x joined the game/x left the game" messages should be disabled.
	 * Default: true
	 * @return
	 */
	public boolean shouldDisableVanillaJoinLeaveMessages(){
		return this.disableVanillaJoinLeaveMessages;
	}
	
	/**
	 * Set whether or not the vanilla "x joined the game/x left the game" messages should be disabled.
	 * Default: true
	 * @return
	 */
	public void shouldDisableVanillaJoinLeaveMessages(boolean disable){
		this.disableVanillaJoinLeaveMessages = disable;
	}
	
	/**
	 * Set whether or not teams should automatically be re-arranged if the team spread type is set to EVEN.
	 * Auto compensation occurs when during the PlayerLeaveGameEvent.
	 * Default: false
	 * @return
	 */
	public void setAutomaticTeamSizeCompensationEnabled(boolean enable){
		this.autoTeamCompensation = enable;
	}
	
	/**
	 * Get the minimum team size. Only used if teams are enabled.
	 * @return Minimum team size.
	 */
	public int getMinimumTeamSize(){
		return this.minTeamSize;
	}
	
	/**
	 * Set the minimum team size. Only used if teams are enabled.
	 * @param minSize Minimum team size.
	 */
	public void setMinimumTeamSize(int minSize){
		this.minTeamSize = minSize;
	}
	
	/**
	 * Get the maximum team size. Only used if teams are enabled.
	 * @return Maximum team size.
	 */
	public int getMaximumTeamSize(){
		return this.maxTeamSize;
	}
	
	/**
	 * Set the maximum team size. Only used if teams are enabled.
	 * @param maxSize Maximum team size.
	 */
	public void setMaximumTeamSize(int maxSize){
		this.maxTeamSize = maxSize;
	}
	
	/**
	 * Get whether or not the countdown should start when the minimum players required are filled.
	 * @return
	 */
	public boolean getAutomaticCountdown() {
		return automaticCountdown;
	}
	
	/**
	 * Set whether or not the countdown should start when the minimum players required are filled.
	 * @param automaticCountdown
	 */
	public void setAutomaticCountdown(boolean automaticCountdown) {
		this.automaticCountdown = automaticCountdown;
	}

	/**
	 * Whether or not players should be teleported to team spawns or game spawns on game start.
	 * @return
	 */
	public boolean shouldTeleportPlayersOnGameStart() {
		return teleportPlayersOnGameStart;
	}
	
	/**
	 * Set whether or not players should be teleported to team spawns or game spawns on game start.
	 * @param teleportPlayersOnGameStart
	 */
	public void setTeleportPlayersOnGameStart(boolean teleportPlayersOnGameStart) {
		this.teleportPlayersOnGameStart = teleportPlayersOnGameStart;
	}

	/**
	 * Get the Minecraft GameMode that players should be in while playing the game.
	 * @return
	 */
	public GameMode getMode() {
		return mode;
	}
	
	
	/**
	 * Set the Minecraft GameMode that players should be in while playing the game.
	 * @param mode
	 */
	public void setMode(GameMode mode) {
		this.mode = mode;
	}
	
	/**
	 * Get the Minecraft GameMode that spectators should be in while playing the game.
	 * @return
	 */
	public GameMode getSpectatorMode() {
		return spectatorMode;
	}

	/**
	 * Set the Minecraft GameMode that spectators should be in while playing the game.
	 * @param spectatorMode
	 */
	public void setSpectatorMode(GameMode spectatorMode) {
		this.spectatorMode = spectatorMode;
	}

	/**
	 * Get the team spread type. See TeamSpreadType.EVEN and TeamSpreadType.FIRST_AVAILABLE for more info.
	 * @return Team spread type.
	 */
	public TeamSpreadType getTeamSpreadType(){
		return this.spreadType;
	}
	
	/**
	 * Set the team spread type. See TeamSpreadType.EVEN and TeamSpreadType.FIRST_AVAILABLE for more info.
	 * @param type
	 */
	public void setTeamSpreadType(TeamSpreadType type){
		this.spreadType = type;
	}
	
	/**
	 * Whether or not teams are enabled. If enabled, players will automatically be added to an available team, sorted via the set TeamSpreadType.
	 * @return boolean
	 */
	public boolean shouldUseTeams(){
		return this.useTeams;
	}
	
	/**
	 * Set whether or not teams are enabled. If enabled, players will automatically be added to an available team, sorted via the set TeamSpreadType.
	 * @param should
	 */
	public void shouldUseTeams(boolean should){
		this.useTeams = should;
	}
	
	/**
	 * Whether or not the player should be removed from the game when they disconnect from the server.
	 * @return
	 */
	public boolean shouldLeavePlayerOnDisconnect(){
		return this.shouldLeavePlayerOnDisconnect;
	}
	
	/**
	 * Set whether or not the player should be removed from the game when they disconnect from the server.
	 * @param should
	 */
	public void shouldLeavePlayerOnDisconnect(boolean should){
		this.shouldLeavePlayerOnDisconnect = should;
	}
	
	/**
	 * Get whether or not the game uses Bungee servers.
	 * @return Bungee enabled
	 */
	public boolean usesBungee(){
		return this.enableBungee;
	}
	
	/**
	 * Set whether or not the game should use Bungee servers.
	 * @param bungee boolean.
	 */
	public void setUsesBungee(boolean bungee){
		this.enableBungee = bungee;
	}
	
	/**
	 * Set the lobby location. Only used if bungee mode is disabled.
	 * @param location
	 */
	public void setLobbyLocation(Location location){
		this.lobbySpawn = location;
	}
	
	/**
	 * Set the lobby server that the player should be sent to on game end/leave. Only used if bungee mode is enabled.
	 * @param server
	 */
	public void setLobbyServer(String server){
		this.lobbyServer = server;
	}
	
	public Location getLobbyLocation(){
		return this.lobbySpawn;
	}
	
	public String getLobbyServer(){
		return this.lobbyServer;
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
	 * You can define what happens when a player attempts to join when the limit is filled with GameSettings.getLimitedPlayerJoinAction().
	 * @return int max players.
	 */
	public int getMaximumPlayers(){
		return maxPlayers;
	}
	
	public PlayerJoinLimitAction getLimitedPlayerJoinAction(){
		return this.limitAction ;
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
	 * When the minimum player count is met, it will start the countdown timer. 
	 * @param seconds
	 */
	public void setCountdownTime(int seconds){
		this.countdownTimer = seconds;
	}

	public int getFoodLevel() {
		return foodLevel;
	}

	public void setFoodLevel(int foodLevel) {
		this.foodLevel = foodLevel;
	}

	public double getHealthLevel() {
		return healthLevel;
	}

	public void setHealthLevel(double healthLevel) {
		this.healthLevel = healthLevel;
	}
	
}
