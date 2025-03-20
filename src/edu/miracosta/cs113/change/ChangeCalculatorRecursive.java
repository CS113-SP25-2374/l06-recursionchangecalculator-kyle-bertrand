package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculatorRecursive extends ChangeCalculator {

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static List<String> calculateRecursive(int cents) {
        // TODO:
        // Implement a recursive solution following the given documentation.
        List<String> combinations = new ArrayList<>();
        calculateCombinations(cents, new int[COINS.length],0,combinations);
        return combinations;
    }

    private static void calculateCombinations(int remainingCents, int[] coinCounts, int coinIndex, List<String> combinations) {
      if(coinIndex == COINS.length-1) {
      coinCounts[coinIndex] = remainingCents;
      combinations.add(combinationToString(coinCounts));
      return;
      }
      int coinValue = COINS[coinIndex];
      for(int i = 0; i <=remainingCents/coinValue; i++) {
          coinCounts[coinIndex]=i;
          calculateCombinations(remainingCents-(i*coinValue), coinCounts, coinIndex+1, combinations);

      }
    }
}