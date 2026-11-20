public class PlayerBag implements PlayerBagInterface {

    private PlayerNode firstNode;
    private int count;

    // Constructor
    public PlayerBag() {
        firstNode = null;
        count = 0;
    }

    // Add a player to the bag
    public void add(Player player) {
        PlayerNode newNode = new PlayerNode(player);
        newNode.setNext(firstNode);
        firstNode = newNode;
        count++;
    }

    // Return number of players
    public int size() {
        return count;
    }

    // Retrieve a player at a particular index
    public Player get(int index) {
        if (index < 0 || index >= count) {
            return null;
        }

        PlayerNode current = firstNode;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getPlayer();
    }
}
