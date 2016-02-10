package euler.level.zero;

import java.util.stream.IntStream;

/**
 * Multiples of 3 and 5
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author smittyfest
 */
public class Problem01 {
  public static void main(String[] args) {

    final int limit = 1000;
    int sum = 0;

    for (int i = 0; i < limit; ++i) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    System.out.println(sum);
    System.out.println(jdk8stream());
  }

  private static int jdk8stream() {
    return IntStream.range(0, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
  }
}
