package com.scarabcoder.gameapi.npc;

public class NPC {
	
	public NPC(Animals entity){
		this.entity = entity;
		this.allowAIMovement = false;
		this.invincible = true;
	}
	
	public Entity getEntity(){
		return this.entity;
	}
	
}
