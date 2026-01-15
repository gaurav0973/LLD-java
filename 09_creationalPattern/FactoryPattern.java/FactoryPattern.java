public class FactoryPattern {
    public static void main(String[] args){
        NotificationService service = new NotificationService();
        service.sendNotification(new SMSFactory());
        service.sendNotification(new EmailFactory());

    }
}


class NotificationService {
    public void sendNotification(NotificationFactory factory) {
        Notification notification = factory.createNotification();
        notification.notifyUser();
    }
}


interface NotificationFactory {
    Notification createNotification();
}
class EmailFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        Notification email =  new EmailNotification();
        return email;
    }
}
class SMSFactory implements NotificationFactory {
    @Override
    public Notification createNotification() {
        Notification sms = new SMSNotification();
        return sms;
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


    