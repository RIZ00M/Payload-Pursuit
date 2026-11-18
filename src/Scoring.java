public class Scoring {
    public static int calculateScore(Card[] hand, int numberOfCards, int target) {

        int normalTotal = 0;
        int aceCount = 0;

        // Loop through the player's cards and get the total value (Which assumes ace as 11)
        for (int i = 0; i < numberOfCards; i++) {
            normalTotal += hand[i].getValue();

            // Counts how many Aces are in the hand.
            if (hand[i].isAce()) {
                aceCount++;
            }
        }

        int bestScore = Integer.MAX_VALUE; // Stores the lowest score found.
        int bestTotal = normalTotal; // Stores the card total that created that score.

        // Optimisises the score based off aces, deciding how many aces to reduce incrementally
        for (int reducedAces = 0; reducedAces <= aceCount; reducedAces++) {
            int adjustedTotal = normalTotal; // Temporary score

            // Reduce the required number of Aces from 11 to 1.
            for (int i = 0; i < reducedAces; i++) {
                adjustedTotal -= 10; // Takes
            }

            // Calculate the score
            int score = getRoundScore(adjustedTotal, target);

            // If it is a better score, then adjust the score
            if (score < bestScore) {
                bestScore = score;
                bestTotal = adjustedTotal;
            }
        }
        System.out.println("Optimised total: " + bestTotal);
        // Finally return the optimised score based off the aces.
        return bestScore;
    }

    public static int getRoundScore(int total, int target) {
        if (total < target) {
            return target - total; // return score
        }

        if (total > target) {
            return (total - target) * RuleConfig.OVERSHOOT_MULTIPLIER; // return score * 3
        }

        return RuleConfig.PERFECT_HIT_BONUS; // return -4
    }
}
