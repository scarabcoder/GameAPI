package com.scarabcoder.gameapi.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.scarabcoder.gameapi.enums.GamePlayerType;
import com.scarabcoder.gameapi.game.Game;
import com.scarabcoder.gameapi.game.GamePlayer;

public class PlayerJoinGameEvent extends Event {
	
	private static final HandlerList handlers = new HandlerList();
	
	private GamePlayer player;
	private Game game;
	private GamePlayerType type;
	
	public PlayerJoinGameEvent(GamePlayer player, Game game){
		this.player = player;
		this.game = game;
		this.type = GamePlayerType.PLAYER;
	}
	
	public void setGamePlayerType(GamePlayerType type){
		this.type = type;
	}
	
	public GamePlayerType getGamePlayerType(){
		return this.type;
	}
	
	public GamePlayer getPlayer(){
		return this.player;
	}
	
	public Game getGame(){
		return this.game;
	}
	
	public HandlerList getHandlers() {
		
		
		return handlers;
	}
	
	public static HandlerList getHandlerList(){
		return handlers;
	}

}
