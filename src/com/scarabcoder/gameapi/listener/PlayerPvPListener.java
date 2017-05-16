package com.scarabcoder.gameapi.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.manager.PlayerManager;

public class PlayerPvPListener implements Listener {
	
	@EventHandler
	public void playerDamagePlayer(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
			GamePlayer player = PlayerManager.getGamePlayer((Player) e.getEntity());
			GamePlayer damager = PlayerManager.getGamePlayer((Player) e.getDamager());
			if(player.getOnlinePlayer().getHealth() - e.getFinalDamage() <= 0.0){
				if(player.isInGame() && damager.isInGame()){
					if(player.getTeam() != null && damager.getTeam() != null){
						if(player.getTeam().getName().equals(damager.getTeam().getName())){
							
						}
					}
				}
			}
		}
	}
	
}
