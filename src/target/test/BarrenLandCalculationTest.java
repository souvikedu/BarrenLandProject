package target.test;

import org.junit.Test;
import target.BarrenLandCalculation;
import java.io.*;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;

/**
 * This is the unit test class for BarrenLandCalculation class.
 */
public class BarrenLandCalculationTest {
    private OutputStream mOutputStream;

    /**
     * Unit test setup
     * @param input STDIN input
     */
    private void setup(String input) {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        mOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mOutputStream));
    }

    /**
     * Testing barren land calculation where full area is barren land
     */
    @Test
    public void testFullBarrenLand() throws Exception {
        setup("{“0 0 399 599”}");
        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        barrenLandCalculation.setBarrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();

        assertEquals("", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation for
     * Test Case 1 :
     * input  : "{“0 292 399 307”}"
     * output : 116800 116800
     */
    @Test
    public void testBarrenLandTestCase1() throws Exception {
        setup("{“0 292 399 307”}");

        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        barrenLandCalculation.setBarrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();

        assertEquals("116800 116800", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation for
     * Test Case 2 :
     * input  : "{“48 192 351 207”,“48 392 351 407”,“120 52 135 547”,“260 52 275 547”}"
     * output : 22816 192608
     */
    @Test
    public void testBarrenLandTestCase2() throws Exception {
        setup("{“48 192 351 207”,“48 392 351 407”,“120 52 135 547”,“260 52 275 547”}");

        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        barrenLandCalculation.setBarrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();

        assertEquals("22816 192608", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation where full area is fertile land. Expected output 600 x 400
     */
    @Test
    public void testFullFertileLand() throws Exception {
        setup("{“”}");

        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        barrenLandCalculation.setBarrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();

        assertEquals("240000", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation invalid input
     */
    @Test
    public void testInvalidInput() {
        setup("");

        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        try {
            barrenLandCalculation.setBarrenLandInputUsingStdin();
            barrenLandCalculation.printOutput();
            fail();
        } catch (Exception e) {
            assertEquals("Invalid input", e.getMessage());
        }
    }
}
