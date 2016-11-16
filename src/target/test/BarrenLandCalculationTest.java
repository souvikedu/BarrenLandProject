package target.test;

import junit.framework.TestCase;
import org.junit.Test;
import target.BarrenLandCalculation;

import java.io.*;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertEquals;

/**
 * This is the unit test class for BarrenLandCalculation class.
 */
public class BarrenLandCalculationTest extends TestCase {
    private OutputStream mOutputStream;
    private InputStream mInputStream;

    /**
     * Unit test setup
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(mOutputStream));
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        mInputStream.close();
        mOutputStream.close();
    }

    /**
     * This method setups the Input Stream for testing
     *
     * @param input input string
     */
    private void setUpInput(String input) {
        mInputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(mInputStream);
    }

    /**
     * Testing barren land calculation where full area is barren land
     */
    public void testFullBarrenLand() throws IOException {
        setUpInput("{“0 0 399 599”}");
        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        barrenLandCalculation.barrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();

        assertEquals("", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation for
     * Test Case 1 :
     * input  : "{“0 292 399 307”}"
     * output : 116800 116800
     */
    public void testBarrenLandTestCase1() throws IOException {
        setUpInput("{“0 292 399 307”}");

        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        barrenLandCalculation.barrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();

        assertEquals("116800 116800", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation for
     * Test Case 2 :
     * input  : "{“48 192 351 207”,“48 392 351 407”,“120 52 135 547”,“260 52 275 547”}"
     * output : 22816 192608
     */
    public void testBarrenLandTestCase2() throws IOException {
        setUpInput("{“48 192 351 207”,“48 392 351 407”,“120 52 135 547”,“260 52 275 547”}");

        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        barrenLandCalculation.barrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();

        assertEquals("22816 192608", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation where full area is fertile land. Expected output 600 x 400
     */
    public void testFullFertileLand() throws IOException {
        setUpInput("{“”}");

        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        barrenLandCalculation.barrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();

        assertEquals("240000", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation invalid input
     * Empty input
     */
    public void testInvalidInput1() throws IOException {
        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        setUpInput("");
        barrenLandCalculation.barrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();
        assertEquals("Invalid input", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation invalid input
     * Out of range coordinate for input >=400 for Y coordinate or >=600 for X coordinate
     */
    public void testInvalidInput2() throws IOException {
        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        setUpInput("{“0 292 399 800”}");
        barrenLandCalculation.barrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();
        assertEquals("Invalid input", mOutputStream.toString());
    }

    /**
     * Testing barren land calculation invalid input
     * Negative value
     */
    public void testInvalidInput3() throws IOException {
        BarrenLandCalculation barrenLandCalculation = new BarrenLandCalculation();
        setUpInput("{“0 292 -3 200”}");
        barrenLandCalculation.barrenLandInputUsingStdin();
        barrenLandCalculation.printOutput();
        assertEquals("Invalid input", mOutputStream.toString());
    }
}
