package euler.level.zero;

import java.math.BigInteger;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Factorial digit sum
 *
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * @author smittyfest
 */
public class Problem20 {
  public static void main(String[] args) {
    BigInteger factorial = BigInteger.ONE;
    for (long i = 100; i > 1; --i) {
      factorial = factorial.multiply(BigInteger.valueOf(i));
    }
    System.out.println(factorial);
    System.out.println(getFactorialSum(factorial.toString()));
  }

  private static long getFactorialSum(String factorial) {
    List<Integer> digits = Lists.newArrayList();
    for (int i = 0; i < factorial.length(); ++i) {
      digits.add(Integer.parseInt(String.valueOf(factorial.charAt(i))));
    }
    return digits.stream().mapToInt(Integer::intValue).sum();
  }
}
