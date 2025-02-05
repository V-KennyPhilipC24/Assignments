package players;

import board.Board;

public abstract class Player {
    protected String symbol;
    protected String name;

    public Player(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public abstract void makeMove(Board board);
}