

// lists the possible directions for when the player inputs 'move _'
public enum Direction {

    NORTH('n'), SOUTH('s'), EAST('e'), WEST('w');

    private final char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }
}