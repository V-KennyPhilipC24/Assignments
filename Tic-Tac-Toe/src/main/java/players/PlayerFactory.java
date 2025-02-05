package players;

public class PlayerFactory {
    public static Player createPlayer(String symbol, String name, boolean isBot) {
        if (isBot) {
            return new BotPlayer(symbol, name);
        } else {
            return new HumanPlayer(symbol, name);
        }
    }
}