package com.scarabcoder.gameapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.scarabcoder.gameapi.listener.PlayerMovementListener;
import com.scarabcoder.gameapi.listener.SettingsListener;

public class GameAPI extends JavaPlugin {
	
	@Override
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(new PlayerMovementListener(), this);
		Bukkit.getPluginManager().registerEvents(new SettingsListener(), this);
	}
	
}
