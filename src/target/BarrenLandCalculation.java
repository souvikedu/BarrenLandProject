package target;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;


/**
 * This class
 */
public class BarrenLandCalculation {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private int[][] mLand;
    private List<Land> mBarrenLandList;
    private Queue<Point> mFertileAreaQueue;
    private List<Integer> mFertileAreaList;

    public BarrenLandCalculation() {
        mLand = new int[HEIGHT][WIDTH];
        mBarrenLandList = new ArrayList<Land>();

        // populating the whole land with value 0
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                mLand[y][x] = 0;
            }
        }
        mFertileAreaQueue = new LinkedList<Point>();
        mFertileAreaList = new ArrayList<Integer>();
    }

    /**
     * This method reads input from STDIN
     */
    public void setBarrenLandInputUsingStdin() throws Exception {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            parseInput(reader.readLine());
        } finally {
            if(reader != null) {
                reader.close();
            }
        }
    }

    /**
     * This method parses the input string and assigns marks barren lands
     * Sample input:{“48 192 351 207”, “48 392 351 407”, “120 52 135 547”, “260 52 275 547”}
     */
    private void parseInput(String input) throws Exception{
        try {
            input = input.replaceAll("\\{|\\}", "");
            input = input.replaceAll("“|”", "");
            input = input.replaceAll("\"", "");
            String[] barrenLands = input.split(",");
            for (String land : barrenLands) {
                String[] points = land.split(" ");
                if(points.length == 4) {
                    mBarrenLandList.add((new Land(Integer.parseInt(points[0]), Integer
                            .parseInt(points[1]), Integer.parseInt(points[2]), Integer
                            .parseInt(points[3]))));
                }
            }

            markBarrenLands();
            fertileLandCalculation();
        } catch (Exception e){
            throw new Exception("Invalid input");
        }
    }

    /**
     * This method marks all barren lands with integer value 1
     */
    private void markBarrenLands() {
        for (Land land : mBarrenLandList) {
            for (int y = land.getBottomLeftY(); y <= land.getTopRightY(); y++) {
                for (int x = land.getBottomLeftX(); x <= land.getTopRightX(); x++) {
                    mLand[y][x] = 1;
                }
            }
        }
    }

    /**
     * This method calculates and saves areas of all fertile lands
     */
    private void fertileLandCalculation() {
        int fertileLandColor = 2;
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                int countArea = 0;
                while (!mFertileAreaQueue.isEmpty()) {
                    //flooding the area
                    Point p = mFertileAreaQueue.remove();
                    int px = p.getX();
                    int py = p.getY();
                    countArea++;
                    if (py > 0 && mLand[py - 1][px] == 0) {
                        mFertileAreaQueue.add(new Point(py - 1, px));
                        mLand[p.getY() - 1][p.getX()] = fertileLandColor;
                    }
                    if (py < (HEIGHT - 1) && mLand[py + 1][px] == 0) {
                        mFertileAreaQueue.add(new Point(py + 1, px));
                        mLand[py + 1][px] = fertileLandColor;
                    }
                    if (px > 0 && mLand[py][px - 1] == 0) {
                        mFertileAreaQueue.add(new Point(py, px - 1));
                        mLand[py][px - 1] = fertileLandColor;
                    }
                    if (px < (WIDTH - 1) && mLand[py][px + 1] == 0) {
                        mFertileAreaQueue.add(new Point(py, px + 1));
                        mLand[py][px + 1] = fertileLandColor;
                    }
                }
                if (countArea != 0) {
                    fertileLandColor++;
                    mFertileAreaList.add(countArea);
                }
                if (mLand[y][x] == 0) {
                    mFertileAreaQueue.add(new Point(y, x));
                    mLand[y][x] = fertileLandColor;
                }
            }
        }
    }

    /**
     * This method prints land
     */
    public void printOutput() {
        Collections.sort(mFertileAreaList);
        //printing space separated
        Iterator<Integer> it = mFertileAreaList.iterator();
        if (it.hasNext()) {
            System.out.print(it.next());
        }
        while (it.hasNext()) {
            System.out.print(" " + it.next());
        }
    }
}
