package com.scarabcoder.gameapi.game;

public class ArenaSettings {
	
	private boolean canBuild;
	private boolean canDestroy;
	private boolean canPvP;
	private boolean allowMobDamage;
	private boolean allowItemFrameDamage;
	private boolean allowPaintingDamage;
	private boolean allowExpDrop;
	private boolean allowItemDrop;
	private boolean allowMobSpawn;
	private boolean allowCreeperExplosion;
	private boolean allowOtherExplosion;
	private boolean allowEndermanGrief;
	private boolean allowEnderpearl;
	private boolean allowEnderDragonDestroy;
	private boolean allowGhastFireballExplosion;
	private boolean allowPlayerSleep;
	private boolean allowTNTExplosion;
	private boolean allowFlintAndSteel;
	private boolean allowFireSpread;
	private boolean allowLavaFire;
	private boolean allowLightning;
	private boolean allowChestAccess;
	private boolean allowPistons;
	private boolean allowWaterFlow;
	private boolean allowLavaFlow;
	private boolean allowPlayerInteract;
	private boolean allowVehiclePlacement;
	private boolean allowVehicleDestroy;
	private boolean allowSnowCollection;
	private boolean allowSnowMelt;
	private boolean allowIceForm;
	private boolean allowMushroomGrowth;
	private boolean allowLeafDecay;
	private boolean allowGrassGrowth;
	private boolean allowMyceliumSpread;
	private boolean allowVineGrowth;
	private boolean allowPlayerInvincibility;
	private boolean allowFoodLevelChange;
	private boolean keepInventory;
	private boolean allowDurabilityChange;
	private boolean allowBlockDrop;
	private boolean allowTimeChange;
	private boolean allowWeatherChange;
	private boolean allowInventoryChange;
	private boolean allowChat;
	
	private int priority;

	/**
	 * ArenaSettings can be used for blocking certain events easier, without having to listen for each one.
	 * For example, most minigames don't allow block breaking. Instead of cancelling an event, you can use:
	 * ArenaSettings.setCanBuild(false).
	 * Also sets a default priority of 0 for Areas or -1 for Arenas (see ArenaSettings.getPriority() for more on how this works).
	 */
	public ArenaSettings(){
		this.loadDefaults();
		
	}
	
	/**
	 * ArenaSettings can be used for blocking certain events easier, without having to listen for each one.
	 * For example, most minigames don't allow block breaking. Instead of cancelling an event, you can use:
	 * ArenaSettings.setCanBuild(false).
	 * @param priority Priority to be set.
	 */
	public ArenaSettings(int priority){
		this.priority = 0;
		this.loadDefaults();
	}
	
	/**
	 * Get the priority these settings take. Higher number = higher priority.
	 * Default: 0 for Areas, -1 for Arenas.
	 * @return This ArenaSettings' priority.
	 */
	public int getPriority(){
		return this.priority;
	}
	
	/**
	 * Set the priority these settings take. Higher number = higher priority
	 * Default: 0 for Areas, -1 for Arenas.
	 * @param priority The ArenaSettings' priority to be set.
	 */
	public void setPriority(int priority){
		this.priority = priority;
	}
	
	
	/**
	 * Resets all settings to their default, except priority level.
	 */
	public void loadDefaults(){
		this.allowChestAccess = true;
		this.allowCreeperExplosion = true;
		this.allowEnderDragonDestroy = true;
		this.allowEndermanGrief = true;
		this.allowEnderpearl = true;
		this.allowExpDrop = true;
		this.allowFireSpread = true;
		this.allowFlintAndSteel = true;
		this.allowGhastFireballExplosion = true;
		this.allowGrassGrowth = true;
		this.allowIceForm = true;
		this.allowItemDrop = true;
		this.allowItemFrameDamage = true;
		this.allowLavaFire = true;
		this.allowLavaFlow = true;
		this.allowLeafDecay = true;
		this.allowLightning = true;
		this.allowMobDamage = true;
		this.allowMobSpawn = true;
		this.allowMushroomGrowth = true;
		this.allowMyceliumSpread = true;
		this.allowOtherExplosion = true;
		this.allowPaintingDamage = true;
		this.allowPistons = true;
		this.allowPlayerInteract = true;
		this.allowPlayerInvincibility = false;
		this.allowPlayerSleep = true;
		this.allowSnowCollection = true;
		this.allowSnowMelt = true;
		this.allowTNTExplosion = true;
		this.allowVehicleDestroy = true;
		this.allowVehiclePlacement = true;
		this.allowVineGrowth = true;
		this.allowWaterFlow = true;
		this.canBuild = true;
		this.canDestroy = true;
		this.canPvP = true;
		this.allowFoodLevelChange = true;
		this.keepInventory = false;
		this.allowDurabilityChange = true;
		this.allowBlockDrop = true;
		this.allowTimeChange = true;
		this.allowWeatherChange = true;
		this.setAllowInventoryChange(true);
		this.allowChat = true;
	}
	
	
	public boolean allowChat(){
		return this.allowChat;
	}
	
	public void allowChat(boolean allow){
		this.allowChat = allow;
	}
	
	public boolean getAllowBlockDrop(){
		return this.allowBlockDrop;
	}
	
	public void setAllowBlockDrop(boolean allow){
		this.allowBlockDrop = allow;
	}

	public boolean isCanBuild() {
		return canBuild;
	}

	public void setCanBuild(boolean canBuild) {
		this.canBuild = canBuild;
	}

	public boolean isCanDestroy() {
		return canDestroy;
	}

	public void setCanDestroy(boolean canDestroy) {
		this.canDestroy = canDestroy;
	}

	public boolean isCanPvP() {
		return canPvP;
	}

	public void setCanPvP(boolean canPvP) {
		this.canPvP = canPvP;
	}

	public boolean canMobDamage() {
		return allowMobDamage;
	}

	public void setAllowMobDamage(boolean allowMobDamage) {
		this.allowMobDamage = allowMobDamage;
	}

	public boolean canItemFrameDamage() {
		return allowItemFrameDamage;
	}

	public void setAllowItemFrameDamage(boolean allowItemFrameDamage) {
		this.allowItemFrameDamage = allowItemFrameDamage;
	}

	public boolean canPaintingDamage() {
		return allowPaintingDamage;
	}

	public void setAllowPaintingDamage(boolean allowPaintingDamage) {
		this.allowPaintingDamage = allowPaintingDamage;
	}

	public boolean canExpDrop() {
		return allowExpDrop;
	}

	public void setAllowExpDrop(boolean allowExpDrop) {
		this.allowExpDrop = allowExpDrop;
	}

	public boolean canItemDrop() {
		return allowItemDrop;
	}

	public void setAllowItemDrop(boolean allowItemDrop) {
		this.allowItemDrop = allowItemDrop;
	}

	public boolean canMobSpawn() {
		return allowMobSpawn;
	}

	public void setAllowMobSpawn(boolean allowMobSpawn) {
		this.allowMobSpawn = allowMobSpawn;
	}

	public boolean canCreeperExplosion() {
		return allowCreeperExplosion;
	}

	public void setAllowCreeperExplosion(boolean allowCreeperExplosion) {
		this.allowCreeperExplosion = allowCreeperExplosion;
	}

	public boolean canOtherExplosion() {
		return allowOtherExplosion;
	}

	public void setAllowOtherExplosion(boolean allowOtherExplosion) {
		this.allowOtherExplosion = allowOtherExplosion;
	}

	public boolean canEndermanGrief() {
		return allowEndermanGrief;
	}

	public void setAllowEndermanGrief(boolean allowEndermanGrief) {
		this.allowEndermanGrief = allowEndermanGrief;
	}

	public boolean canEnderpearl() {
		return allowEnderpearl;
	}

	public void setAllowEnderpearl(boolean allowEndepearl) {
		this.allowEnderpearl = allowEndepearl;
	}

	public boolean canEnderDragonDestroy() {
		return allowEnderDragonDestroy;
	}

	public void setAllowEnderDragonDestroy(boolean allowEnderDragonDestroy) {
		this.allowEnderDragonDestroy = allowEnderDragonDestroy;
	}

	public boolean canGhastFireballExplosion() {
		return allowGhastFireballExplosion;
	}

	public void setAllowGhastFireballExplosion(boolean allowGhastFireballExplosion) {
		this.allowGhastFireballExplosion = allowGhastFireballExplosion;
	}

	public boolean canPlayerSleep() {
		return allowPlayerSleep;
	}

	public void setAllowPlayerSleep(boolean allowPlayerSleep) {
		this.allowPlayerSleep = allowPlayerSleep;
	}

	public boolean canTNTExplosion() {
		return allowTNTExplosion;
	}

	public void setAllowTNTExplosion(boolean allowTNTExplosion) {
		this.allowTNTExplosion = allowTNTExplosion;
	}

	public boolean canFlintAndSteel() {
		return allowFlintAndSteel;
	}

	public void setAllowFlintAndSteel(boolean allowFlintAndSteel) {
		this.allowFlintAndSteel = allowFlintAndSteel;
	}

	public boolean canFireSpread() {
		return allowFireSpread;
	}

	public void setAllowFireSpread(boolean allowFireSpread) {
		this.allowFireSpread = allowFireSpread;
	}

	public boolean canLavaFire() {
		return allowLavaFire;
	}

	public void setAllowLavaFire(boolean allowLavaFire) {
		this.allowLavaFire = allowLavaFire;
	}

	public boolean canLightning() {
		return allowLightning;
	}

	public void setAllowLightning(boolean allowLightning) {
		this.allowLightning = allowLightning;
	}

	public boolean canChestAccess() {
		return allowChestAccess;
	}

	public void setAllowChestAccess(boolean allowChestAccess) {
		this.allowChestAccess = allowChestAccess;
	}

	public boolean canPistons() {
		return allowPistons;
	}

	public void setAllowPistons(boolean allowPistons) {
		this.allowPistons = allowPistons;
	}

	public boolean canWaterFlow() {
		return allowWaterFlow;
	}

	public void setAllowWaterFlow(boolean allowWaterFlow) {
		this.allowWaterFlow = allowWaterFlow;
	}

	public boolean canLavaFlow() {
		return allowLavaFlow;
	}

	public void setAllowLavaFlow(boolean allowLavaFlow) {
		this.allowLavaFlow = allowLavaFlow;
	}

	public boolean canPlayerInteract() {
		return allowPlayerInteract;
	}

	public void setAllowPlayerInteract(boolean allowPlayerInteract) {
		this.allowPlayerInteract = allowPlayerInteract;
	}

	public boolean canVehiclePlacement() {
		return allowVehiclePlacement;
	}

	public void setAllowVehiclePlacement(boolean allowVehiclePlacement) {
		this.allowVehiclePlacement = allowVehiclePlacement;
	}

	public boolean canVehicleDestroy() {
		return allowVehicleDestroy;
	}

	public void setAllowVehicleDestroy(boolean allowVehicleDestroy) {
		this.allowVehicleDestroy = allowVehicleDestroy;
	}

	public boolean canSnowCollection() {
		return allowSnowCollection;
	}

	public void setAllowSnowCollection(boolean allowSnowCollection) {
		this.allowSnowCollection = allowSnowCollection;
	}

	public boolean canSnowMelt() {
		return allowSnowMelt;
	}

	public void setAllowSnowMelt(boolean allowSnowMelt) {
		this.allowSnowMelt = allowSnowMelt;
	}

	public boolean canIceForm() {
		return allowIceForm;
	}

	public void setAllowIceForm(boolean allowIceForm) {
		this.allowIceForm = allowIceForm;
	}

	public boolean canMushroomGrowth() {
		return allowMushroomGrowth;
	}

	public void setAllowMushroomGrowth(boolean allowMushroomGrowth) {
		this.allowMushroomGrowth = allowMushroomGrowth;
	}

	public boolean canLeafDecay() {
		return allowLeafDecay;
	}

	public void setAllowLeafDecay(boolean allowLeafDecay) {
		this.allowLeafDecay = allowLeafDecay;
	}

	public boolean canGrassGrowth() {
		return allowGrassGrowth;
	}

	public void setAllowGrassGrowth(boolean allowGrassGrowth) {
		this.allowGrassGrowth = allowGrassGrowth;
	}

	public boolean canMyceliumSpread() {
		return allowMyceliumSpread;
	}

	public void setAllowMyceliumSpread(boolean allowMyceliumSpread) {
		this.allowMyceliumSpread = allowMyceliumSpread;
	}

	public boolean canVineGrowth() {
		return allowVineGrowth;
	}

	public void setAllowVineGrowth(boolean allowVineGrowth) {
		this.allowVineGrowth = allowVineGrowth;
	}

	public boolean canPlayerInvincibility() {
		return allowPlayerInvincibility;
	}

	public void setAllowPlayerInvincibility(boolean allowPlayerInvincibility) {
		this.allowPlayerInvincibility = allowPlayerInvincibility;
	}

	public boolean isAllowFoodLevelChange() {
		return allowFoodLevelChange;
	}

	public void setAllowFoodLevelChange(boolean allowFoodLevelChange) {
		this.allowFoodLevelChange = allowFoodLevelChange;
	}

	public boolean isKeepInventory() {
		return keepInventory;
	}

	public void setKeepInventory(boolean keepInventory) {
		this.keepInventory = keepInventory;
	}

	public boolean isAllowDurabilityChange() {
		return allowDurabilityChange;
	}

	public void setAllowDurabilityChange(boolean allowDurabilityChange) {
		this.allowDurabilityChange = allowDurabilityChange;
	}

	public boolean isAllowTimeChange() {
		return allowTimeChange;
	}

	public void setAllowTimeChange(boolean allowTimeChange) {
		this.allowTimeChange = allowTimeChange;
	}

	public boolean isAllowWeatherChange() {
		return allowWeatherChange;
	}

	public void setAllowWeatherChange(boolean allowWeatherChange) {
		this.allowWeatherChange = allowWeatherChange;
	}

	public boolean isAllowInventoryChange() {
		return allowInventoryChange;
	}

	public void setAllowInventoryChange(boolean allowInventoryChange) {
		this.allowInventoryChange = allowInventoryChange;
	}
	
}
