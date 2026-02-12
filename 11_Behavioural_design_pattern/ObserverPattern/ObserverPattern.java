import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args){
        YouTubeChannel channel = new YouTubeChannel();
        Subscriber s1 = new Subscriber("Gaurav");
        PremiumUser s2 = new PremiumUser("Maurya");
        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.uploadNewVideo("Observer Pattern");
    }
}


//1. Observers => users
interface Observer {
    void notified(String title);
}
class Subscriber implements Observer {
    private String name;
    public Subscriber(String name) {
        this.name = name; 
    }
    @Override
    public void notified(String title) {
        System.out.println("Hello " + name + ", video uploaded: " + title);
    }
}

class PremiumUser implements Observer {
    private String username;
    public PremiumUser(String username) { 
        this.username = username; 
    }
    @Override
    public void notified(String title) {
        System.out.println("PUSH NOTIFICATION sent to phone of: " + username);
    }
}

// 2. Subject 
class YouTubeChannel {
    private List<Observer> observers = new ArrayList<>();
    public void subscribe(Observer o) {
        observers.add(o);
    }
    public void unsubscribe(Observer o) {
        observers.remove(o);
    }
    public void uploadNewVideo(String title) {
        System.out.println("Uploading: " + title);
        for (Observer o : observers) {
            o.notified(title);
        }
    }
}

