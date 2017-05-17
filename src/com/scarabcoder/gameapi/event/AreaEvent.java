package com.scarabcoder.gameapi.event;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.RegisteredListener;

import com.scarabcoder.gameapi.game.Area;
import com.scarabcoder.gameapi.game.GamePlayer;

public class AreaEvent extends Event implements Cancellable {

	private boolean cancelled = false;
	private static final HandlerList handlers = new HandlerList();
	private GamePlayer player;
	private Area area;
	
	
	public AreaEvent(GamePlayer player, Area area){
		this.player = player;
		this.area = area;
	}
	
	public GamePlayer getPlayer(){
		return this.player;
	}
	
	public Area getArea(){
		return this.area;
	}
	
	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	@Override
	public HandlerList getHandlers() {
		for(RegisteredListener listener : handlers.getRegisteredListeners()){
			if(!listener.getPlugin().equals(player.getGame().getRegisteringPlugin())){
				handlers.unregister(listener);
			}
		}
		return handlers;
	}
	public static HandlerList getHandlerList(){
		return handlers;
	}

}
