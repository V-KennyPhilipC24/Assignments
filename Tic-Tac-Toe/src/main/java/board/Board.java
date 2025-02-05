package board;

import exceptions.InvalidMoveException;

public class Board {
    private final String[][] board;
    private final int size;

    public Board(int size) {
        this.size = size;
        board = new String[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = " ";
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("-".repeat(size * 4 - 1));
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinner() {
        for (int i = 0; i < size; i++) {
            if (checkLine(board[i])) return true;
        }
        for (int j = 0; j < size; j++) {
            String[] column = new String[size];
            for (int i = 0; i < size; i++) {
                column[i] = board[i][j];
            }
            if (checkLine(column)) return true;
        }
        String[] diagonal1 = new String[size];
        String[] diagonal2 = new String[size];
        for (int i = 0; i < size; i++) {
            diagonal1[i] = board[i][i];
            diagonal2[i] = board[i][size - i - 1];
        }
        return checkLine(diagonal1) || checkLine(diagonal2);
    }

    private boolean checkLine(String[] line) {
        String first = line[0];
        if (first.equals(" ")) return false;
        for (String cell : line) {
            if (!cell.equals(first)) {
                return false;
            }
        }
        return true;
    }

    public boolean isCellEmpty(int row, int col) {
        validateCoordinates(row, col);
        return board[row][col].equals(" ");
    }

    public void placeSymbol(int row, int col, String symbol) {
        validateCoordinates(row, col);
        if (!isCellEmpty(row, col)) {
            throw new InvalidMoveException("Cell (" + row + "," + col + ") is already occupied!");
        }
        board[row][col] = symbol;
    }

    private void validateCoordinates(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new InvalidMoveException("Invalid coordinates (" + row + "," + col + ")");
        }
    }
}