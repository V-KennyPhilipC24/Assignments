package players;

import board.Board;
import exceptions.InvalidMoveException;
import utils.InputHandler;

public class HumanPlayer extends Player {
    public HumanPlayer(String symbol, String name) {
        super(symbol, name);
    }


    @Override
    public void makeMove(Board board) {
        while (true) {
            try {
                System.out.println("\n" + name + "'s turn (Symbol: " + symbol + ")");
                int row = InputHandler.getRow(board.getSize());
                int col = InputHandler.getColumn(board.getSize());
                board.placeSymbol(row, col, symbol);
                return;
            } catch (InvalidMoveException e) {
                System.out.println("Invalid move: " + e.getMessage());
            }
        }
    }
}