package euler.level.zero;

/**
 * Largest prime factor
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author smittyfest
 */
public class Problem03 {
  public static void main(String[] args) {
    Long target = 600851475143L;
    System.out.println(findMaxPrimeFactor(target));
  }

  private static Long findMaxPrimeFactor(Long target) {
    Double sqrt = target.doubleValue();
    Long max = 0L;
    for (int i = 2; i <= sqrt; ++i) {
      if (target % i == 0) {
        max = target / i;
        if (isPrime(max)) {
          return max;
        } else {
          max = Long.valueOf(i);
        }
      }
    }
    return max;
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
