package com.scarabcoder.gameapi.game;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.scarabcoder.gameapi.GameAPI;
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
	
	private String messagePrefix;
	
	private List<Area> areas;
	
	private List<GamePlayer> players;
	
	private Runnable loop;
	
	public Game(String id, Arena arena, GameStatus status){
		this.id = id;
		this.arena = arena;
		this.teamManager = new TeamManager();
		this.playerManager = new PlayerManager();
		this.messagePrefix = "";
		this.areas = new ArrayList<Area>();
		this.players = new ArrayList<GamePlayer>();
		this.loop = new Runnable(){

			@Override
			public void run() {
				
			}};
		final Game game = this;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(GameAPI.getPlugin(), new Runnable(){
			@Override
			public void run() {
				game.getRunnable().run();
			}
			
		}, 0L, 20L);
	}
	
	/**
	 * End the game, kicking all players and resetting the arena.
	 */
	public void endGame(){
		this.arena.resetWorld();
	}
	
	/**
	 * Add a player to the game. You must handle teleporting.
	 * @param player
	 */
	public void addPlayer(GamePlayer player){
		this.players.add(player);
		player.setGame(this);
	}
	
	/**
	 * Removes the player from the game, and sends them to the lobby set in GameSettings. 
	 * 
	 * @param player
	 */
	public void removePlayer(GamePlayer player){
		if(player.isOnline()){
			this.players.remove(player);
			if(this.getGameSettings().usesBungee()){
		
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF(this.getGameSettings().getLobbyServer());
		
				
				player.getOnlinePlayer().sendPluginMessage(GameAPI.getPlugin(), "BungeeCord", out.toByteArray());
			}else{
				player.getOnlinePlayer().teleport(this.getGameSettings().getLobbyLocation());
			}
		}
	}
	
	/**
	 * Set what happens every second in the game.
	 * @param runnable Runnable object.
	 */
	public void setLoopRunnable(Runnable runnable){
		this.loop = runnable;
	}
	
	/**
	 * Get what happens every second in the game.
	 * @return Runnable
	 */
	public Runnable getRunnable(){
		return this.loop;
	}
	
	
	/**
	 * Send a game message. Messages are prefixed with the set message prefix (set/getMessagePrefix())
	 * @param message Message to be sent.
	 */
	public void sendMessage(String message){
		for(GamePlayer player : this.getPlayers()){
			if(player.isOnline()){
				player.getOnlinePlayer().sendMessage(messagePrefix + " " + message);
			}
		}
	}
	
	/**
	 * Set the message prefix. For example, "[Survival Games] "
	 * @param prefix Prefix to set.
	 */
	public void setMessagePrefix(String prefix){
		this.messagePrefix = prefix;
	}
	
	/**
	 * Get the message prefix.
	 * @return String message prefix.
	 */
	public String getMessagePrefix(){
		return this.messagePrefix;
	}
	
	/**
	 * Get the unique ID for this game.
	 * @return String name
	 */
	public String getID(){
		return id;
	}
	
	/**
	 * Get the current game's status
	 * @return GameStatus
	 */
	public GameStatus getGameStatus(){
		return this.status;
	}
	
	
	/**
	 * Get the game settings, used for things like minimum and maximum player count.
	 * @return
	 */
	public GameSettings getGameSettings(){
		return this.settings;
	}
	
	/**
	 * Get the Team Manager for this Game, used for creating/managing teams.
	 * @return Team Manager
	 */
	public TeamManager getTeamManager(){
		return this.teamManager;
	}
	
	/**
	 * Get the Player Manager for this Game.
	 * @return Player Manager
	 */
	public PlayerManager getPlayerManager(){
		return this.playerManager;
	}
	
	/**
	 * Get all the GamePlayers in this game.
	 * @return List<GamePlayer>
	 */
	public List<GamePlayer> getPlayers(){
		return this.players;
	}
	
	/**
	 * Get all the areas registered to this Game.
	 * @return List<Area>
	 */
	public List<Area> getAreas(){
		return areas;
	}
	
	/**
	 * Get the global arena object for this game.
	 * @return Arena
	 */
	public Arena getArena(){
		return this.arena;
	}
	
}
