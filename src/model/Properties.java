package model;

public class Properties {

	private String author;
	private String title;
	private DateAndTime dateCreated;
	private DateAndTime dateLastSaved;
	
	public Properties(String author, String title) {
		
		this.author = author;
		this.title = title;
		
		this.dateCreated = new DateAndTime();
	}
	
	// TODO Move to Tests. Used in Document -> checkDocumentContents().
	public String getTitle() {
		
		return this.title;
	}
	
	public String getAuthor() {
		
		return this.author;
	}
	
	public String getDateCreated() {
		
		return dateCreated.getDateAndTime();
	}
	
	public String getDateLastSaved() {
		
		return dateLastSaved.getDateAndTime();
	}
	
	public void setDateLastSaved() {
		
		this.dateLastSaved = new DateAndTime();
	}
}
