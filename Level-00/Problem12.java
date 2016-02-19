package euler.level.zero;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Highly divisible triangular number
 *
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
 *
 * The first ten terms would be:
 *
 *1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 *
 *   1: 1
 *   3: 1,3
 *   6: 1,2,3,6
 *  10: 1,2,5,10
 *  15: 1,3,5,15
 *  21: 1,3,7,21
 *  28: 1,2,4,7,14,28
 *
 * We can see that 28 is the first triangle number to have over five divisors.
 *
 * What is the value of the first triangle number to have over five hundred divisors?
 *
 * @author smittyfest
 */
public class Problem12 {
  public static void main(String[] args) {
    for (long i = 10000; i < Long.MAX_VALUE; i += 1) {
      Long triangleNumber = getTriangleNumber(i);
      List<Long> factors = findFactors(triangleNumber);
      if (factors.size() > 500) {
        System.out.println(triangleNumber);
        System.out.println(factors.size());
        for (Long num : factors) {
          System.out.println(num);
        }
        System.exit(0);
      }
    }
  }

  private static Long getTriangleNumber(Long n) {
    Long triangleNumber = 0L;
    for (Long i = n; i > 0; --i) {
      triangleNumber += i;
    }
    return triangleNumber;
  }

  private static List<Long> findFactors(Long n) {
    List<Long> factors = Lists.newArrayList();
    double sqrt = Math.sqrt(n.doubleValue());
    for (long i = 1; i < sqrt; ++i) {
      if (n % i == 0) {
        factors.add(i);
        factors.add(n / i);
      }
    }
    return factors;
  }
}