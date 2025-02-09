// Updated Adapter Class
public class MediaAdapter implements MediaPlayer {
    private OldMediaPlayer oldMediaPlayer;
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp3")) {
            this.oldMediaPlayer = new OldMediaPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            this.advancedMediaPlayer = new AdvancedMediaPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            oldMediaPlayer.playMp3(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        } else {
            System.out.println("Invalid audio type: " + audioType + ". Only MP3 and MP4 are supported.");
        }
    }
}
