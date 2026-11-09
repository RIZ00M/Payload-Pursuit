import java.util.Random;

public class Deck implements DeckInterface {
    //  restocked and shuffled at the start of each round.
    // The game objective is to estimate how many cards can be drawn from a shuffled deck without their
    //cumulative value exceeding a dynamically changing payload limit. Unlike a fixed
    //-
    //target game, the payload
    //limit evolves based on player performance in the previ
    //ous round, adding tactical depth and requiring
    //careful management of guesses. Each match comprises the number of rounds. Players gain points based on
    //how close they are to the payload limit in each round. The closer the result, the lower the score. Exceedi
    //ng
    //the limit results in a penalty. The player with the lowest overall score at the end of the match is the winner.

    private Card[] cards;
    private int nextCard;

    public Deck() {
        // Creating the fixed size deck of 52 cards
        cards = new Card[RuleConfig.DECK_SIZE];

        // Card class handles the logic to A/J/Q/K cards storing them as numeric values.
        String[] suits = {"S", "H", "D", "C"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // Create an index to store the object from 0 - 51
        int index = 0;

        // For every suit, apply a rank at the given index.
        for (int i = 0; i < suits.length; i++) {
            for (int x = 0; x < ranks.length; x++) {
                // Create a card object with the rank and suit, the Card class handles the values.
                cards[index] = new Card(ranks[x], suits[i]);
                index++;
            }
        }
        shuffle();
    }

    public void shuffle() {
        Random random = new Random();

        // Start at the last array index (51), as array indexing starts at 0.
        // Shuffle backwards as once a card is randomly placed in its final position, it does not need moved again,
        // leaving fewer cards to shuffle each time making it more efficient way to write this code.
        for (int i = cards.length - 1; i > 0; i--) {
            // AI used here, to achieve complete randomless add 1 as the card could also remain at the same position.
            int randomNumber = random.nextInt(i + 1);

            // Store the original card
            Card temporary = cards[i];
            // Random card goes into the original card's position.
            cards[i] = cards[randomNumber];
            // Original card goes into the random card's position.
            cards[randomNumber] = temporary;
        }
        // Reset the next card position so the shuffled deck can be drawn from the start
        nextCard = 0;
    }

    public Card drawCard() {
        // First check if all cards have been drawn from the deck, else return null
        if (nextCard >= cards.length) {
            return null;
        }

        // From our shuffled cards, we can easily just go from 0-51 as they're already random.
        Card drawnCard = cards[nextCard];

        // Increment through the shuffled deck
        nextCard++;

        return drawnCard;
    }
}
