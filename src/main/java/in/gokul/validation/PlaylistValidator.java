package in.gokul.validation;

import java.util.regex.Pattern;

public class PlaylistValidator {
	private PlaylistValidator()
	{
		
	}
	/**
	 * this method checks for valid playlist name 
	 * @param playlistName
	 * @return
	 */
	public static boolean isValidPlaylistName( String playlistName)
	{
		return (Validator.stringValidator(playlistName)&&isValidPlaylistNamePattern(playlistName));
		
	}
	
   /**
    * this method checks for name contains only alphabets and numbers
    * @param playlistName
    * @return
    */
	public static boolean isValidPlaylistNamePattern(String playlistName)
	{
		
		return Pattern.matches("[a-zA-Z0-9]{4,20}",playlistName);
		
	}
	

}
