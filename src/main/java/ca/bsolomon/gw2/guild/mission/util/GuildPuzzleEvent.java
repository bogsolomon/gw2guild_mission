package ca.bsolomon.gw2.guild.mission.util;

public enum GuildPuzzleEvent {

	Proxemics_Lab("4015D42F-72D7-425B-B693-E0E16466292D"),
	Langmars_Estaten("9172E4AF-CD88-418B-82DA-94CFB1698A8F"),
	Angvars_Trove("73DCCC29-4A1A-4E4B-9C9F-562A7D238BDF");
	
	private String uid;
	
	GuildPuzzleEvent(String uid) {
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}
}