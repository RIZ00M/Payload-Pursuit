public interface PlayerInterface {
    // Getters
    String getName();

    int getTotalWins();

    int getTotalMatches();

    int getTotalScore();

    double getWinPercentage();

    void displayHistory();

    // Setters / update methods
    void addWin();

    void addMatch(int score);
}