package euler.level.zero;

/**
 * Special Pythagorean triplet
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c,
 * for which:
 *
 * a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 *
 * Find the product a * b * c.
 *
 * @author smittyfest
 */
public class Problem9 {
  public static void main(String[] args) {
    for (int first = 1; first < 1000; ++first) {
      for (int second = first; second < 1000; ++second) {
        for (int third = second; third < 1000; ++ third) {
          if (isPythagoreanTriplet(first, second, third) && sumEquals1000(first, second, third)) {
            System.out.println(first + ", " + second + ", " + third);
            System.out.println(product(first, second, third));
            System.exit(0);
          }
        }
      }
    }
  }

  private static boolean isPythagoreanTriplet(int first, int second, int third) {
    return (Math.pow(first, 2) + Math.pow(second, 2) == Math.pow(third, 2));
  }

  private static boolean sumEquals1000(int first, int second, int third) {
    return ((first + second + third) == 1000);
  }

  private static long product(int first, int second, int third) {
    return first * second * third;
  }
}
