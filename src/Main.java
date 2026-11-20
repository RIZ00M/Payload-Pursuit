public class Main {
    static void main(String[] args) {
        System.out.println("\n============ GAME MENU ============");
        System.out.println("1. Play Match");
        System.out.println("2. View Leaderboard");
        System.out.println("3. Run a Simulation");
        System.out.println("4. Compare Two Players");
        System.out.println("5. Search Player History");
        System.out.println("6. List Players with > X Match Wins");
        System.out.println("7. Exit");
        System.out.println("==================================");

        ///////////////////////////////////////////////////
        // Temporary Tests

        // Test 1 deck and drawing
        System.out.println("\nDeck test");
        Deck deck = new Deck();
        int drawn = 0;
        while (deck.drawCard() != null) {
            drawn++;
        }
        System.out.println("Cards drawn until empty (expect 52): " + drawn);
        deck.shuffle();
        System.out.println("First card after reshuffle: " + deck.drawCard());

        // Test 2 scoring
        System.out.println("\nScoring test");
        Card[] hand = { new Card("A", "S"), new Card("K", "H") }; // 11 + 10 = 21
        System.out.println("A+K vs target 21 (expect -4): " + Scoring.calculateScore(hand, 2, 21));
        System.out.println("A+K vs target 30 (expect 9): " + Scoring.calculateScore(hand, 2, 30));

        Card[] bust = { new Card("10", "S"), new Card("K", "H"), new Card("5", "D") }; // 25
        System.out.println("25 vs target 20 (expect 15): " + Scoring.calculateScore(bust, 3, 20));

        // Test 3 player bag and leaderboard
        System.out.println("\n--- Leaderboard test ---");
        Leaderboard board = new Leaderboard();
        Player alice = board.getOrCreatePlayer("Alice");
        Player bob = board.getOrCreatePlayer("Bob");
        board.getOrCreatePlayer("alice"); // should find Alice, not make a new player

        alice.addMatch(12);
        alice.addWin();
        bob.addMatch(30);

        System.out.println("Player count (expect 2):" + board.getPlayerCount());
        board.displayLeaderboard();
        alice.displayHistory();
        ///////////////////////////////////////////////////
    }
}
