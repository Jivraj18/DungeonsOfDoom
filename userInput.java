import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// gets user input using a Bufferedreader.
public class userInput {

    private BufferedReader reader;

    public userInput() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}