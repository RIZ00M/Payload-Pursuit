public interface DeckInterface {
    // Shuffles deck into random order
    void shuffle();

    // Draws a card from the deck, null if none remaining.
    Card drawCard();
}
