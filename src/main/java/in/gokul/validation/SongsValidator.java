package in.gokul.validation;

public class SongsValidator {
	private SongsValidator()
	{
		
	}

	/**
	 * this method checks for the input string contains length greater than 4.
	 * 
	 * @param input
	 * @return
	 */
	public static boolean validlengthforSong(String input) {
		return input.length() >= 4;

	}
}
