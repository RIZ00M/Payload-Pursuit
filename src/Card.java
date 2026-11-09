public class Card implements CardInterface {
    // Card Values
    // In Payload Pursuit, the suit of a card is unimportant however I have added it as one of my extra features.
    // Number cards (2–10): contribute their face value.
    // Face cards (Jack, Queen, King) contribute 10 points.
    // Ace cards contribute either 11 or 1, whatever improves the player’s round result.

    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getters
    public String getRank() { return rank; }

    public String getSuit() { return suit; }

    public int getValue() {
        // If it's an ace return value 11
        if (rank.equals("A")) {
            return 11;
        }

        // If it's a Jack/Queen/King return value 10
        if (rank.equals ("J") || rank.equals("Q") || rank.equals("K")) {
            return 10;
        }

        // Else return the number cards as an Integer from a String.
        return Integer.parseInt(rank);
    }

    // For our 1 or 11 rule, I use this to easily identify an ace.
    public boolean isAce() {
        return rank.equals("A");
    }

    // Print method if any card needs to be printed for the game.
    @Override
    public String toString() { return rank + suit; }
}
