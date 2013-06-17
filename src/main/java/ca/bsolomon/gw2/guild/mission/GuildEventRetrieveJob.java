package ca.bsolomon.gw2.guild.mission;

import java.util.Map.Entry;

import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.GJChronology;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import ca.bsolomon.gw2.guild.mission.util.GuildBountyEvent;
import ca.bsolomon.gw2.guild.mission.util.GuildChallengeEvent;
import ca.bsolomon.gw2.guild.mission.util.GuildEventData;
import ca.bsolomon.gw2.guild.mission.util.GuildPuzzleEvent;
import ca.bsolomon.gw2event.api.GW2EventsAPI;

@DisallowConcurrentExecution
public class GuildEventRetrieveJob extends DataRetrieveJob implements Job {
		
	private static final String RUSH_COURSE_TEXT = "Complete the guild rush course.";
	
	private GuildEventData guildEventData = new GuildEventData();
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		if (GW2EventsAPI.eventIdToName == null || GW2EventsAPI.eventIdToName.size() == 0) {
			GW2EventsAPI.generateEventIds();
			
			for (Entry<String, String> eventIdName:GW2EventsAPI.eventIdToName.entrySet()) {
				if (eventIdName.getValue().equals(RUSH_COURSE_TEXT)) {
					GuildEventData.rushEventIDs.add(eventIdName.getKey());
				}
			}
		}
		
		DateTimeZone zone = DateTimeZone.forID("America/New_York");
		Chronology gregorianJulian = GJChronology.getInstance(zone);
	
		for (String eventId:GuildEventData.rushEventIDs) {
			queryEvent(gregorianJulian, "1013", eventId, guildEventData);
		}
		
		for (GuildChallengeEvent event:GuildChallengeEvent.values()) {
			queryEvent(gregorianJulian, "1013", event.getUid(), guildEventData);
		}
		
		for (GuildPuzzleEvent event:GuildPuzzleEvent.values()) {
			queryEvent(gregorianJulian, "1013", event.getUid(), guildEventData);
		}
		
		for (GuildBountyEvent event:GuildBountyEvent.values()) {
			queryEvent(gregorianJulian, "1013", event.getUid(), guildEventData);
		}
		
		GuildEventData.formatRushStatus();
		GuildEventData.formatChallengeStatus();
		GuildEventData.formatPuzzleStatus();
		GuildEventData.formatBountyStatus();
	}
}