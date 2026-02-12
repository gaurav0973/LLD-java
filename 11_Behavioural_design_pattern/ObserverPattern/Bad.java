import java.util.ArrayList;
import java.util.List;

public class Bad {
    public static void main(String[] args){
        YouTubeChannel channel = new YouTubeChannel();
        channel.subscribe(new Subscriber("gaurav"));
        channel.subscribe(new Subscriber("maurya"));
        channel.uploadNewVideo("Observer Pattern");
    }
}



class Subscriber{
    private String name;
    public Subscriber(String name) { 
        this.name = name; 
    }
    
    public void notifyUser(String title) {
        System.out.println("Notification for " + name + ": " + title);
    }
}
class YouTubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();
    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }
    public void uploadNewVideo(String title) {
        System.out.println("Uploading: " + title);
        for (Subscriber s : subscribers) {
            s.notifyUser(title);
        }
    }
}