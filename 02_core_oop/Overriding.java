import java.util.*;
class Notification {
    public void send() {
        System.out.println("Sending generic message...");
    }
}

class Email extends Notification {
    @Override
    public void send() {
        System.out.println("Sending Email via SMTP server...");
    }
}

class SMS extends Notification {
    @Override
    public void send() {
        System.out.println("Sending SMS via Twilio API...");
    }
}

public class Overriding { 
    public static void main(String[] args) {
        Notification notif = new Email();
        notif.send();
        Notification smsNotification = new SMS();
        smsNotification.send();
    

        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Email());
        notifications.add(new SMS());
        
        System.out.println("\nSending all notifications:");
        for (Notification n : notifications) {
            System.out.println(n);
            n.send(); 
        }
    }
}