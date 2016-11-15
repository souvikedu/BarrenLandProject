package target;

/**
 * This class represents a point
 */
public class Point {
    private int mX, mY;

    public Point(int y, int x) {
        mX = x;
        mY = y;
    }

    /**
     * Getter method for y coordinate value
     * @return y coordinate value
     */
    public int getY() {
        return mY;
    }

    /**
     * Getter method for x coordinate value
     * @return x coordinate value
     */
    public int getX() {
        return mX;
    }
}
