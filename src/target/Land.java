package target;

/**
 * This class represents a land area
 */
public class Land {
    private int mBottomLeftX, mBottomLeftY, mTopRightX, mTopRightY;

    public Land(int y1, int x1, int y2, int x2) {
        mBottomLeftY = y1;
        mBottomLeftX = x1;
        mTopRightY = y2;
        mTopRightX = x2;
    }

    /**
     * Getter method for bottom left corner point x coordinate value
     * @return x value
     */
    public int getBottomLeftX() {
        return mBottomLeftX;
    }

    /**
     * Getter method for bottom left corner point y coordinate value
     * @return y value
     */
    public int getBottomLeftY() {
        return mBottomLeftY;
    }

    /**
     * Getter method for top right corner point x coordinate value
     * @return x value
     */
    public int getTopRightX() {
        return mTopRightX;
    }

    /**
     * Getter method for top right corner point y coordinate value
     * @return y value
     */
    public int getTopRightY() {
        return mTopRightY;
    }
}
