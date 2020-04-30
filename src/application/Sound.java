package application;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
	private static String walk_sound_path = ClassLoader.getSystemResource("sound/coin-eat-sound.mp3").toString();
	private static AudioClip walkAudioClip = new AudioClip(walk_sound_path);
	
	private static String pacman_die_sound_path = ClassLoader.getSystemResource("sound/pacman-die-sound.mp3").toString();
	private static AudioClip dieAudioClip = new AudioClip(pacman_die_sound_path);
	
	private static String videogame_style_sound_path = ClassLoader.getSystemResource("sound/videogame-style.mp3").toString();
	private static AudioClip introAudioClip = new AudioClip(videogame_style_sound_path);
	
	private static String winning_sound_path = ClassLoader.getSystemResource("sound/winning-sound.mp3").toString();
	private static AudioClip winAudioClip = new AudioClip(winning_sound_path);

	public static void playWalkSound() {
		walkAudioClip.setCycleCount(AudioClip.INDEFINITE);
		walkAudioClip.play(0.1);
	}
	
	public static void stopWalkSound() {
		walkAudioClip.stop();
	}
	
	public static void playWinSound() {
		winAudioClip.play(0.1);
	}
	
	public static void stopWinSound() {
		winAudioClip.stop();
	}
	
	public static void playDieSound() {
		dieAudioClip.play(0.1);
	}
	
	public static void stopDieSound() {
		dieAudioClip.stop();
	}
	
	public static void playIntroSound() {
		introAudioClip.setCycleCount(AudioClip.INDEFINITE);
		introAudioClip.play(0.1);
	}
	
	public static void stopIntroSound() {
		introAudioClip.stop();
	}
	
}
