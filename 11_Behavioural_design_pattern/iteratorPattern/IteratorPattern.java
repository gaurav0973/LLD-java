import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
    public static void main(String[] args){
        YoutubePlaylist yt = new YoutubePlaylist();
        yt.add(new Video("LLD"));
        yt.add(new Video("JavaScript"));
        
        Iterator ytIt = yt.getIterator();
        while(ytIt.hasNext()){
            Video v = ytIt.next();
            System.out.println(v.getTitle());
        }


        VideoLinkedList customList = new VideoLinkedList();
        customList.add(new Video("Design Pattern"));
        customList.add(new Video("Internals of JS"));
        
        Iterator llIt = customList.getIterator();
        while(llIt.hasNext()){
            Video v = llIt.next();
            System.out.println(v.getTitle());
        }
    }
}

//1. data class
class Video {
    String title;
    public Video(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
class ListNode {
    public Video video;
    public ListNode next;
    public ListNode(Video v) { 
        this.video = v; 
    }
}

//2. iterators
interface Iterator{
    boolean hasNext();
    Video next(); 
}
class YoutubeIterator implements Iterator {
    private List<Video> list;
    private int idx = 0; 
    public YoutubeIterator(List<Video> list) {
        this.list = list;
    }
    @Override
    public boolean hasNext() {
        return idx < list.size();
    }
    @Override
    public Video next() {
        return list.get(idx++);
    }
}
class LinkedListIterator implements Iterator {
    private ListNode curr;
    public LinkedListIterator(ListNode head) {
        this.curr = head;
    }
    @Override
    public boolean hasNext() {
        return curr != null;
    }
    @Override
    public Video next() {
        Video v = curr.video;
        curr = curr.next;
        return v;
    }
}

//3. iterables
interface Iterables {
    Iterator getIterator();
}
class YoutubePlaylist implements Iterables {
    private List<Video> videos = new ArrayList<>();
    public void add(Video v) { 
        videos.add(v); 
    }
    @Override
    public Iterator getIterator() {
        return new YoutubeIterator(this.videos);
    }
}
class VideoLinkedList implements Iterables {
    private ListNode head;
    private ListNode tail;
    
    public void add(Video v) {
        ListNode newNode = new ListNode(v);
        if (head == null) { head = tail = newNode; }
        else { tail.next = newNode; tail = newNode; }
    }
    @Override
    public Iterator getIterator() {
        return new LinkedListIterator(this.head);
    }
}
