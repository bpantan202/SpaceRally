package Sound;

import java.io.File;
import java.net.URL;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Sound{
    private MediaPlayer mediaPlayer;

    public Sound(String filename) {
        String soundFileUrl = getClass().getResource(filename).toString();
        Media sound = new Media(soundFileUrl);
        mediaPlayer = new MediaPlayer(sound);
    }

    public void play() {
        mediaPlayer.stop(); // Stop in case it's already playing
        mediaPlayer.play();
    }

    public void stop() {
        mediaPlayer.stop();
    }

    public void loop() {
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public void jump() {
        mediaPlayer.stop(); // Stop in case it's already playing
        mediaPlayer.play();

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> mediaPlayer.stop()));
        timeline.play();
    }
}
