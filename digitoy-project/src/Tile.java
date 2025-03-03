public class Tile {
    String color;
    int number;

    public Tile(String color, int number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public String toString() {
        return color + " - " + number;
    }
}
