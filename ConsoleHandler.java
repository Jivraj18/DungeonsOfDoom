


public class ConsoleHandler {

    private GameLogic gameLogic;

    /** @param gameLogic contains the main method to run the game.
     */
    public ConsoleHandler(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    /**
     * @return direction the player is moving in the form "Direction.    "
    */
// method that converts the user input into a different string. E.g. 'move w' would be converted to Direction.NORTH
    private Direction convertDirection(String arg) {
        if(arg.length() == 1) {
            for(Direction direction : Direction.values()) {
                if(direction.getDirection() == arg.charAt(0)) {
                    return direction;
                }
            }
        }
        return null;
    }

    /**
     * @param map The 2D Map
     * @param player The player's inputs
    */

    /* First gets the user input and converts it into a string in which all the characters are lowercase.
     * This method then tells the console what to do when the user inputs certain phrases.
     * This also ensures that the user can input the phrase with a mixture of capital and lowercase letters.
     */
    public void handleCommand(Map map, HumanPlayer player) {
        final String[] input = gameLogic.getInput().read().toLowerCase().split(" ");
        switch (input[0]) {
            case "hello":
                System.out.println("Gold to win: " + map.getGoldRequired()); //when 'hello' inputted, the amount of gold required is printed.
                break;
            case "gold":
                System.out.println("Gold owned: " + player.getGold());//when gold printed, the amount of gold they have is printed.
                break;
            case "move":
                if (input.length == 2) {
                    final Direction direction = convertDirection(input[1]);
                    player.move(direction, map.getMap()); // method called which allows the player to move the direction they input.
                }
                break;
            case "pickup":
                player.pickup(); //pickup method called which allows the user to pickup the gold if they are on the same tile as the gold.
                break;
            case "look":
                player.look(map.getMap()); //calls a method which prints a 5x5 view from the players current position.
                break;
            case "quit":
                if (gameLogic.playerWin(player, map.getGoldRequired())) {
                    System.out.println("WIN"); //if player exits with all the gold, 'WIN' is printed.
                } else {
                    System.out.println("LOSE"); //if player exists without all the gold, 'LOSE' is printed.
                }
                gameLogic.endGame();
                break;

            default:
                System.out.println("Error: Incorrect Input"); //if they do not input any of the above phrases, then this error message is printed.
        }
    }
}