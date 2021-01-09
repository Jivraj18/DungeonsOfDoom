public class HumanPlayer extends Player {

    private int gold;

    public HumanPlayer() {
        super(Tile.PLAYER);
    }

    /**
     * @param map the 2D Map
     */
    //method that prints a 5x5 grid with the player's position in the middle. This is printed when the user inputs 'look'.
    public void look(char[][] map) {
        // gets the players x and y position within the 2d array of the map.
        int x = getX();
        int y = getY();
        for(int i = y - 2; i <= y + 2; i++) {
            for(int j = x - 2; j <= x + 2; j++) {
                if((j < 0 || j >= map[0].length) || (i < 0 || i >= map.length)) {
                    System.out.print(Tile.WALL.getTile());
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }

    // method that allows the user to pickup gold. If the user pickups the gold, that tile is then replaced by an empty tile.
    public void pickup() {
        if(getPreviousTile() == Tile.GOLD.getTile()) {
            this.gold++;
            setPreviousTile('.');
            System.out.println("SUCCESS. Gold owned: " + this.gold);
        } else {
            System.out.println("FAIL. Gold owned: " + this.gold);
        }
    }

    public int getGold() {
        return gold;
    }
}