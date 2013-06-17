package ca.bsolomon.gw2.guild.mission;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ca.bsolomon.gw2.guild.mission.util.GuildBountyEvent;
import ca.bsolomon.gw2.guild.mission.util.GuildChallengeEvent;
import ca.bsolomon.gw2.guild.mission.util.GuildEventData;
import ca.bsolomon.gw2.guild.mission.util.GuildPuzzleEvent;
import ca.bsolomon.gw2.guild.mission.util.GuildRushMap;
import ca.bsolomon.gw2.guild.mission.util.Location;
import ca.bsolomon.gw2.guild.mission.util.Mission;

@ManagedBean(name="guildMissionBean")
@ViewScoped
public class GuildMissionBean implements Serializable {

	private static final String DULFY_RUSH = "http://dulfy.net/2013/03/17/gw2-guild-rush-guild-mission-guide/";
	private static final String DULFY_CHALLENGE = "http://dulfy.net/2013/04/20/gw2-guild-challenge-guild-mission-guide/";
	private static final String DULFY_PUZZLE = "http://dulfy.net/2013/04/28/gw2-guild-puzzles-guild-mission-guide/";
	private static final String DULFY_BOUNTY = "http://dulfy.net/2013/02/27/gw2-guild-bounty-guide/";

	/**
	 * 
	 */
	private static final long serialVersionUID = 7969289783769255184L;
	
	private List<Mission> missions = new ArrayList<>();

	public GuildMissionBean() {
		generateRushLocations();
		generateChallengeLocations();
		generatePuzzleLocations();
		generateBountyLocations();
	}

	private void generateRushLocations() {
		Mission mission = new Mission();
		mission.setType("Rush");
		
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("Bear Lope", "Lornar's Pass", "[&BOkAAAA=]", DULFY_RUSH+"#2", GuildEventData.getRushStatus().get(GuildRushMap.Bear_Lope)));
		locations.add(new Location("Chicken Run", "Fields of Ruin", "[&BEwBAAA=]", DULFY_RUSH+"#3", GuildEventData.getRushStatus().get(GuildRushMap.Chicken_Run)));
		locations.add(new Location("Crab Scuttle", "Southsun Cove", "[&BNwGAAA=]", DULFY_RUSH+"#4", GuildEventData.getRushStatus().get(GuildRushMap.Crab_Scuttle)));
		locations.add(new Location("Devourer Burrow", "Diessa Plateau", "[&BMkDAAA=]", DULFY_RUSH+"#5", GuildEventData.getRushStatus().get(GuildRushMap.Devourer_Burrow)));
		locations.add(new Location("Ghost Wolf Run", "Harathi Hinterlands", "[&BKUAAAA=]", DULFY_RUSH+"#6", GuildEventData.getRushStatus().get(GuildRushMap.Ghost_Wolf_Run)));
		locations.add(new Location("Quaggan Paddle", "Frostgorge Sound", "[&BIACAAA=]", DULFY_RUSH+"#6b", GuildEventData.getRushStatus().get(GuildRushMap.Quaggan_Paddle)));
		locations.add(new Location("Spider Scurry", "Dredgehaunt Cliffs", "[&BF0CAAA=]", DULFY_RUSH+"#7", GuildEventData.getRushStatus().get(GuildRushMap.Spider_Scurry)));
		
		mission.setLocations(locations);
		missions.add(mission);
	}
	
	private void generateChallengeLocations() {
		Mission mission = new Mission();
		mission.setType("Challenge");
		
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("Blightwater Shatterstrike", "Blazeridge Steppes", "[&BPsBAAA=]", DULFY_CHALLENGE+"#2", GuildEventData.getChallengeStatus().get(GuildChallengeEvent.Blightwater_Shatterstrike)));
		locations.add(new Location("Branded for Termination", "Fields of Ruin", "[&BEsBAAA=]", DULFY_CHALLENGE+"#3", GuildEventData.getChallengeStatus().get(GuildChallengeEvent.Branded_for_Termination)));
		locations.add(new Location("Deep Trouble", "Mount Maelstrom", "[&BNICAAA=]", DULFY_CHALLENGE+"#4", GuildEventData.getChallengeStatus().get(GuildChallengeEvent.Deep_Trouble)));
		locations.add(new Location("Save Our Supplies", "Iron Marches", "[&BOoBAAA=]", DULFY_CHALLENGE+"#5", GuildEventData.getChallengeStatus().get(GuildChallengeEvent.Save_Our_Supplies)));
		locations.add(new Location("Scratch Sentry Defense", "Timberline Falls", "[&BEYEAAA=]", DULFY_CHALLENGE+"#6", GuildEventData.getChallengeStatus().get(GuildChallengeEvent.Scratch_Sentry_Defense)));
		locations.add(new Location("Southsun Crab Toss", "Southsun Cove", "[&BNwGAAA=]", DULFY_CHALLENGE+"#7", GuildEventData.getChallengeStatus().get(GuildChallengeEvent.Southsun_Crab_Toss)));
		
		mission.setLocations(locations);
		missions.add(mission);
	}

	private void generatePuzzleLocations() {
		Mission mission = new Mission();
		mission.setType("Puzzle");
		
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("Angvar's Trove", "Snowden Drifts", "[&BP8GAAA=]", DULFY_PUZZLE+"#1b", GuildEventData.getPuzzleStatus().get(GuildPuzzleEvent.Angvars_Trove)));
		locations.add(new Location("Langmar Estate", "Plains of Ashford", "[&BPgGAAA=]", DULFY_PUZZLE+"#3", GuildEventData.getPuzzleStatus().get(GuildPuzzleEvent.Langmars_Estaten)));
		locations.add(new Location("Proxemics Lab", "Brisban Wildlands", "[&BPkGAAA=]", DULFY_PUZZLE+"#2", GuildEventData.getPuzzleStatus().get(GuildPuzzleEvent.Proxemics_Lab)));
		
		mission.setLocations(locations);
		missions.add(mission);
	}
	
	public List<Mission> getMissions() {
		missions = new ArrayList<>();
		
		generateRushLocations();
		generateChallengeLocations();
		generatePuzzleLocations();
		
		generateBountyLocations();
		
		return missions;
	}

	private void generateBountyLocations() {
		Mission mission = new Mission();
		mission.setType("Bounty");
		
		List<Location> locations = new ArrayList<>();
		locations.add(new Location("2-Mult", "Timberline Falls", "", DULFY_BOUNTY+"#0", GuildEventData.getBountyStatus().get(GuildBountyEvent.Two_Mult)));
		locations.add(new Location("Ander \"Wildman\" Westward", "Southsun Cove", "", DULFY_BOUNTY+"#1", GuildEventData.getBountyStatus().get(GuildBountyEvent.Ander_Wildman)));
		locations.add(new Location("Big Mayana", " 	Sparkfly Fen", "", DULFY_BOUNTY+"#1b", GuildEventData.getBountyStatus().get(GuildBountyEvent.Big_Mayana)));
		locations.add(new Location("Bookworm Bwikki", "Lornar’s Pass", "", DULFY_BOUNTY+"#2", GuildEventData.getBountyStatus().get(GuildBountyEvent.Bookworm_Bwikki)));
		locations.add(new Location("Brekkabek", "Harathi Hinterlands", "", DULFY_BOUNTY+"#3", GuildEventData.getBountyStatus().get(GuildBountyEvent.Brekkabek)));
		locations.add(new Location("Crusader Michiele", "Sparkfly Fens", "", DULFY_BOUNTY+"#4", GuildEventData.getBountyStatus().get(GuildBountyEvent.Crusader_Michiele)));
		locations.add(new Location("Deputy Brooke", "Snowden Drifts", "", DULFY_BOUNTY+"#5", GuildEventData.getBountyStatus().get(GuildBountyEvent.Brooke)));
		locations.add(new Location("Devious Teesa", "Frostgorge Sound", "", DULFY_BOUNTY+"#6", GuildEventData.getBountyStatus().get(GuildBountyEvent.Devious_Teesa)));
		locations.add(new Location("Diplomat Tarban", "Brisban Wildlands", "", DULFY_BOUNTY+"#7", GuildEventData.getBountyStatus().get(GuildBountyEvent.Diplomat_Tarban)));
		locations.add(new Location("Half Baked Kamali", "Mount Maelstrom", "", DULFY_BOUNTY+"#8", GuildEventData.getBountyStatus().get(GuildBountyEvent.Half_Baked_Kamali)));
		locations.add(new Location("Poobadoo", "Kessex Hills", "", DULFY_BOUNTY+"#9", GuildEventData.getBountyStatus().get(GuildBountyEvent.Poobadoo)));
		locations.add(new Location("Prisoner 1411", "Iron Marshes", "", DULFY_BOUNTY+"#10", GuildEventData.getBountyStatus().get(GuildBountyEvent.Prisoner_1141)));
		locations.add(new Location("Shaman Arderus", "Fireheart Rise", "", DULFY_BOUNTY+"#11", GuildEventData.getBountyStatus().get(GuildBountyEvent.Shaman_Arderus)));
		locations.add(new Location("Short-Fuse Felix", "Diessa Plateau", "", DULFY_BOUNTY+"#12", GuildEventData.getBountyStatus().get(GuildBountyEvent.Short_Fuse_Felix)));
		locations.add(new Location("Sotzz the Scallywag", "Gendarran Fields", "", DULFY_BOUNTY+"#13", GuildEventData.getBountyStatus().get(GuildBountyEvent.Sotzz_the_Scallywag)));
		locations.add(new Location("Tricksy Trekksa", "Blazeridge Steppes", "", DULFY_BOUNTY+"#14", GuildEventData.getBountyStatus().get(GuildBountyEvent.Tricksy_Trekksa)));
		locations.add(new Location("Trillia Midwell", "Fields of Ruin", "", DULFY_BOUNTY+"#15", GuildEventData.getBountyStatus().get(GuildBountyEvent.Trillia_Midwell)));
		locations.add(new Location("Yanonka the Rat-Wrangler", "Fields of Ruin", "", DULFY_BOUNTY+"#16", GuildEventData.getBountyStatus().get(GuildBountyEvent.Yanonka)));
		
		mission.setLocations(locations);
		missions.add(mission);
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}	
}
