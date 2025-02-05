package game;

import board.Board;
import players.Player;
import players.PlayerFactory;
import utils.InputHandler;
import exceptions.InvalidMoveException;

public class TicTacToeGame {
    private final Board board;
    private final Player[] players;
    private int currentPlayerIndex;

    public TicTacToeGame(int boardSize, int totalPlayers) {
        this.board = new Board(boardSize);
        this.players = new Player[totalPlayers];
        this.currentPlayerIndex = 0;
        initializePlayers();
    }

    private void initializePlayers() {
        int numBots = InputHandler.getNumberOfBots();
        for (int i = 0; i < players.length; i++) {
            String playerName = InputHandler.getPlayerName(i + 1);
            boolean isBot = i < numBots;
            String symbol = (i == 0) ? "X" : (i == 1) ? "O" : "Z";
            players[i] = PlayerFactory.createPlayer(symbol, playerName, isBot);
        }
    }

    public void startGame() {
        System.out.println("Starting Tic-Tac-Toe Game!");
        board.printBoard();

        while (!board.isFull() && !board.checkWinner()) {
            try {
                Player currentPlayer = players[currentPlayerIndex];
                currentPlayer.makeMove(board);
                board.printBoard();
                currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid coordinates. Please try again.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        if (board.checkWinner()) {
            System.out.println(players[(currentPlayerIndex + players.length - 1) % players.length].getName() + " wins!");
        } else {
            System.out.println("The game is a tie!");
        }
    }

    public static void main(String[] args) {
        int boardSize = InputHandler.getBoardSize();
        int totalPlayers = InputHandler.getNumberOfPlayers(boardSize);
        TicTacToeGame game = new TicTacToeGame(boardSize, totalPlayers);
        game.startGame();
    }
}