public class Card implements CardInterface {
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
        // If it's an ace return value 11. The logic behind 1 or 11 will be calculated in Scoring.Java
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
