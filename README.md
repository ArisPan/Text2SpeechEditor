# Text2SpeechEditor
A notepad like apllication with Text-to-Speech functionality.\
Proper documentation will follow on simpler times, for now, this README will constitute a place for a number of refactoring ideas.

## To Do

### Refactoring
Document class has very low cohesion. Need to place it's methods in the appropriate classes.\
Same with TextToSpeechEditorView which needs some serious refactoring.

1. Use Decorator pattern in order to define Scroll, Font, Font Size etc in the main window.
2. Structure the model part as a sum of subsystems. Each Document method may constitute a different class and a series of method calls from these classes will do a certain job. Finaly build a facade in order to present a simple interface to the command/controller part.
3. Revisit the Replay command, this time following the Command pattern and maybe implement an *undo* action.

### Other
Set up the pom.xml for cross compilation with different Java versions.
