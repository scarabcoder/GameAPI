package com.scarabcoder.gameapi.manager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import com.scarabcoder.gameapi.game.Area;
import com.scarabcoder.gameapi.game.ArenaSettings;
import com.scarabcoder.gameapi.game.Game;
import com.scarabcoder.gameapi.game.GamePlayer;

public class ArenaManager {
	
	/**
	 * Get a list of active settings for a position.
	 * If two ArenaSetting's priorities conflict, the first one that the computer finds is chosen.
	 * @param player GamePlayer
	 * @return ArenaSettings object for the location, or null if no settings apply.
	 */
	public static ArenaSettings getActiveSettings(Location location){
		
		int topPriority = -1;
		ArenaSettings settings = null;
		
		for(ArenaSettings setting : ArenaManager.getArenaSettingsByLocation(location)){
			if(setting.getPriority() > topPriority){
				settings = setting;
				topPriority = setting.getPriority();
			}
		}
		
		return settings;
		
	}
	
	/**
	 * Get a list of active settings for a player.
	 * If two ArenaSetting's priorities conflict, the first one that the computer finds is chosen.
	 * @param player GamePlayer
	 * @return ArenaSettings object with active settings, or null if the player is not in a game.
	 */
	public static ArenaSettings getActiveSettings(GamePlayer player){
		if(!player.isInGame()) return null;
		if(player.getAreas().size() == 0) return player.getGame().getArena().getArenaSettings();
		
		ArenaSettings settings = null;
		int topPriority = -1;
		
		for(Area area : player.getAreas()){
			if(area.useSettings()){
				if(area.getSettings().getPriority() > topPriority){
					settings = area.getSettings();
					topPriority = area.getSettings().getPriority();
				}
			}
		}
		
		return (settings == null ? player.getGame().getArena().getArenaSettings() : settings);
		
	}
	
	/**
	 * Get a list of ArenaSettings that apply to a location. This is cross-game!
	 * @param location Bukkit Location.
	 * @return List<Area>
	 */
	public static List<ArenaSettings> getArenaSettingsByLocation(Location location){
		List<ArenaSettings> settings = new ArrayList<ArenaSettings>();
		for(Game game : GameManager.getGames()){
			if(game.getArena().getWorld().getName().equals(location.getWorld().getName())) settings.add(game.getArena().getArenaSettings());
			for(Area area : game.getAreas()){
				if(area.useSettings()){
					Location l1 = area.getLocation1();
					Location l2 = area.getLocation2();
					if(
							location.getX() > l1.getX() && location.getX() < l2.getX() &&
							location.getY() > l1.getY() && location.getY() < l2.getY() &&
							location.getZ() > l1.getZ() && location.getZ() < l2.getZ()
							){
						settings.add(area.getSettings());
					}
				}
			}
		}
		return settings;
	}
	
}
