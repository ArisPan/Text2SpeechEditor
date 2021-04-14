# Text2SpeechEditor
A notepad like application with Text-to-Speech functionality.\
Written using Java 14, Swing and [FreeTTS](https://freetts.sourceforge.io/), Text2SpeechEditor achieves the basic goals of any text editor with the addition of some proof of concept functions like Text-to-Speech conversion, text encryption and in-sequence re-execution of previous actions.
Included in this repository are a demo video and the complete Sprint Report for the final version.

## How to run
After cloning the repository in your directory of choice, invoke Maven's install goal with the command `mvn install`.\
This installs project's JAR dependencies to your local repository (usually in a *.m2/repository* directory in your home directory), compiles and packages project's code.\
To execute the JAR file created by the previous step, run `java -jar target/Text2SpeechEditor-0.0.1-SNAPSHOT.jar`.\
*Note that the project's build configuration requires Java SE 14. To change that, change the* `maven.compiler.release` *property in pom.xml*

## Screenshot
![Text2SpeechEditor - Screenshot](https://user-images.githubusercontent.com/11043114/114728717-014d9580-9d48-11eb-9d16-d4fb6839d511.png)

## To Do
This repository contains a second -*somewhat active*- branch for refactoring purposes. Following is a list of ideas for contribution or project expansion.
### Refactoring
Document class has very low cohesion. Need to place it's methods in the appropriate classes.\
Same with TextToSpeechEditorView which needs some serious refactoring.

1. Use Decorator pattern in order to define Scroll, Font, Font Size etc in the main window.
2. Structure the model part as a sum of subsystems. Each Document method may constitute a different class and a series of method calls from these classes will do a certain job. Finaly build a facade in order to present a simple interface to the command/controller part.
3. Revisit the Replay command, this time following the Command pattern and maybe implement an *undo* action.

### Other
Set up the pom.xml for cross compilation with different Java versions.
