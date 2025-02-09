import java.util.Vector;

class ChatRoom{

    private final Vector<String> messages;
    
    public ChatRoom(){
        this.messages = new Vector<>();
    }

    void PostMessages(String userName, String message){
        String formattedMessage = userName + ": " + message;
        messages.add(formattedMessage); // Thread-safe add operation
        System.out.println("New message posted: " + formattedMessage);
    }

    void DisplayMessages(){
        for(String msg : messages){
            System.out.println("live messages : " + msg);
        }
    }
}

class User implements Runnable{

    private final ChatRoom chatRoom;
    private final String userName;
    private final String message;

    public User(ChatRoom chatRoom, String userName, String message){
        this.chatRoom = chatRoom;
        this.userName = userName;
        this.message = message;
    }

    @Override
    public void run(){
        chatRoom.PostMessages(userName, message);
        //chatRoom.PostMessages(userName, message);
    }
}

public class ChatRoomExample{
    public static void main(String[] args){

        ChatRoom chatRoom = new ChatRoom();

        Thread t1 = new Thread(new User(chatRoom, "Gaurav", "hello everyone gaurav this side..."));

        Thread t2 = new Thread(new User(chatRoom, "Amrut", "hello everyone Amrut here..."));

        Thread t3 = new Thread(new User(chatRoom, "Niraj", "I am Niraj"));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        chatRoom.DisplayMessages();
    }
}