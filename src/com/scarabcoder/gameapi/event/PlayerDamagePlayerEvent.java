package com.scarabcoder.gameapi.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scarabcoder.gameapi.game.Game;
import com.scarabcoder.gameapi.game.GamePlayer;

public class PlayerDamagePlayerEvent extends Event implements Cancellable {
	
	private boolean cancelled = false;
	private static final HandlerList handlers = new HandlerList();
	
	private GamePlayer damager;
	private GamePlayer damaged;
	private Game game;
	
	public PlayerDamagePlayerEvent(GamePlayer damager, GamePlayer damaged, Game game){
		this.damaged = damaged;
		this.damager = damager;
		this.game = game;
	}
	
	public GamePlayer getDamager(){
		return this.damager;
	}
	
	public GamePlayer getDamaged(){
		return this.damaged;
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
		return handlers;
	}
	
	
	
}
