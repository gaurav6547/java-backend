// Updated Client Code
public class AudioPlayer {
    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaAdapter("mp3");
        mediaPlayer.play("mp3", "song.mp3"); // Supported

        MediaPlayer mp4Player = new MediaAdapter("mp4");
        mp4Player.play("mp4", "video.mp4"); // Supported

        mediaPlayer.play("avi", "movie.avi"); // Unsupported
    }
}
