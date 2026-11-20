public interface LeaderboardInterface {
    // Find an existing player
    Player findPlayer(String name);

    // Find or create a player
    Player getOrCreatePlayer(String name);

    // Display sorted leaderboard
    void displayLeaderboard();

    // Return number of players
    int getPlayerCount();

    // Retrieve a player by index
    Player getPlayer(int index);
}