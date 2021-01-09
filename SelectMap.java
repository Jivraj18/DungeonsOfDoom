import java.io.*;

public class SelectMap {

    private final String MAP_FOLDER = "maps/";

    private final File[] maps;

    public SelectMap() {
        this.maps = getMaps();
    }


    // prints the numbers for the maps so the user can write the number of the map they want to play.
    private void printMap() {
        for (int i = 0; i < this.maps.length; i++) {
            System.out.println("[" + (i + 1) + "] " + this.maps[i].getName());
        }
    }

    /**
     * @param input this is the user input
     */
    // allows the user to select a map they want to play. Prints an error message if user puts a number outside the range or inputs letters.
    public Map select(userInput input) {
        printMap();
        System.out.println("Choose a map to play. ");
        final int numMaps = maps.length;
        while (true) {
            try {
                int in = Integer.parseInt(input.read());
                if(in >= 1 && in <= numMaps) {
                    final File file = maps[in - 1];
                    try {
                        GetMap reader = new GetMap(file);
                        return reader.loadMap();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("You have not entered a correct input. Choose a map you want to play using the numbers from above.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
    }

    // gets the maps from the text files.
    private File[] getMaps() {
        File mapFolder = new File(MAP_FOLDER);
        // returns files that end with .txt
        return mapFolder.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(".txt");
            }
        });
    }
}