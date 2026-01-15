public class Simplefactory{
    public static void main(String[] args){
        NotificationService service = new NotificationService();
        service.sendNotification("EMAIL");
        service.sendNotification("SMS");
    }
}

class NotificationService {
    public void sendNotification(String type) {
        Notification notification = NotificationFactory.createNotification(type);
        notification.notifyUser();
    }
}

/*
- Notification Factory Class
    - Only logic where the object creation logic is there
*/
class NotificationFactory {
    /*
    Method is Static => Why ? 
        - Class has no any data => state => to manage => Statelessness
        - Because we don't want to create an object just to use one method. 
            We just want to call the function.
    */
    public static Notification createNotification(String type) {
        if (type.equalsIgnoreCase("EMAIL")) {
            Notification email = new EmailNotification();
            return email;
        } 
        else if (type.equalsIgnoreCase("SMS")) {
            Notification sms = new SMSNotification();
            return sms;
        } 
        else {
            throw new IllegalArgumentException("Unknown type " + type);
        }
    }
}

/*
I can still Say that NotificationService class have still two responsiblilties
    - creating the notification object
    - business logoc => calling function
But I am wrong here because
    - Creating the notification object => Done by NotificationFactory here
        => Single responsiblity Principle holds here
*/
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


