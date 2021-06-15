package in.gokul.dto;

public class LikedSongsDto {

	private String userName;
	private String songName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public LikedSongsDto(String userName, String songName) {
		super();
		this.userName = userName;
		this.songName = songName;
	}
	@Override
	public String toString() {
		return "LikedSongsDto [userName=" + userName + ", songName=" + songName + "]";
	}
	
}
