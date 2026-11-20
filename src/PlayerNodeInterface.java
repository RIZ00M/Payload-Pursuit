public interface PlayerNodeInterface {
    // Get the player stored in the node
    Player getPlayer();

    // Get the next node
    PlayerNode getNext();

    // Set the next node
    void setNext(PlayerNode next);
}
