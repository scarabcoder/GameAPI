package com.scarabcoder.gameapi.game;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.entity.Player;

import com.scarabcoder.gameapi.GameAPI;

public class Arena {
	
	private String id;
	
	private ArenaSettings settings;
	
	private Location spectatorSpawn;
	
	private Location lobbySpawn;
	
	private World world;
	
	/**
	 * Arena object, used in Game to define Arena world.
	 * If the world exists as a folder in the server directory but isn't loaded, it will be loaded. If it doesn't exist as a folder and isn't laoded, one will be created.
	 * @param id Unique Arena ID. Also used for world name.
	 */
	public Arena(String id){
		this.settings = new ArenaSettings();
		this.id = id;
		if(Bukkit.getWorld(id) == null){
			Bukkit.createWorld(new WorldCreator(id));
		}
		this.world = Bukkit.getWorld(id);
		this.saveDefault();
	}
	
	public String getName(){
		return this.id;
	}
	
	/**
	 * Get the global ArenaSettings for this arena.
	 * @return ArenaSettings
	 */
	public ArenaSettings getArenaSettings(){
		return this.settings;
	}
	
	/**
	 * Get the Bukkit world for this arena.
	 * @return World Bukkit world.
	 */
	public World getWorld(){
		return world;
	}
	
	/**
	 * Get the spectator spawnpoint.
	 * @return Location spawnpoint.
	 */
	public Location getSpectatorSpawn(){
		return spectatorSpawn;
	}
	
	/**
	 * Get the lobby spawnpoint.
	 * @return Location lobby spawnpoint.
	 */
	public Location getLobbySpawn(){
		return lobbySpawn;
	}
	
	/**
	 * Set the spawn used for spectators spawning.
	 * 
	 */
	public void setSpectatorSpawn(Location spectatorSpawn){
		this.spectatorSpawn = spectatorSpawn;
	}
	
	/**
	 * Set the spawn used when the game status is waiting.
	 */
	public void setLobbySpawn(Location lobbySpawn){
		this.lobbySpawn = lobbySpawn;
	}
	
	/**
	 * Saves current world as the default, used when resetting the world.
	 */
	public void saveDefault(){
		GameAPI.sendDebugMessage("Saving default world for " + this.getWorld().getName() + "...", GameAPI.getPlugin());
		File worldFolder = world.getWorldFolder();
		try {
			File dest = new File(GameAPI.getGameWorldsFolder(), this.world.getName());
			if(dest.exists()){
				GameAPI.sendDebugMessage("Deleting existing default world " + this.getWorld().getName() + "...", GameAPI.getPlugin());
				FileUtils.deleteDirectory(dest);
			}
			GameAPI.sendDebugMessage("Copying world " + this.getWorld().getName() + " to defaults folder...", GameAPI.getPlugin());
			FileUtils.copyDirectory(worldFolder, new File(GameAPI.getGameWorldsFolder(), this.world.getName()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Resets the world to saved default.
	 * Players should NOT be in the world. As a precaution against world corruption, any players in the world are kicked from the server.
	 */
	public void resetWorld(){
		GameAPI.sendDebugMessage("Resetting arena world " + this.getWorld().getName() + "!", GameAPI.getPlugin());
		File worldFolder = world.getWorldFolder();
		String worldName = world.getName();
		for(Player player : this.getWorld().getPlayers()){
			player.kickPlayer("World resetting...");
		}
		GameAPI.sendDebugMessage("Unloading world " + worldName + "...", GameAPI.getPlugin());
		Bukkit.unloadWorld(worldName, false);
		try {
			GameAPI.sendDebugMessage("Deleting world " + worldName + "...", GameAPI.getPlugin());
			FileUtils.deleteDirectory(worldFolder);
			GameAPI.sendDebugMessage("Copying default world from GameWorlds/" + worldName + "...", GameAPI.getPlugin());
			FileUtils.copyDirectory(new File(GameAPI.getGameWorldsFolder(), worldName), GameAPI.getGameWorldsFolder().getParentFile());
			GameAPI.sendDebugMessage("Loading world " + worldName + " on server...", GameAPI.getPlugin());
			Bukkit.createWorld(new WorldCreator(worldName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
