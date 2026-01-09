public class Obad {
    
}

class NotificationService {
    public void send(String type, String message) {
        if (type.equals("EMAIL")) {
            System.out.println("Sending Email: " + message);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS: " + message);
        }
        // Task: We need to add "WHATSAPP" support.
        // But I CANNOT modify this class (Imagine it's locked/read-only).
    }
}
/*
Firstly, I can see that there is He feels flock in my notification service class, which is take Variating two things that my notification service is from email, or it is from sms If I had to add a whatsapp class, I have to Add one new if else blog That will Make me Modify this class but it will break the open, close principle
- So in order to do that, what should I do, or what I'm thinking, is I should create a interface Like notification channel I guess And then I Implement those email class sms class or the email channel sms channel and Whatsapp Channel By creating a separate class so that I can. Add another if there is an Instagram channel there, then I can just add another class of Instagram and do my job. So that is how it will go. And I will be implementing it in the Ogood file.
*/