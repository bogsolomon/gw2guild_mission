package ca.bsolomon.gw2.guild.mission;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Ajax;
import org.primefaces.component.datatable.DataTable;

import ca.bsolomon.gw2.guild.mission.util.GuildBountyEvent;
import ca.bsolomon.gw2.guild.mission.util.GuildChallengeEvent;
import ca.bsolomon.gw2.guild.mission.util.GuildEventData;
import ca.bsolomon.gw2.guild.mission.util.GuildPuzzleEvent;
import ca.bsolomon.gw2.guild.mission.util.GuildRushMap;

@ManagedBean(name="ajaxPollBean")
@SessionScoped
public class AjaxPollBean {
	
	private ConcurrentMap<String, String> eventMap = new ConcurrentHashMap<>(70, 0.9f, 1);
	
	public void updateEvents(DataTable rushTable, DataTable chalTable, DataTable puzzleTable, DataTable bountyTable) {
		checkStatusRush(rushTable, GuildEventData.getRushStatus());
		checkStatusChallenge(chalTable, GuildEventData.getChallengeStatus());
		checkStatusPuzzle(puzzleTable, GuildEventData.getPuzzleStatus());
		checkStatusBounty(bountyTable, GuildEventData.getBountyStatus());
	}
	
	private void checkStatusBounty(DataTable bountyTable,
			Map<GuildBountyEvent, String> bountyStatus) {
		boolean toUpdate = false;
		
		for (GuildBountyEvent bounty:GuildBountyEvent.values()) {
			String keyName = "bounty-"+bounty.getUid();
			
			String status = bountyStatus.get(bounty);
			
			toUpdate = checkEventStatus(toUpdate, keyName, status);
		}
		
		if (toUpdate) {
			Ajax.update(bountyTable.getClientId());
		}
	}

	private void checkStatusPuzzle(DataTable servTable,
			Map<GuildPuzzleEvent, String> puzzleStatus) {
		boolean toUpdate = false;
		
		for (GuildPuzzleEvent puzzle:GuildPuzzleEvent.values()) {
			String keyName = "puzzle-"+puzzle.getUid();
			
			String status = puzzleStatus.get(puzzle);
			
			toUpdate = checkEventStatus(toUpdate, keyName, status);
		}
		
		if (toUpdate) {
			Ajax.update(servTable.getClientId());
		}
	}

	private boolean checkEventStatus(boolean toUpdate, String keyName,
			String status) {
		if (eventMap.containsKey(keyName)) {
			String oldStatus = eventMap.get(keyName);
			if ((oldStatus.startsWith("Active") && !status.startsWith("Active")) ||
					(!oldStatus.startsWith("Active") && status.startsWith("Active"))) {
				eventMap.put(keyName, status);
				toUpdate = true;
			}
		} else {
			eventMap.put(keyName, status);
			toUpdate = true;
		}
		return toUpdate;
	}

	private void checkStatusChallenge(DataTable servTable,
			Map<GuildChallengeEvent, String> challengeStatus) {
		boolean toUpdate = false;
		
		for (GuildChallengeEvent challenge:GuildChallengeEvent.values()) {
			String keyName = "challenge-"+challenge.getUid();
			
			String status = challengeStatus.get(challenge);
			
			toUpdate = checkEventStatus(toUpdate, keyName, status);
		}
		
		if (toUpdate) {
			Ajax.update(servTable.getClientId());
		}
	}

	private void checkStatusRush(DataTable servTable,
			Map<GuildRushMap, String> rushStatus) {
		boolean toUpdate = false;
		
		for (GuildRushMap map:GuildRushMap.values()) {
			String keyName = "rush-"+map.getMapId();
			
			String status = rushStatus.get(map);
			
			toUpdate = checkEventStatus(toUpdate, keyName, status);
		}
		
		if (toUpdate) {
			Ajax.update(servTable.getClientId());
		}
	}
}