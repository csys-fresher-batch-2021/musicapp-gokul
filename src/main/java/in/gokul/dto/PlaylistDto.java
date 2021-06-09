package in.gokul.dto;

import java.sql.Date;

public class PlaylistDto {
	public PlaylistDto(String playlistName, String songName, String movieName, String languageName, Date releasedOn,
			Date createdOn) {
		super();
		this.playlistName = playlistName;
		this.songName = songName;
		this.movieName = movieName;
		this.languageName = languageName;
		this.releasedOn = releasedOn;
		this.createdOn = createdOn;
	}

	public PlaylistDto(String playlistName, String userName) {
		super();
		this.playlistName = playlistName;
		this.userName = userName;
	}

	String playlistName;
	String songName;

	public String getUserName() {
		return userName;
	}

	public PlaylistDto(String playlistName) {
		super();
		this.playlistName = playlistName;
	}

	String movieName;
	String languageName;
	Date releasedOn;
	Date createdOn;
	String userName;

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

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public PlaylistDto(String playlistName, String songName, String userName) {
		super();
		this.playlistName = playlistName;
		this.songName = songName;
		this.userName = userName;
	}

	public Date getReleasedOn() {
		return releasedOn;
	}

	public void setReleasedOn(Date releasedOn) {
		this.releasedOn = releasedOn;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "PlaylistDto [playlistName=" + playlistName + ", songName=" + songName + ", movieName=" + movieName
				+ ", languageName=" + languageName + ", releasedOn=" + releasedOn + ", createdOn=" + createdOn
				+ ", userName=" + userName + "]";
	}

}
