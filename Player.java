import java.util.Random;

public abstract class Player {

    private final Tile tileType;
    private int x;
    private int y;
    private char previousTile;

    public Player(Tile tileType) {
        this.tileType = tileType;
    }

    /**
     * @param map the 2D map array
     */
    //sets a random starting point in the map. Ensures the player doesn't spawn in a wall.
    public void startingPoint(char[][] map) {
        int x, y;
        char tile;
        Random random = new Random();
        while(true) {
            x = random.nextInt(map[0].length - 2);
            y = random.nextInt(map.length - 2);
            tile = map[y][x];
            if(tile == Tile.EMPTY_FLOOR.getTile() || tile == Tile.EXIT.getTile()) {
                this.previousTile = map[y][x];
                changePosition(x, y, map);
                return;
            }
        }
    }

    /**
     * @param changeInX difference between new and previous x value
     * @param changeInY difference between new and previous y value
     * @param map The 2D Map
     * @return
     */
    // method that ensures that the previous tile of the player changes back to an empty square. Also makes sure the player is not moving into a wall.
    private boolean changePosition(int changeInX, int changeInY, char[][] map) {
        int newX = this.x + changeInX;
        int newY = this.y + changeInY;
        // checks the tile the player will be moving onto is not a wall.
        if(map[newY][newX] != Tile.WALL.getTile()) {
            if(this.y != 0 && this.x != 0) {
                map[this.y][this.x] = this.previousTile;
            }
            this.previousTile = map[newY][newX];
            this.x = newX;
            this.y = newY;
            map[y][x] = tileType.getTile();
            return true;
        }
        return false;
    }

    /**
     * @param direction direction the player is moving
     * @param map the 2D map
     */
     // changes the players position on the map using and prints whether the move was successful or not.
    public void move(Direction direction, char[][] map) {
        boolean valid = false;
        if(direction == Direction.NORTH) {
            valid = changePosition(0, -1, map);
        } else if(direction == Direction.SOUTH) {
            valid = changePosition(0, 1, map);
        } else if(direction == Direction.EAST) {
            valid = changePosition(1, 0, map);
        } else if(direction == Direction.WEST) {
            valid = changePosition(-1, 0, map);
        }

        if(valid) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }
    }

    public abstract void look(char[][] map);

    public void setPreviousTile(char tile) {
        this.previousTile = tile;
    }

    public char getPreviousTile() {
        return previousTile;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}