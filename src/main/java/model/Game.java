package model;

import model.cards.Deck;
import model.cards.Hand;

/**
 * Class representing the game
 */
public class Game {
    private static final int MAXIMUM_POINTS = 21;
    private static final int BANK_MINIMUM_POINTS = 17;

    // Only one game at a time can be played
    private static Game CURRENT_GAME;

    private final Deck deck;
    private final Hand bank;
    private final Hand player;
    private GameStatus gameStatus;

    /**
     * Gets the current game
     * @return the current game
     */
    public static Game getCurrentGame() {
        if(CURRENT_GAME==null) {
            return newGame();
        }
        return CURRENT_GAME;
    }

    /**
     * Start a new game
     * @return Game New game
     */
    public static Game newGame() {
        CURRENT_GAME = new Game();
        return getCurrentGame();
    }

    /**
     * Constructor. Initializes a game by handing out the initial cards
     */
    private Game() {
        // Initialize the deck and hands
        deck = new Deck().shuffle();
        player = new Hand();
        bank = new Hand();

        // Deal the first cards
        player.giveCard(deck.deal());
        bank.giveCard(deck.deal());

        // TODO place bets

        // The player gets a second card and starts his turn
        player.giveCard(deck.deal());
        gameStatus = GameStatus.PLAYERS_TURN;
    }

    /**
     * Get the bank's Hand
     * @return Hand the bank's Hand
     */
    public Hand getBank() {
        return bank;
    }

    /**
     * Get the player's Hand
     * @return Hand the player's Hand
     */
    public Hand getPlayer() {
        return player;
    }

    /**
     * Get the GameStatus
     * @return GameStatus the current game status
     */
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    /**
     * Perform the 'hit' move (player gets another card)
     * @return Game the updated Game
     */
    public Game hit() {
        return update(() -> player.giveCard(deck.deal()));
    }

    /**
     * Perform the 'stand' move (player ending their turn)
     * @return Game the updated game
     */
    public Game stand() {
        return update(() -> gameStatus = GameStatus.BANKS_TURN);
    }

    /**
     * Update the game by performing the provided action
     * @param action Runnable The action to update the game with
     * @return
     */
    private Game update(Runnable action) {
        if(gameStatus != GameStatus.PLAYERS_TURN) {
            throw new UnsupportedOperationException("This action is not allowed because it is not the player's turn.");
        }
        action.run();
        afterUpdate();
        return this;
    }

    /**
     * After a player action, check if the player is bust or it is the bank's turn
     */
    private void afterUpdate() {
        if(gameStatus == GameStatus.PLAYERS_TURN && player.getValue() > MAXIMUM_POINTS) {
            // If the player's hand exceeds the maximum number of points, he loses and the bank wins
            gameStatus = GameStatus.BANK_WINS;
        } else if(gameStatus == GameStatus.BANKS_TURN) {
            playBank();
            setOutcome();
        }
    }

    /**
     * Let the bank make its moves (taking a card until the minimum is reached)
     */
    private void playBank() {
        while(bank.getValue() < BANK_MINIMUM_POINTS) {
            bank.giveCard(deck.deal());
        }
    }

    /**
     * Determine who is the winner
     */
    private void setOutcome() {
        if(bank.getValue() > MAXIMUM_POINTS || bank.getValue() < player.getValue()) {
            gameStatus = GameStatus.PLAYER_WINS;
        } else {
            gameStatus = GameStatus.BANK_WINS;
        }
    }
}
