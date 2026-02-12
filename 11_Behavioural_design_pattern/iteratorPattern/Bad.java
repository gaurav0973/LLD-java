import java.util.ArrayList;
import java.util.List;

public class Bad {
    public static void main(String[] args) {
        
        YoutubePlaylist yt = new YoutubePlaylist();
        yt.add(new Video("LLD"));
        yt.add(new Video("JavaScript"));

        VideoLinkedList customList = new VideoLinkedList();
        customList.add(new Video("Design Pattern"));
        customList.add(new Video("Internals of JS"));


        //  Clint => mujhe pata hona cahiye Ki iske andar array use hua hai
        List<Video> ytList = yt.getVideos();
        for (int i = 0; i < ytList.size(); i++) {
            System.out.println(ytList.get(i).title);
        }

        // Clint => mujhe pata hona cahiye Ki iske andar Linked list use hua hai
        ListNode current = customList.getHead();
        while (current != null) {
            System.out.println(current.video.title);
            current = current.next; 
        }
    }
}




class Video {
    String title;
    public Video(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}


class YoutubePlaylist {
    private List<Video> videos = new ArrayList<>();
    public void add(Video v) {
        videos.add(v);
    }
    public List<Video> getVideos() {
        return videos;
    }
}


class ListNode {
    public Video video;
    public ListNode next;
    public ListNode(Video v) { this.video = v; }
}

class VideoLinkedList {
    private ListNode head;
    private ListNode tail;
    public void add(Video v) {
        ListNode newNode = new ListNode(v);
        if (head == null){ 
            head = newNode;
            tail = head; 
        }
        else { 
            tail.next = newNode; 
            tail = newNode; 
        }
    }
    public ListNode getHead() {
        return head;
    }
}


