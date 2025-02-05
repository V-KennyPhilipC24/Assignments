package players;

import board.Board;
import java.util.Random;

public class BotPlayer extends Player {
    public BotPlayer(String symbol, String name) {
        super(symbol, name);
    }

    @Override
    public void makeMove(Board board) {
        System.out.println(name + "'s turn (Bot with Symbol: " + symbol + ")");
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.isCellEmpty(row, col));

        board.placeSymbol(row, col, symbol);
        System.out.println(name + " placed " + symbol + " at (" + row + ", " + col + ")");
    }
}