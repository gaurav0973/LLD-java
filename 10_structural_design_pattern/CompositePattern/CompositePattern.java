import java.util.List;
import java.util.ArrayList;

public class CompositePattern {
    public static void main(String[] args){
        Folder root = new Folder("Root");
        root.addComponent(new File("a.pdf", 10));

        Folder subFolder = new Folder("My Movies");
        subFolder.addComponent(new File("avatar.png", 100));
        root.addComponent(subFolder);

        System.out.println("--- Calculating Size-------");
        System.out.println("Total Size: " + root.getSize() + "MB");
    }
}

interface FileSystemComponent {
    int getSize();
}

// Leaf
class File implements FileSystemComponent {
    private String name;
    private int size;
    
    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    @Override
    public int getSize() {
        return this.size;
    }
}

// non-leaf = Composite
class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();
    
    public Folder(String name) {
        this.name = name;
    }
    
    public void addComponent(FileSystemComponent c) {
        children.add(c);
    }
    
    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent child : children) {
            totalSize += child.getSize();
        }
        
        return totalSize;
    }
}