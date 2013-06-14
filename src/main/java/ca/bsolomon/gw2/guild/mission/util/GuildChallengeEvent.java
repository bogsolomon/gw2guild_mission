package ca.bsolomon.gw2.guild.mission.util;

public enum GuildChallengeEvent {

	Blightwater_Shatterstrike("6023ED84-0B9C-408D-AF2E-C01E83AEC613"),
	Branded_for_Termination("96B14EC6-0410-4E94-97C3-8D279987E7B0"),
	Deep_Trouble("9C474C83-2A49-41FD-98DD-49A15DAE3D29"),
	Save_Our_Supplies("08AA1661-A3FE-4B48-8355-882519115612"),
	Scratch_Sentry_Defense("E8355DDD-2A98-4493-90A2-A154966E5AA4"),
	Southsun_Crab_Toss("7C37907C-61D2-460C-B47F-A699C8A7980D");
	
	private String uid;
	
	GuildChallengeEvent(String uid) {
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}
}
