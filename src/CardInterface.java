public interface CardInterface {
    // Getters
    String getRank();
    String getSuit();
    int getValue();

    // Ace identifier
    boolean isAce();

    // Print card method
    String toString();
}
