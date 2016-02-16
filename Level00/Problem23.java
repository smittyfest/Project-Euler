package euler.level.zero;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * Non-abundant sums
 *
 * A perfect number is a number for which the sum of its proper divisors
 * is exactly equal to the number. For example, the sum of the proper divisors
 * of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n
 * and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number
 * that can be written as the sum of two abundant numbers is 24. By mathematical analysis,
 * it can be shown that all integers greater than 28123 can be written as the sum of
 * two abundant numbers. However, this upper limit cannot be reduced any further by
 * analysis even though it is known that the greatest number that cannot be expressed
 * as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as
 * the sum of two abundant numbers.
 *
 * @author smittyfest
 */
public class Problem23 {
  public static void main(String[] args) {
    int limit = 28124;
    int[] abundants = findAllAbundantNumbers(limit);
    Set<Integer> sumsOfTwoAbundants = findAllSumsOfTwoAbundantNumbers(abundants);
    System.out.println(nonAbundantSum(sumsOfTwoAbundants, limit));
  }

  private static long nonAbundantSum(Set<Integer> sumsOfTwoAbundants, int limit) {
    return IntStream.range(1, limit).filter(i -> !sumsOfTwoAbundants.contains(i)).sum();
  }

  private static int[] findAllAbundantNumbers(int limit) {
    /*
    Set<Integer> abundants = Sets.newHashSet();
    for (int i = 12; i < limit; ++i) {
      if (isAbundant(i)) {
        abundants.add(i);
      }
    }
    int[] nums = new int[abundants.size()];
    int index = 0;
    for (Integer number : abundants) {
      nums[index++] = number;
    }
    return nums;
    */
    return IntStream.range(12, limit).filter(i -> isAbundant(i)).toArray();
  }

  private static boolean isAbundant(int number) {
    /*
    List<Integer> divisors = getDivisors(number);
    long sumOfDivisors = getSumOfDivisors(divisors);
    if (sumOfDivisors > number) {
      return true;
    }
    return false;
    */
    return (getSumOfDivisors(getDivisors(number)) > number);
  }

  private static Set<Integer> findAllSumsOfTwoAbundantNumbers(int[] abundantNumbers) {
    Set<Integer> sumsOfTwoAbundants = Sets.newHashSet();
    for (int i = 0; i < abundantNumbers.length; ++i) {
      for (int j = i; j < abundantNumbers.length; ++j) {
        sumsOfTwoAbundants.add(abundantNumbers[i] + abundantNumbers[j]);
      }
    }
    return sumsOfTwoAbundants;
  }
  private static List<Integer> getDivisors(int number) {
    List<Integer> divisors = Lists.newArrayList();
    divisors.add(1);
    for (int i = 2; i <= Math.sqrt(number); ++i) {
      if (number % i == 0) {
        int other = number / i;
        if (i != other) {
          divisors.add(i);
          divisors.add(other);
        } else {
          divisors.add(i);
        }
      }
    }
    return divisors;
  }

  private static long getSumOfDivisors(List<Integer> divisors) {
    return divisors.stream().mapToInt(Integer::intValue).sum();
  }
}
