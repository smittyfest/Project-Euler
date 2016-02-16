package euler.level.zero;

import java.math.BigInteger;

/**
 * Power digit sum
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * @author smittyfest
 */
public class Problem16 {
  public static void main(String[] args) {
    int limit = 1000;
    long number = 2;
    BigInteger product = BigInteger.ONE;
    for (int i = limit; i > 0; --i) {
      product = product.multiply(BigInteger.valueOf(number));
    }
    System.out.println(product);
    String val = product.toString();
    int[] vals = new int[val.length()];
    for (int i = 0; i < val.length(); ++i) {
      vals[i] = Integer.parseInt(String.valueOf(val.charAt(i)));
    }
    long sum = 0;
    for (int i = 0; i < vals.length; ++i) {
      sum += vals[i];
    }
    System.out.println(sum);
  }
}
