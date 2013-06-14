package ca.bsolomon.gw2.guild.mission.util;

public enum GuildRushMap {

	Bear_Lope("27"),
	Chicken_Run("21"),
	Crab_Scuttle("873"),
	Devourer_Burrow("32"),
	Ghost_Wolf_Run("17"),
	Quaggan_Paddle("30"),
	Spider_Scurry("26");
	
	private String mapId;
	
	GuildRushMap(String mapId) {
		this.mapId = mapId;
	}

	public String getMapId() {
		return mapId;
	}
}