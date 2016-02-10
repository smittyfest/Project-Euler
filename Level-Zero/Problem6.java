package euler.level.zero;

import java.math.RoundingMode;

import com.google.common.math.DoubleMath;

/**
 * Sum square difference
 *
 * The sum of the squares of the first ten natural numbers is:
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is:
 *
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first
 * ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first
 * one-hundred natural numbers and the square of the sum.
 *
 * @author smittyfest
 */
public class Problem6 {
  public static void main(String[] args) {
    int limit = 100;
    System.out.println(sumOfSquares(limit));
    System.out.println(squareOfSum(limit));
    System.out.println(difference(sumOfSquares(limit), squareOfSum(limit)));
  }

  private static long difference(long sumOfSquares, long squareOfSum) {
    return squareOfSum - sumOfSquares;
  }

  private static long sumOfSquares(int limit) {
    long sum = 0;
    for (int i = 1; i <= limit; ++i) {
      sum += Math.pow(i, 2);
    }
    return sum;
  }

  private static long squareOfSum(int limit) {
    int sum = 0;
    for (int i = 1; i <= limit; ++i) {
      sum += i;
    }
    return DoubleMath.roundToLong(Math.pow(sum, 2), RoundingMode.DOWN);
  }
}
