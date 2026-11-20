public class PlayerNode {
    private Player player;
    private PlayerNode next;

    // Constructor
    public PlayerNode(Player player) {
        this.player = player;
        next = null;
    }

    // Get player
    public Player getPlayer() {
        return player;
    }

    // Get next node
    public PlayerNode getNext() {
        return next;
    }

    // Set next node
    public void setNext(PlayerNode next) {
        this.next = next;
    }
}
