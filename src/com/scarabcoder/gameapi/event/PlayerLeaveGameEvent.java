package com.scarabcoder.gameapi.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredListener;

import com.scarabcoder.gameapi.game.Game;
import com.scarabcoder.gameapi.game.GamePlayer;

public class PlayerLeaveGameEvent extends Event {
	private static final HandlerList handlers = new HandlerList();
	
	private GamePlayer player;
	private Game game;
	
	public PlayerLeaveGameEvent(GamePlayer player, Game game){
		this.player = player;
		this.game = game;
	}
	
	public GamePlayer getPlayer(){
		return this.player;
	}
	
	public Game getGame(){
		return this.game;
	}

	@Override
	public HandlerList getHandlers() {
		for(RegisteredListener listener : handlers.getRegisteredListeners()){
			if(!listener.getPlugin().equals(game.getRegisteringPlugin())){
				handlers.unregister(listener);
			}
		}
		return handlers;
	}
	
	public static HandlerList getHandlerList(){
		return handlers;
	}
}
