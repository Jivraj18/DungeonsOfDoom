
//lists the tiles of the maps.
public enum Tile {

    PLAYER('P'), EMPTY_FLOOR('.'), GOLD('G'), EXIT('E'), WALL('#');

    private final char tile;

    Tile(char representation) {
        this.tile = representation;
    }

    public char getTile() {
        return tile;
    }
}