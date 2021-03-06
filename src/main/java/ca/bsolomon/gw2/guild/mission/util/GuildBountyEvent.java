package ca.bsolomon.gw2.guild.mission.util;

public enum GuildBountyEvent {

	Two_Mult("7786CC3E-659A-4816-B26F-77BBFACE9E90"),
	Ander_Wildman("9716D99B-F059-4BED-B600-B48ACAFD7449"),
	Bookworm_Bwikki("1F0AC06D-EC57-469D-9603-296DEB8CBA50"),
	Big_Mayana("33336340-CB38-4AB5-BDE7-D9198E635C82"),
	Brekkabek("E302E83C-0FBF-4A46-9397-6816E9175A24"),
	Crusader_Michiele("B9893F7F-9878-4DEB-848A-42AF00DF311A"),
	Brooke("8B235065-9ED5-4124-9065-5FD0D98EAE6E"),
	Devious_Teesa("9F620165-4572-490F-8F79-3BF2556EF177"),
	Diplomat_Tarban("500686B2-5879-4BD2-85DE-D7797DBBECA5"),
	Half_Baked_Kamali("955443CF-57B8-4436-9D62-9E28E25DBDDE"),
	Poobadoo("8E63A8B2-84D2-4BDC-BE92-929E9C3225FB"),
	Prisoner_1141("1CC93400-6704-4E1A-B3CD-E37CECEE7F71"),
	Shaman_Arderus("06F905A5-6F96-4DF4-9A3A-D36ABE59D55A"),
	Short_Fuse_Felix("3B084838-01DE-4E45-B4DA-44B4F74EA03F"),
	Sotzz_the_Scallywag("405DDE0F-621B-4651-9CF1-36382FEE5D88"),
	Tricksy_Trekksa("4699A64B-6123-4428-82FE-A8A9D2F256D5"),
	Trillia_Midwell("A66A5C55-C100-49C5-B89D-914777113BFE"),
	Yanonka("E184C08C-D87F-471B-BF27-0C33D367B30F");
	
	private String uid;
	
	GuildBountyEvent(String uid) {
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}
}