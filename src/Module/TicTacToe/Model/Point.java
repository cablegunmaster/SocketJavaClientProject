package Module.TicTacToe.Model;

/**
 * Created by jasper wil.lankhorst on 22-3-2017.
 */
public class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
