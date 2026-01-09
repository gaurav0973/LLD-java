public class Omanager {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager(new WhatsappChannel());
        manager.notifyStudent("Welcome to NexEd!");
        manager = new NotificationManager(new SmsChannel());
        manager.notifyStudent("Welcome to NexEd!");
    }
}
/*
NotificationChannel => interface
    - send(message)
        - this will depends on who is calling this 
                - whatsapp
                - email
                - sms
*/

interface NotificationChannel{
    void send(String message);
}

/*
So, is it allowed? YES.
- Creating an Interface Object (new NotificationChannel()) = ILLEGAL. ❌
- Creating an Interface Reference Variable (NotificationChannel channel;) = REQUIRED for good design. ✅
*/
class NotificationManager{
    private NotificationChannel channel;
    public NotificationManager(NotificationChannel channel) {
        this.channel = channel;
    }
    public void notifyStudent(String msg) {
        channel.send(msg);
    }

}
class SmsChannel implements NotificationChannel{
    public void send(String message){
        System.out.println("Sending SMS : " + message);
    }
}
class EmailChannel implements NotificationChannel{
    public void send(String message){
        System.out.println("Sending Email : " + message);
    }
}
class WhatsappChannel implements NotificationChannel{
    public void send(String message){
        System.out.println("Sending Whatsapp : " + message);
    }
}