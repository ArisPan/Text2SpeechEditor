package text2speechstrategy;

public interface TTSStrategy {

	public void play(String content);
	public void stop();
	public void setVolume(int volumeLevel);
	public void setPitch(int pitchLevel);
	public void setRate(int rate);
}
