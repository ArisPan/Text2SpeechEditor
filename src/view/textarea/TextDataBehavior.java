package view.textarea;

public interface TextDataBehavior {
	
	// TextDataBehavior is the interface the defines
	// the behavior of data input and output to and from TextArea classes.
	
	public void setText(String text);
	
	public String getText();
	
	public String getSelection();
	
	public int getCurrentLineIndex();
}
