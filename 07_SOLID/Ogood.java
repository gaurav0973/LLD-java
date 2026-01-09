public class Ogood {
    public static void main(String[] args){
        
        WhatsappChannel whatsapp = new WhatsappChannel();
        whatsapp.send("This is from whatsapp");
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