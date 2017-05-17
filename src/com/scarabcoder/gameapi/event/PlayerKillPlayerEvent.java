package com.scarabcoder.gameapi.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredListener;

import com.scarabcoder.gameapi.game.Game;
import com.scarabcoder.gameapi.game.GamePlayer;

public class PlayerKillPlayerEvent extends Event implements Cancellable{
	
	private boolean cancelled = false;
	
	private static final HandlerList handlers = new HandlerList();
	
	private GamePlayer killer;
	private GamePlayer killed;
	private Game game;
	
	public PlayerKillPlayerEvent(GamePlayer killer, GamePlayer killed, Game game){
		this.killer = killer;
		this.killed = killed;
		this.game = game;
	}
	
	public GamePlayer getKiller(){
		return this.killer;
	}
	
	public GamePlayer getKilled(){
		return this.killed;
	}
	
	public Game getGame(){
		return this.game;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
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
