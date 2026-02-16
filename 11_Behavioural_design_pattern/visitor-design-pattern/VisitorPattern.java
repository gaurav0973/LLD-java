public class VisitorPattern {
    public static void main(String[] args){
        Document myText = new TextFile();
        Document myPdf = new PdfFile();

        // 2. Create our operations (Visitors)
        DocumentVisitor scanner = new VirusScannerVisitor();
        DocumentVisitor compressor = new CompressionVisitor();

        System.out.println("--- Running Virus Scan ---");
        myText.accept(scanner);
        myPdf.accept(scanner);

        System.out.println("\n--- Running Compression ---");
        myText.accept(compressor);
        myPdf.accept(compressor);
    }
}

interface DocumentVisitor{
    void visit(TextFile f);
    void visit(PdfFile p);
    void visit(AudioFile a);
}
// Feature 1: Virus Scanning
class VirusScannerVisitor implements DocumentVisitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Scanning TEXT file for hidden malicious scripts...");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Scanning PDF file for malicious macros...");
    }

    @Override
    public void visit(AudioFile audioFile) {
        System.out.println("Scanning AUDIO file for malicious bytes...");
    }
}
// Feature 2: Compression
class CompressionVisitor implements DocumentVisitor {
    @Override
    public void visit(TextFile textFile) {
        System.out.println("Compressing TEXT file by removing spaces...");
    }

    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Compressing PDF file by reducing image resolution...");
    }

    @Override
    public void visit(AudioFile audioFile) {
        System.out.println("Compressing AUDIO file by lowering bitrate...");
    }
}


interface Document{
    void accept(DocumentVisitor visitor);
}
class TextFile implements Document{
    @Override
    public void accept(DocumentVisitor visitor){
        visitor.visit(this);
    }
}
class PdfFile implements Document{
    @Override
    public void accept(DocumentVisitor visitor){
        visitor.visit(this);
    }
}
class AudioFile implements Document{
    @Override
    public void accept(DocumentVisitor visitor){
        visitor.visit(this);
    }
}