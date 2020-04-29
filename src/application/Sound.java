package application;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sound {
	private static String coin_eat_sound_path = ClassLoader.getSystemResource("sound/coin-eat-sound.mp3").toString();
//	private static Media coin_eat_sound = new Media(coin_eat_sound_path);
	private static AudioClip coinAudioClip = new AudioClip(coin_eat_sound_path);
	
	private static String pacman_die_sound_path = ClassLoader.getSystemResource("sound/pacman-die-sound.mp3").toString();
//	private static Media pacman_die_sound = new Media(pacman_die_sound_path);
	private static AudioClip dieAudioClip = new AudioClip(pacman_die_sound_path);
	
	private static String videogame_style_sound_path = ClassLoader.getSystemResource("sound/videogame-style.mp3").toString();
//	private static Media videogame_style_sound = new Media(videogame_style_sound_path);
	private static AudioClip introAudioClip = new AudioClip(videogame_style_sound_path);
	
	private static String winning_sound_path = ClassLoader.getSystemResource("sound/winning-sound.mp3").toString();
//	private static Media winning_sound = new Media(winning_sound_path);
	private static AudioClip winAudioClip = new AudioClip(winning_sound_path);
//	
//	private static AudioClip audioClip;

	
	public static void playCoinSound() {
		if(coinAudioClip.isPlaying() == false) {
			coinAudioClip.play(0.1);
		}
	}
	
	public static void stopCoinSound() {
		coinAudioClip.stop();
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
		introAudioClip.setCycleCount(0);
		introAudioClip.play(0.1);
	}
	
	public static void stopIntroSound() {
		introAudioClip.stop();
	}
	
}
