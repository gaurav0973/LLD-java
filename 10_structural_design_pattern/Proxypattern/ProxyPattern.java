import java.util.HashMap;
import java.util.Map;

public class ProxyPattern {
    public static void main(String[] args) {
        Video video1 = new ProxyVideoDowloader("abcd");
        video1.download();
        Video video2 = new ProxyVideoDowloader("abcd");
        video2.download();
    }
}

interface Video{
    void download();
}

class VideoDownloader implements Video{
    private String url;
    public VideoDownloader(String url){
        this.url = url;
    }

    @Override
    public void download(){
        System.out.println("Video is downloaded " + url);
    }
}

class ProxyVideoDowloader implements Video{
    private String url;
    private VideoDownloader videoDownloader;
    private static Map<String, Boolean> mpp = new HashMap<>();

    public ProxyVideoDowloader(String url){
        this.url = url;
        this.videoDownloader = new VideoDownloader(url);
    }

    @Override
    public void download(){
        if(mpp.containsKey(url)){
            System.out.println("From the catched : " + url);
            return;
        }
        
        videoDownloader.download();
        mpp.put(url, true);
    }
}