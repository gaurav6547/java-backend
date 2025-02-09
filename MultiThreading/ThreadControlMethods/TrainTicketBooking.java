
class TicketBookingSystem{

    private int totalAvaliableSests = 10;

    public synchronized void bookTicket(String name) throws InterruptedException{
        while(totalAvaliableSests == 0){
            System.out.println(name + " is waiting for a seat...");
            wait();
        } 
        totalAvaliableSests--;
        System.out.println(name + " successfully booked a ticket!");
    }

    public synchronized void cancelTicket() throws InterruptedException{
        totalAvaliableSests++;
        System.out.println(name + " canceled their ticket. Notifying waiting users...");
        notify();
    }
}


class User extends Thread{

    private TicketBookingSystem ticketBooking;
    private String name;

    pubic User(TicketBookingSystem system, String name){
        this.ticketBooking = system;
        this.name = name;
    }


    public void run(){
        try{
            ticketBooking.bookTicket(name);
            Thread.sleep(1000);
            ticketBooking.cancelTicket(name);
        }catch(InterruptedException e) {
            e.printStackTrace();

        }
    }
}

public class TrainTicketBooking{
    public static void main(String[] args){

        TicketBookingSystem system = new TicketBookingSystem();

        User user1 = new User(system, "Alice");
        User user2 = new User(system, "Bob");
        User user3 = new User(system, "Charlie"); // This user will wait

        user1.start();
        user2.start();
        user3.start();
    }
}