package target.test;

import target.BarrenLandCalculation;

/**
 * This is main class to run the algorithm
 */
public class CalculationMain {

    public static void main(String[] args) throws Exception {
        BarrenLandCalculation barrenLandCalculator = new BarrenLandCalculation();
        barrenLandCalculator.setBarrenLandInputUsingStdin();
        barrenLandCalculator.printOutput();
    }
}
