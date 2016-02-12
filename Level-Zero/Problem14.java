package euler.level.zero;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Longest Collatz sequence
 *
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * https://xkcd.com/710/
 *
 * @author smittyfest
 */
public class Problem14 {
  public static void main(String[] args) {
    long limit = 1000000;
    long maxStartingNumber = 0;
    long maxSequenceSize = 0;
    for (Long i = 1L; i < limit; ++i) {
      List<Long> collatzSequence = getCollatzSequence(i);
      if (collatzSequence.size() > maxSequenceSize) {
        maxSequenceSize = collatzSequence.size();
        maxStartingNumber = i;
      }
    }
    System.out.println("The starting number that produces the longest chain is: " +
        maxStartingNumber);
    System.out.println("The length of the chain is: " + maxSequenceSize);
  }

  private static List<Long> getCollatzSequence(long n) {
    List<Long> collatzSequence = Lists.newArrayList();
    collatzSequence.add(n);
    while (n > 1) {
      if (n % 2 == 0) {
        n = n / 2;
        collatzSequence.add(n);
      } else {
        n = (3 * n) + 1;
        collatzSequence.add(n);
      }
    }
    return collatzSequence;
  }
}
