public interface PlayerBagInterface {
    // Add a player to the bag
    void add(Player player);

    // Return number of players
    int size();

    // Retrieve a player by index
    Player get(int index);
}
