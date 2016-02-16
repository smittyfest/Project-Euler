package euler.level.zero;

/**
 * Smallest multiple
 *
 * 2520 is the smallest number that can be divided by each
 * of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible
 * by all of the numbers from 1 to 20?
 *
 * @author smittyfest
 */
public class Problem05 {
  public static void main(String[] args) {
    int limit = 20;
    for (int i = limit * 2; i < Integer.MAX_VALUE; i += limit) {
      if (isDivisibleByAll(limit, i)) {
        System.out.println(i);
        break;
      }
    }
  }

  private static boolean isDivisibleByAll(int limit, int number) {
    for (int i = 1; i <= limit; ++i) {
      if (number % i != 0) {
        return false;
      }
    }
    return true;
  }
}
