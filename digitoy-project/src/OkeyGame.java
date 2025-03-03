import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OkeyGame {

    List<Tile> tiles;
    List<Player> players;
    Tile indicator;
    Tile okeyTile;
    Tile fakeOkeyTile;

    public OkeyGame() {
        tiles = new ArrayList<>();
        players = new ArrayList<>();
        initializeTiles();
        shuffleTiles();
        selectIndicator();
        distributeTiles();
    }

    private void initializeTiles() {
        String[] colors = {"Yellow", "Blue", "Black", "Red"};
        for (String color : colors) {
            for (int i = 1; i <= 13; i++) {
                tiles.add(new Tile(color, i));
                tiles.add(new Tile(color, i));
            }
        }
        tiles.add(new Tile("Fake", 0));
        tiles.add(new Tile("Fake", 0));
    }

    private void shuffleTiles() { Collections.shuffle(tiles); }

    private void selectIndicator() {
        indicator = tiles.get(new Random().nextInt(tiles.size()));
        okeyTile = new Tile(indicator.color, indicator.number % 13 + 1);

        fakeOkeyTile = new Tile(indicator.color, okeyTile.number);
        System.out.println("Indicator: " + indicator + " | Okey Tile: " + okeyTile);
    }

    private void distributeTiles() {
        for (int i = 0; i < 4; i++) {
            players.add(new Player(okeyTile, fakeOkeyTile));
        }

        for (int i = 0; i < 14; i++) {
            for (Player player : players)
                player.addTile(tiles.remove(0));
        }
        players.get(0).addTile(tiles.remove(0));
    }

    public void showHands() {
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Player " + (i + 1) + "'s hand: ");
            players.get(i).showHand();
        }
    }

    public void findBestHand() {
        int bestScore = Integer.MAX_VALUE;
        int bestPlayer = -1;

        for (int i = 0; i < players.size(); i++) {
            int score = players.get(i).evaluateHand();
            System.out.println("Player " + (i + 1) + "number of missing tiles to win: " + score);
            if (score < bestScore) {
                bestScore = score;
                bestPlayer = i;
            }
        }
        System.out.println("The best hand is at player " + (bestPlayer + 1));
    }


}
