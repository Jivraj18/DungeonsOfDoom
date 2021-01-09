public class Map {

    private final String name;
    private final int goldRequired;
    private final char[][] map;

    public Map(String name, int goldRequired, char[][] map) {
        this.name = name;
        this.goldRequired = goldRequired;
        this.map = map;
    }

    public String getMapName() {
        return name;
    }

    public int getGoldRequired() {
        return goldRequired;
    }

    public char[][] getMap() {
        return map;
    }
}
