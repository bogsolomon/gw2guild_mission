package ca.bsolomon.gw2.guild.mission.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.joda.time.DateTime;
import org.joda.time.Period;

public class GuildEventData implements EventData{

	private static final String ACTIVE = "Active";
	private static ConcurrentMap<String, String> eventStatus = new ConcurrentHashMap<String, String>(16, 0.9f, 1);
	private static ConcurrentMap<String, DateTime> eventTime = new ConcurrentHashMap<String, DateTime>(16, 0.9f, 1);
	public static List<String> rushEventIDs = new ArrayList<>();
	
	private static Map<GuildRushMap, String> rushStatus = new ConcurrentHashMap<>(16, 0.9f, 1);
	private static Map<GuildRushMap, String> rushStatus2 = new ConcurrentHashMap<>(16, 0.9f, 1);
	
	private static int rushIndex = 1;
	
	private static Map<GuildPuzzleEvent, String> puzzleStatus = new ConcurrentHashMap<>(16, 0.9f, 1);
	private static Map<GuildChallengeEvent, String> challengeStatus = new ConcurrentHashMap<>(16, 0.9f, 1);
	
	private static Map<String, String> eventIdToMapId = new HashMap<>();
	
	public static Map<GuildRushMap, String> getRushStatus() {
		if (rushIndex == 1)
			return rushStatus;
		else
			return rushStatus2;
	}
	
	public static Map<GuildChallengeEvent, String> getChallengeStatus() {
		return challengeStatus;
	}
	
	public static Map<GuildPuzzleEvent, String> getPuzzleStatus() {
		return puzzleStatus;
	}
	
	@Override
	public boolean addEventStatus(String serverId, String eventId, String status, DateTime time, String mapId) {
		String composedId = eventId;
		
		if (eventStatus.containsKey(composedId)) {
			if (!eventStatus.get(composedId).equals(status)) {
				eventStatus.put(composedId, status);
				eventTime.put(composedId, time);
				
				return true;
			}
		} else {
			eventStatus.put(composedId, status);
			eventTime.put(composedId, time);
			eventIdToMapId.put(composedId, mapId);
			
			return true;
		}
		
		return false;
	}

	@Override
	public String getEventStatus(String eventId) {
		return eventStatus.get(eventId);
	}
	@Override
	public DateTime getEventTime(String eventId) {
		return eventTime.get(eventId);
	}

	public static void formatRushStatus() {
		DateTime now = new DateTime(gregorianJuian);
		
		if (rushIndex == 1)
			rushStatus2.clear();
		else
			rushStatus.clear();
		
		for (String rushEventID:rushEventIDs) {
			checkEvent(now, rushEventID, GuildRushMap.Bear_Lope);
			checkEvent(now, rushEventID, GuildRushMap.Chicken_Run);
			checkEvent(now, rushEventID, GuildRushMap.Crab_Scuttle);
			checkEvent(now, rushEventID, GuildRushMap.Devourer_Burrow);
			checkEvent(now, rushEventID, GuildRushMap.Ghost_Wolf_Run);
			checkEvent(now, rushEventID, GuildRushMap.Quaggan_Paddle);
			checkEvent(now, rushEventID, GuildRushMap.Spider_Scurry);
		}
		
		for (GuildRushMap map:GuildRushMap.values()) {
			if (rushIndex == 1) {
				if (!rushStatus2.containsKey(map)) { 	
					rushStatus2.put(map, "Not Active");
				}
			} else {
				if (!rushStatus.containsKey(map)) { 	
					rushStatus.put(map, "Not Active");
				}
			}
		}
		
		if (rushIndex == 1) {
			rushIndex = 2;
		} else {
			rushIndex = 1;
		}
	}

	private static void checkEvent(DateTime now, String rushEventID, GuildRushMap map) {
		if (eventIdToMapId.get(rushEventID).equals(map.getMapId())
				&& eventStatus.get(rushEventID).equals(ACTIVE)) {
			DateTime time = eventTime.get(rushEventID);
			
			Period period = new Period(time, now);
			
			String periodStr = MMSSFormater.print(period);
			
			if (rushIndex == 1)
				rushStatus2.put(map, "Active: "+periodStr);
			else
				rushStatus.put(map, "Active: "+periodStr);
		}
	}

	public static void formatChallengeStatus() {
		DateTime now = new DateTime(gregorianJuian);
		
		for (GuildChallengeEvent event:GuildChallengeEvent.values()) {
			if (eventStatus.get(event.getUid()).equals(ACTIVE)) {
				DateTime time = eventTime.get(event.getUid());
				
				Period period = new Period(time, now);
				
				String periodStr = MMSSFormater.print(period);
				
				challengeStatus.put(event, "Active: "+ periodStr);
			} else {
				challengeStatus.put(event, "Not Active");
			}
		}
	}

	public static void formatPuzzleStatus() {
		DateTime now = new DateTime(gregorianJuian);
		
		for (GuildPuzzleEvent event:GuildPuzzleEvent.values()) {
			if (eventStatus.get(event.getUid()).equals(ACTIVE)) {
				DateTime time = eventTime.get(event.getUid());
				
				Period period = new Period(time, now);
				
				String periodStr = MMSSFormater.print(period);
				
				puzzleStatus.put(event, "Active: "+ periodStr);
			} else {
				puzzleStatus.put(event, "Not Active");
			}
		}
	}
}
