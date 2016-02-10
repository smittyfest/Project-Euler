package euler.level.zero;

/**
 * Largest palindrome product
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two
 * 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
  public static void main(String[] args) {
    long result;
    long max = 0;
    for (int i = 999; i > 0; --i) {
      for (int j = i; j > 0; --j) {
        result = i * j;
        if (isPalindrome(result) && result > max) {
          max = result;
        }
      }
    }
    System.out.println(max);
  }

  private static boolean isPalindrome(long number) {
    char[] digits = String.valueOf(number).toCharArray();
    for (int first = 0, last = digits.length - 1; first < last; ++first, --last) {
      if (digits[first] != digits[last]) {
        return false;
      }
    }
    return true;
  }
}
