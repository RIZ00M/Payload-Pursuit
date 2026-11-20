public class Player {
    private String name;

    private int totalWins;
    private int totalMatches;
    private int totalScore;

    // For each new player store name and set stats to zero.
    public Player(String name) {
        this.name = name;

        totalWins = 0;
        totalMatches = 0;
        totalScore = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getTotalMatches() {
        return totalMatches;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public double getWinPercentage() {

        if (totalMatches == 0) {
            return 0;
        }

        return (double) totalWins / totalMatches * 100;
    }

    public void displayHistory() {
        System.out.println("\nPlayer: " + name);
        System.out.println("Matches played: " + totalMatches);
        System.out.println("Total wins: " + totalWins);
        System.out.println("Total score: " + totalScore);
        System.out.printf("Win percentage: %.2f%%\n", getWinPercentage()); // Display as .2dp
    }

    // Setters
    public void addWin() {
        totalWins++;
    }

    public void addMatch(int score) {
        totalMatches++;
        totalScore += score;
    }
}
