package euler.level.zero;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Amicable numbers
 *
 * Let d(n) be defined as the sum of proper divisors of n
 * (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b,
 * then a and b are an amicable pair and each of a and b
 * are called amicable numbers.
 *
 * For example, the proper divisors of 220 are
 *
 * 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
 *
 * therefore d(220) = 284. The proper divisors of 284 are
 *
 * 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * @author smittyfest
 */
public class Problem21 {
  public static void main(String[] args) {
    Set<Integer> amicables = Sets.newHashSet();
    for (int i = 2; i < 10000; ++i) {
      amicables.addAll(findAmicableNumbers(i));
    }
    long sum = 0;
    for (Integer num : amicables) {
      sum += num;
      System.out.println(num);
    }
    System.out.println("Sum: " + sum);
  }

  private static List<Integer> findAmicableNumbers(int number) {
    List<Integer> amicables = Lists.newArrayList();
    int sumOne = getDivisors(number).stream().mapToInt(Integer::intValue).sum();
    int sumTwo = getDivisors(sumOne).stream().mapToInt(Integer::intValue).sum();
    if ((number != sumOne) && (number == sumTwo)) {
      amicables.add(number);
      amicables.add(sumOne);
    }
    return amicables;
  }

  private static List<Integer> getDivisors(int number) {
    List<Integer> divisors = Lists.newArrayList();
    divisors.add(1);
    for (int i = 2; i <= Math.sqrt(number); ++i) {
      if (number % i == 0) {
        int other = number / i;
        divisors.add(i);
        divisors.add(other);
      }
    }
    return divisors;
  }
}
