public class Leaderboard {
    // I use a linked list instead of standard array to support a dynamic sized leaderboard
    private PlayerBag players;

    public Leaderboard() {
        players = new PlayerBag();
    }

    // Find an existing player
    public Player findPlayer(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equalsIgnoreCase(name)) {
                return players.get(i);
            }
        }
        return null;
    }

    // Find an existing player or create a new one
    public Player getOrCreatePlayer(String name) {
        Player existing = findPlayer(name);

        if (existing != null) {
            return existing;
        }

        Player newPlayer = new Player(name);
        players.add(newPlayer);
        return newPlayer;
    }

    // Display leaderboard sorted by wins
    public void displayLeaderboard() {
        int playerCount = players.size();

        if (playerCount == 0) {
            System.out.println("No players saved.");
            return;
        }

        // Copy players into a temporary array
        Player[] sorted = new Player[playerCount];

        for (int i = 0; i < playerCount; i++) {
            sorted[i] = players.get(i);
        }

///////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Using bubble sort for now may change later !!
        for (int i = 0; i < playerCount - 1; i++) {
            for (int x = 0; x < playerCount - i - 1; x++) {
                if (sorted[x].getTotalWins() < sorted[x + 1].getTotalWins()) {
                    Player temporary = sorted[x];
                    sorted[x] = sorted[x + 1];
                    sorted[x + 1] = temporary;
                }
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n======== LEADERBOARD ========");

        // Print as a table
        System.out.printf(
                "%-18s %-10s %-12s %-12s%n",
                "Player", "Wins", "Matches", "Win %"
        );

        for (int i = 0; i < playerCount; i++) {
            // Player Wins Matches Win %
            System.out.printf(
                    "%-18s %-10d %-12d %.2f%%%n",
                    sorted[i].getName(),
                    sorted[i].getTotalWins(),
                    sorted[i].getTotalMatches(),
                    sorted[i].getWinPercentage()
            );
        }
        System.out.println("===============================");
    }

    // Return number of players
    public int getPlayerCount() {
        return players.size();
    }

    // Retrieve a player
    public Player getPlayer(int index) {
        return players.get(index);
    }
}
