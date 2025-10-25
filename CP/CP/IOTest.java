import java.io.FileWriter;

public class IOTest {
    public static void main(String[] args) {
        String jsonContent = """
                {
                    "name": "Campusly",
                    "version": "1.0",
                    "developer": "Harsh",
                    "category": "Education",
                    "features": {
                        "notes": true,
                        "matchmaking": true,
                        "studyTools": true
                    }
                }
                """;
        try (FileWriter file = new FileWriter("sample.json")) {
            file.write(jsonContent);
            ;
            System.out.println("Json successfull");

        } catch (Exception e) { 
        }
    }
}
