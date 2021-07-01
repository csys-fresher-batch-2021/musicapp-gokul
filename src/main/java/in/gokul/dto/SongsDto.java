package in.gokul.dto;

import java.io.File;
import java.io.InputStream;

public class SongsDto {
	private String songName;
	private InputStream songStream;
	private InputStream imageStream;
	private File songFile;
	private File imageFile;

	public SongsDto(String songName, InputStream songStream, InputStream imageStream, File songFile, File imageFile) {
		super();
		this.songName = songName;
		this.songStream = songStream;
		this.imageStream = imageStream;
		this.songFile = songFile;
		this.imageFile = imageFile;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public InputStream getSongStream() {
		return songStream;
	}

	public void setSongStream(InputStream songStream) {
		this.songStream = songStream;
	}

	public InputStream getImageStream() {
		return imageStream;
	}

	public void setImageStream(InputStream imageStream) {
		this.imageStream = imageStream;
	}

	public File getSongFile() {
		return songFile;
	}

	public void setSongFile(File songFile) {
		this.songFile = songFile;
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	@Override
	public String toString() {
		return "SongsDto [songName=" + songName + ", songStream=" + songStream + ", imageStream=" + imageStream
				+ ", songFile=" + songFile + ", imageFile=" + imageFile + "]";
	}

}
