//100% abstractions acheived using notification service


interface Notify{

    void sendNotification(String message);
}

class EmailNotification implements Notify{

    @Override
    public void sendNotification(String message){
        System.out.println("Sending email notification....." + message);
    }
}

class SMSNotification implements Notify{
    
    @Override
    public void sendNotification(String message){ 
        System.out.println("Sending sms notification....." + message);
    }
}

public class NotificationService{
    public static void main(String[] args){
        Notify email = new EmailNotification();
        email.sendNotification("Hi Gaurav");

        Notify sms = new SMSNotification();
        sms.sendNotification("Hi Gaurav...");
    }
}