package text2speechstrategy;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class FreeTTS implements TTSStrategy {

	private VoiceManager voiceManager;
	private Voice voice;

	public FreeTTS() {
		
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice("kevin16");
		
		if (voice != null)
	        voice.allocate();
		else
			throw new IllegalStateException("Cannot find voice: kevin16");
	}
	
	@Override
	public void play(String content) {
		
		// voice.speak() will not return until 
		// all the UtteranceProcessors have processed it.
		// The editor will not be able to process any new actions
		// until all specified text is read thus appearing frozen.
		// This is easily solved by having speak() run on a new thread.
		Thread thread = new Thread() {
			
			public void run() {

				try {
					voice.speak(content);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};		
		thread.start();
	}

	@Override
	public void stop() {

		voice.getAudioPlayer().cancel();
	}
	
	@Override
	public void setVolume(int volumeLevel) {
		
		voice.setVolume(volumeLevel);
	}

	@Override
	public void setPitch(int pitchLevel) {
		
		voice.setPitch(pitchLevel);
	}

	@Override
	public void setRate(int rateLevel) {

		voice.setRate(rateLevel);
	}
}
