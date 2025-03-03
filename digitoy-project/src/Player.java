import java.util.*;

public class Player {
    List<Tile> tiles;
    Tile okeyTile;
    Tile fakeOkeyTile;

    public Player(Tile okeyTile, Tile fakeOkeyTile) {
        this.tiles = new ArrayList<>();
        this.okeyTile = okeyTile;
        this.fakeOkeyTile = fakeOkeyTile;
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    public void showHand() {
        System.out.println("Your hand: " + tiles);
    }

    public int evaluateHand() {
        Map<String, List<Integer>> groupedByColor = new HashMap<>();
        Map<String, Map<Integer, Integer>> pairsByColor = new HashMap<>();
        int okeyCount = 0;
        int fakeOkeyCount = 0;

        for (Tile tile : tiles) {
            if (tile.color.equals("Sahte")) {
                fakeOkeyCount++;
                continue;
            }
            if (tile.color.equals(okeyTile.color) && tile.number == okeyTile.number) {
                okeyCount++;
                continue;
            }

            groupedByColor.putIfAbsent(tile.color, new ArrayList<>());
            groupedByColor.get(tile.color).add(tile.number);
            pairsByColor.putIfAbsent(tile.color, new HashMap<>());
            pairsByColor.get(tile.color).put(tile.number, pairsByColor.get(tile.color).getOrDefault(tile.number, 0) + 1);
        }

        int groupedCount = 0;

        for (Map<Integer, Integer> colorPairs : pairsByColor.values()) {
            for (int count : colorPairs.values()) {
                groupedCount += (count / 2) * 2;
            }
        }

        for (Map.Entry<String, List<Integer>> entry : groupedByColor.entrySet()) {
            List<Integer> numbers = entry.getValue();
            Collections.sort(numbers);
            int count = 1;
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(i) == numbers.get(i - 1) + 1) {
                    count++;
                } else {
                    groupedCount += count >= 3 ? count : 0;
                    count = 1;
                }
            }
            groupedCount += count >= 3 ? count : 0;
        }

        groupedCount += okeyCount;

        if (fakeOkeyCount > 0) {
            groupedCount += fakeOkeyCount;
        }

        if (groupedCount > Constants.NUMBER_OF_TILES_TO_WIN)
            return Constants.NUMBER_OF_TILES_TO_WIN - groupedCount;
        return 0;
    }
}
