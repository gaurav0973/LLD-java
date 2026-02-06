import java.util.ArrayList;
import java.util.List;

public class Bad {
    public static void main(String[] args){
        Folder root = new Folder("Root");
        root.addFile(new File("a.pdf", 10)); // Size 10MB

        Folder subFolder = new Folder("My Movies");
        subFolder.addFile(new File("avatar.png", 100)); // Size 100MB
        root.addFolder(subFolder);

        System.out.println("--- Calculating Size (The Hard Way) ---");
        
        int totalSize = 0;

        // 1. Manually calculate files in root
        for(File f : root.getFiles()){
            totalSize += f.getSize();
        }
        
        // 2. We see a folder... but we don't look inside it! 
        // We just count the folder itself as size 0 (or ignore it).
        for(Folder f : root.getFolders()){
             // We are doing nothing here! 
             // We forgot to count the files inside 'My Movies'
        }

        System.out.println("Total Size: " + totalSize + "MB"); 
        // Output: 10MB (WRONG! Should be 110MB)
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