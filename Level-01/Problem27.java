package euler.level.one;

/**
 * Quadratic primes
 *
 * Euler discovered the remarkable quadratic formula:
 *
 * n² + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive values
 * n = 0 to 39. However, when n = 40, 40² + 40 + 41 = 40(40 + 1) + 41 is divisible by 41,
 * and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 *
 * The incredible formula  n² − 79n + 1601 was discovered, which produces 80 primes
 * for the consecutive values n = 0 to 79. The product of the coefficients,
 * −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 *
 * n² + an + b, where |a| < 1000 and |b| < 1000
 *
 * where |n| is the modulus/absolute value of n, e.g. |11| = 11 and |−4| = 4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression that
 * produces the maximum number of primes for consecutive values of n, starting with n = 0.
 *
 * @author smittyfest
 */
public class Problem27 {
  public static void main(String[] args) {
    int maxConsecutivePrimeCount = 0;
    int productOfMax = 1;
    int a = 0;
    int b = 0;
    for (int i = -999; i < 1000; ++i) {
      for (int j = -999; j < 1000; ++j) {
        int count = countConsecutivePrimes(i, j);
        if (count > maxConsecutivePrimeCount) {
          maxConsecutivePrimeCount = count;
          productOfMax = i * j;
          a = i;
          b = j;
        }
      }
    }
    System.out.println("Max consecutive prime count: " + maxConsecutivePrimeCount);
    System.out.println("a = " + a + ", b = " + b);
    System.out.println("Product of max a and b: " + productOfMax);
  }

  private static int countConsecutivePrimes(int a, int b) {
    int count = 0;
    for (int i = 0; i < Integer.MAX_VALUE; ++i) {
      long n = (i * i) + (i * a) + b;
      if (n < 0 || !isPrime(n)) {
        return i;
      }
    }
    return count;
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
