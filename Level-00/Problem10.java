package euler.level.zero;

/**
 * Summation of primes
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * @author smittyfest
 */
public class Problem10 {
  public static void main(String[] args) {
    long sum = 0;
    for (long i = 2; i < 2000000; ++i) {
      if (isPrime(i)) {
        sum += i;
      }
    }
    System.out.println(sum);
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
