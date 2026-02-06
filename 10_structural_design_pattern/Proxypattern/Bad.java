public class Bad {
    public static void main(String[] args) {
        VideoDownloader video1 = new VideoDownloader("abcd");
        video1.download();
        VideoDownloader video2 = new VideoDownloader("abdffcd");
        video2.download();
    }
}


class VideoDownloader{
    private String url;
    public VideoDownloader(String url){
        this.url = url;
    }
    public void download(){
        System.out.println("Video is downloaded " + url);
    }
}