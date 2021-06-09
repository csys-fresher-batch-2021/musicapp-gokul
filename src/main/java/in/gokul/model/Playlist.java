package in.gokul.model;

import java.sql.Date;

public class Playlist {

	private String playlistName;
	private String songName;
	private Date createdOn;
	private String userName;
	public Playlist(String playlistName, String songName, String userName) {
		super();
		this.playlistName = playlistName;
		this.songName = songName;
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Playlist [playlistName=" + playlistName + ", songName=" + songName + ", createdOn=" + createdOn
				+ ", userName=" + userName + "]";
	}
	public Playlist(String playlistName, String songName, Date createdOn) {
		super();
		this.playlistName = playlistName;
		this.songName = songName;
		this.createdOn = createdOn;
	}
	public Playlist(String playlistName, String songName) {
		super();
		this.playlistName = playlistName;
		this.songName = songName;
	}
	public String getPlaylistName() {
		return playlistName;
	}
	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	

	
}
