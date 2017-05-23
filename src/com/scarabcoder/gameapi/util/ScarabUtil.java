package com.scarabcoder.gameapi.util;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.scarabcoder.gameapi.game.GamePlayer;
import com.scarabcoder.gameapi.manager.PlayerManager;

public class ScarabUtil {
	
	public static boolean isPlayerDamager(EntityDamageByEntityEvent e){
		return getDamager(e) != null;
	}
	
	public static GamePlayer getDamager(EntityDamageByEntityEvent e){
		if(e.getDamager() instanceof Player){
			return PlayerManager.getGamePlayer(((Player) e.getDamager()));
		}else if(e.getDamager() instanceof Projectile){
			Projectile a = (Projectile) e.getDamager();
			if(a.getShooter() != null){
				if(a.getShooter() instanceof Player){
					return PlayerManager.getGamePlayer((Player)a.getShooter());
				}
			}
		}
		return null;
	}
	
}
