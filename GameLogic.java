public class GameLogic {

    // prints a wavy line to space the different turns.
    private final String SPACE = "~~~~~~~~~~~~~~~~~~~~";

    // gives a name to the user input.
    private final userInput userIn = new userInput();

    // indicates whether the game is running
    private boolean running = false;

    //states the conditions required for the player to win - they are on the 'E' tile and they have the gold required.
    public boolean playerWin(HumanPlayer player, int winAmount) {
        return player.getPreviousTile() == Tile.EXIT.getTile() && player.getGold() == winAmount;
    }

    /**
     *
     * @param commandProcessor how the user input is processed
     * @param humanPlayer set of regulations of the human player
     * @param map the 2D map
     * @return true
     */
    //method that prints 'Your Turn' when the player has finished their previous turn.
   private boolean humanPlayerTurn(ConsoleHandler commandProcessor, HumanPlayer humanPlayer, Map map) {
      System.out.println("Your Turn:");
       commandProcessor.handleCommand(map, humanPlayer);
        // Check the bot hasn't won and the game is still running after the human players turn
      //  return !botHasWon(humanPlayer, botPlayer) && this.running;
       return true;
    }
    //this is the main game loop. This loop constantly runs until the game ends.
    private void Loop(HumanPlayer humanPlayer, Map map) {
        final ConsoleHandler commandProcessor = new ConsoleHandler(this);
            while(this.running) {
            // Check the game is still running after the human players turn
            if(humanPlayerTurn(commandProcessor, humanPlayer, map)) {
                System.out.println("\n" + SPACE);
            }
        }
        //closes the program once the loop has finished,
     System.exit(0);
   }

   //prints a message when the player has chosen a map.
    private void message(String name) {
        System.out.println(SPACE + "\nNow entering the " + name + "\n" + SPACE);
    }

    public void playTheGame() {
        if(!this.running) {
            Map map = new SelectMap().select(userIn);
            if(map != null) {
                message(map.getMapName());

                HumanPlayer humanPlayer = new HumanPlayer();
                // Set the starting points for the player and bot
                humanPlayer.startingPoint(map.getMap());

                this.running = true;
                Loop(humanPlayer, map);
            }
        }
    }

    //checks the game has ended
    public void endGame() {
        this.running = false;
    }

    public userInput getInput() {
        return userIn;
    }
}