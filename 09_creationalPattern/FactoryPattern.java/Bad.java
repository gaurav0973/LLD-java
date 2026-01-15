public class Bad{
    public static void main(String[] args){
        NotificationService service = new NotificationService();
        service.sendNotification("EMAIL");
        service.sendNotification("SMS");
    }
}


class NotificationService {
    /*
        Problem
            - Object creation 
            - Business logic 
        => voilates Single responsibility principle
    */
    public void sendNotification(String type) {
        Notification notification;
        /*
        Problem 
            - Voilates open/close principle 
                - if I have to add whatsapp service => ek aur if else likhna padega 
        */
        if (type.equalsIgnoreCase("EMAIL")) {
            notification = new EmailNotification();
            notification.notifyUser();
            return;
        } 
        else if (type.equalsIgnoreCase("SMS")) {
            // 1 => Object creation 
            notification = new SMSNotification();
            // 2 => Business logic
            notification.notifyUser();
            return;
        } 
        throw new IllegalArgumentException("Unknown type " + type);
    }
}


interface Notification {
    void notifyUser();
}
class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Email notification...");
    }
}
class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification...");
    }
}

