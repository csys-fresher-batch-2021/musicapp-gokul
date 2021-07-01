package in.gokul.model;

public class Language {

	private String languageName;

	@Override
	public String toString() {
		return "Language [languageName=" + languageName + "]";
	}

	public Language(String languageName) {
	super();
	this.languageName = languageName;
}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
}
