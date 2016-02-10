package euler.level.zero;

/**
 * 10001st prime
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
 * we can see that the 6th prime is 13.
 *
 * What is the 10,001st prime number?
 *
 * @author smittyfest
 */
public class Problem7 {
  public static void main(String[] args) {
    int limit = 10001;
    long current = 1;
    int count = 0;
    for (long i = 2; count < limit && i < Long.MAX_VALUE; ++i) {
      if (isPrime(i)) {
        current = i;
        count++;
      }
    }
    System.out.println(current);
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
