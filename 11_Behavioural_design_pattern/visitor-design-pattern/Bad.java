public class Bad {
    public static void main(String[] args){
        Document textFile = new TextFile();
        textFile.compressSize();
    }
}

interface Document{
    void getSize();
    void compressSize();
    void scanForVirus();
}
class TextFile implements Document{
    @Override
    public void getSize(){
        System.out.println("Calculating size of text file");
    }
    @Override
    public void compressSize(){
        System.out.println("Compressing text file");
    }
    @Override
    public void scanForVirus(){
        System.out.println("Scanning text file for virus");
    }
}
class PdfFile implements Document{
    @Override
    public void getSize(){
        System.out.println("Calculating size of text file");
    }
    @Override
    public void compressSize(){
        System.out.println("Compressing text file");
    }
    @Override
    public void scanForVirus(){
        System.out.println("Scanning text file for virus");
    }
}
class AudioFile implements Document{
    @Override
    public void getSize(){
        System.out.println("Calculating size of text file");
    }
    @Override
    public void compressSize(){
        System.out.println("Compressing text file");
    }
    @Override
    public void scanForVirus(){
        System.out.println("Scanning text file for virus");
    }
}