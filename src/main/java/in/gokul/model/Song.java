package in.gokul.model;

import java.sql.Date;



public class Song {
	public Song()
	{
		
	}
	
	private String songName;
	private String movieName;
	private  Date releasedOn;
	private String language;
	@Override
	public String toString() {
		return "Song [songName=" + songName + ", movieName=" + movieName + ", releasedOn=" + releasedOn + ", language="
				+ language + "]";
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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
	public Date getReleasedOn() {
		return releasedOn;
	}
	public void setReleasedOn(Date releasedOn) {
		this.releasedOn = releasedOn;
	}


	public Song(String songName, String movieName, String language) {
		super();
		this.songName = songName;
		this.movieName = movieName;
		this.language = language;
	}

	public Song(String songName, String movieName, Date releasedOn, String language) {
		super();
		this.songName = songName;
		this.movieName = movieName;
		this.releasedOn = releasedOn;
		this.language = language;
	}

	public Song(String songName) {
	super();
		this.songName = songName;
	}



	
	

}
