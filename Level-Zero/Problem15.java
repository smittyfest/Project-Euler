package euler.level.zero;

import java.math.BigInteger;

/**
 * Lattice paths
 *
 * Starting in the top left corner of a 2×2 grid,
 * and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * @author smittyfest
 */
public class Problem15 {
  public static void main(String[] args) {

    int n = 20;
    System.out.println(getPaths(n));
  }

  /**
   * How many different strings of size 2×n, consisting of n Rs and n Ds, are there?
   *
   * n x n grid
   * each path is of length 2n
   * also, each path must have equal number of right
   * moves and down moves.
   * Therefore, how many permutations of string of r,d
   * of length 2n, with equal number of rs and ds.
   */
  private static BigInteger getPaths(long n) {
    BigInteger top = factorial(2 * n);
    BigInteger bottom = (factorial(n).multiply(factorial(n)));
    return top.divide(bottom);
  }

  private static BigInteger factorial(long n) {
    BigInteger product = BigInteger.ONE;
    for (long i = n; i > 1; --i) {
      product = product.multiply(BigInteger.valueOf(i));
    }
    return product;
  }
}
