import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class FileHandling {
    public static void main(String[] args) {
        // 1. Use 'Path' instead of 'File'
        Path configPath = Paths.get("server_config.txt");

        // 2. WRITING (Modern Way)
        String content = "host=localhost\nport=8080\nenv=PRODUCTION";
        try {
            Files.write(configPath, content.getBytes());
            System.out.println("Config file created.");
        } catch (IOException e) {
            System.err.println("Could not write file: " + e.getMessage());
        }

        // 3. READING (Try-With-Resources)
        // Notice the try(...) syntax. This AUTOMATICALLY closes the file.
        // No need for 'finally { br.close() }'.
        try (var reader = Files.newBufferedReader(configPath)) {
            
            System.out.println("--- Reading Config ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Config: " + line);
            }
            
        } catch (IOException e) {
            System.err.println("Could not read file: " + e.getMessage());
        }
        
        // 4. One-Liner for small files (Senior Dev Trick)
        try {
            List<String> allLines = Files.readAllLines(configPath);
            System.out.println("Quick Read First Line: " + allLines.get(0));
        } catch (IOException e) {
            // handle error
        }
    }
}