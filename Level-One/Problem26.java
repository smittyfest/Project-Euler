package euler.level.one;

import java.util.HashMap;
import java.util.Map;

/**
 * Reciprocal cycles
 *
 * A unit fraction contains 1 in the numerator.
 * The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *
 * 1/2 = 0.5
 * 1/3 = 0.(3)
 * 1/4 = 0.25
 * 1/5 = 0.2
 * 1/6 = 0.1(6)
 * 1/7 = 0.(142857)
 * 1/8 = 0.125
 * 1/9 = 0.(1)
 * 1/10 = 0.1
 *
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
 * It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest
 * recurring cycle in its decimal fraction part.
 *
 * @author smittyfest
 */
public class Problem26 {
  public static void main(String[] args) {

    long limit = 1000;
    long maxCycleLength = 0;
    long maxDenominator = 0;
    for (long i = 2; i <= limit; ++i) {
      if (isPrime(i)) {
        int cycleLength = getCycleLength(i);
        if (cycleLength > maxCycleLength) {
          maxCycleLength = cycleLength;
          maxDenominator = i;
        }
      }
    }
    System.out.println("Maximum Denominator: " + maxDenominator);
    System.out.println("Maximum Cycle Length: " + maxCycleLength);
  }

  private static int getCycleLength(long n) {
    Map<Long,Integer> stateToIter = new HashMap<>();
    long state = 1;
    int iter = 0;
    while (!stateToIter.containsKey(state)) {
      stateToIter.put(state, iter);
      state = state * 10 % n;
      iter++;
    }
    return iter - stateToIter.get(state);
  }

  private static boolean isPrime(Long n) {
    Double sqrt = Math.sqrt(n.doubleValue());
    for (int i = 2; i <= sqrt; ++i) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
