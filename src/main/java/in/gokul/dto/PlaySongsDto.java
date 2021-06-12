package in.gokul.dto;

public class PlaySongsDto {
	
	private String songName;
	private  String songSource;
	private String imageSource;
	private byte image;
	private byte song;
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongSource() {
		return songSource;
	}
	public void setSongSource(String songSource) {
		this.songSource = songSource;
	}
	public String getImageSource() {
		return imageSource;
	}
	public PlaySongsDto(String songName, byte image, byte song) {
		super();
		this.songName = songName;
		this.image = image;
		this.song = song;
	}
	public PlaySongsDto(String songName, String songSource, String imageSource) {
		super();
		this.songName = songName;
		this.songSource = songSource;
		this.imageSource = imageSource;
	}
	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	public byte getImage() {
		return image;
	}
	public void setImage(byte image) {
		this.image = image;
	}
	public byte getSong() {
		return song;
	}
	public void setSong(byte song) {
		this.song = song;
	}
	@Override
	public String toString() {
		return "PlaySongsDto [songName=" + songName + ", songSource=" + songSource + ", imageSource=" + imageSource
				+ ", image=" + image + ", song=" + song + "]";
	}

}
