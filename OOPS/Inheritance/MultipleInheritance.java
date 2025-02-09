//4. Multiple Inheritance (via Interfaces) - Smartphone Features (Camera + Music Player)

//✅ Why Multiple Inheritance via Interface?
//
//A Smartphone can take photos and play music at the same time.
//Java does not support multiple class inheritance, but interfaces allow behavior sharing.

// Interface 1
interface Camera {
    void takePhoto();
}

// Interface 2
interface MusicPlayer {
    void playMusic();
}

// Implementing both interfaces
class Smartphone implements Camera, MusicPlayer {
    public void takePhoto() {
        System.out.println("Smartphone is taking a photo...");
    }

    public void playMusic() {
        System.out.println("Smartphone is playing music...");
    }
}

public class Main {
    public static void main(String[] args) {
        Smartphone phone = new Smartphone();
        phone.takePhoto();
        phone.playMusic();
    }
}
