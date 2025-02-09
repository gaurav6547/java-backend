//5. Hybrid Inheritance - AI Robot (Robot + Smart Assistant)
//✅ Why Hybrid Inheritance?
//
//A Robot has general functions.
//A Smart Assistant has AI functionalities.
//A AI_Robot should have both capabilities, requiring class inheritance + interfaces.

// Base class
class Robot {
    public void performTask() {
        System.out.println("Robot is performing a task...");
    }
}

// Interface 1
interface SmartAssistant {
    void respondToVoice();
}

// Derived class + Implementing interface
class AI_Robot extends Robot implements SmartAssistant {
    public void respondToVoice() {
        System.out.println("AI Robot is responding to voice commands...");
    }
}

public class Main {
    public static void main(String[] args) {
        AI_Robot aiBot = new AI_Robot();
        aiBot.performTask(); // Inherited from Robot
        aiBot.respondToVoice(); // Implemented from SmartAssistant
    }
}
