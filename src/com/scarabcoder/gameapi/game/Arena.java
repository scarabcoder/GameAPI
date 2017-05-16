package com.scarabcoder.gameapi.game;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class Arena {
	
	private String id;
	
	private ArenaSettings settings;
	
	private Location spectatorSpawn;
	
	private Location lobbySpawn;
	
	private World world;
	
	/**
	 * Arena object, used in Game to define Arena world.
	 * 
	 * @param id Unique Arena ID. Also used for world name.
	 */
	public Arena(String id){
		this.settings = new ArenaSettings();
		this.id = id;
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
	public void setSpectatorSpawn(){
		
	}
	
	/**
	 * Set the spawn used when the game status is waiting.
	 */
	public void setLobbySpawn(){
		
	}
	
	/**
	 * Saves current world as the default, used when resetting the world.
	 */
	public void saveDefault(){
		
	}
	/**
	 * Resets the world to saved default.
	 * 
	 */
	public void resetWorld(){
		
	}
	
	
}
