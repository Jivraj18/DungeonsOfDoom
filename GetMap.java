import java.io.*;
import java.util.ArrayList;
import java.util.List;

// class that reads the map from the text file/
public class GetMap {

    private BufferedReader reader;


    // gets the map name and win amount. Ensures that when the map is read, the first two lines that contain name and win amount aren't part of the game.
    public Map loadMap() {
        try {
            final String name = reader.readLine().replace("name ", "");
            final int goldRequired = Integer.parseInt(reader.readLine().replace("win ", ""));
            final char[][] map = readMap();
            return new Map(name, goldRequired, map);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //gets the map from the text file.
    public GetMap(File file) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
    }

    // reads the map from the text file and makes it into a 2d array.
    private char[][] readMap() throws IOException {
        List<String> rows = new ArrayList<>();
        while (reader.ready()) {
            rows.add(reader.readLine());
        }
        final int width = rows.get(0).length();
        final int height = rows.size();
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = rows.get(i).charAt(j);
            }
        }
        return map;
    }
}