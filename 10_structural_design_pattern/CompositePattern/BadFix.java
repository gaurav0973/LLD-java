import java.util.ArrayList;
import java.util.List;

public class BadFix {
    public static void main(String[] args){
        Folder root = new Folder("Root");
        root.addFile(new File("a.pdf", 10)); 

        Folder subFolder = new Folder("My Movies");
        subFolder.addFile(new File("avatar.png", 100)); 
        root.addFolder(subFolder);

        System.out.println("--- Calculating Size ---");
        int totalSize = 0;
        for(File f : root.getFiles()){
            totalSize += f.getSize();
        }
        for(Folder f : root.getFolders()){
            for(File innerFile : f.getFiles()){
                totalSize += innerFile.getSize();
            }
            
            // WHAT IF THIS FOLDER HAS ANOTHER FOLDER?
            // We would need a 3rd nested loop here... 
            // for (Folder innerFolder : f.getFolders()) { ... }
        }

        System.out.println("Total Size: " + totalSize + "MB");
    }
}

class File{
    private String name;
    private int size; // Added Size
    
    public File(String name, int size){
        this.name = name;
        this.size = size;
    }
    public int getSize(){
        return this.size;
    }
}

class Folder{
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Folder> folders = new ArrayList<>();
    
    public Folder(String name){
        this.name = name;
    }
    public void addFile(File f){
        files.add(f);
    }
    public void addFolder(Folder f){
        folders.add(f);
    }
    public List<File> getFiles() {
        return files;
    }
    public List<Folder> getFolders() {
        return folders;
    }
}