package utils;

import java.util.Scanner;
import exceptions.InvalidMoveException;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getBoardSize() {
        System.out.print("Enter board size (3 for 3x3, 4 for 4x4, 5 for 5x5): ");
        return scanner.nextInt();
    }

    public static int getNumberOfPlayers(int boardSize) {
        if (boardSize == 3) {
            return 2;
        } else {
            System.out.print("Enter number of players (2 or 3): ");
            return scanner.nextInt();
        }
    }

    public static int getNumberOfBots() {
        System.out.print("How many bots? (0, 1, or 2): ");
        return scanner.nextInt();
    }

    public static String getPlayerName(int playerNumber) {
        System.out.print("Enter name for Player " + playerNumber + ": ");
        return scanner.next();
    }

    public static int getRow(int boardSize) {
        while (true) {
            try {
                System.out.print("Enter row (0-" + (boardSize - 1) + "): ");
                int input = scanner.nextInt();
                validateRange(input, boardSize);
                return input;
            } catch (InvalidMoveException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    public static int getColumn(int boardSize) {
        while (true) {
            try {
                System.out.print("Enter column (0-" + (boardSize - 1) + "): ");
                int input = scanner.nextInt();
                validateRange(input, boardSize);
                return input;
            } catch (InvalidMoveException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void validateRange(int input, int boardSize) {
        if (input < 0 || input >= boardSize) {
            throw new InvalidMoveException("Input must be between 0 and " + (boardSize - 1));
        }
    }
}