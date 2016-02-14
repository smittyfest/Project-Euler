package euler.level.zero;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * Lexicographic permutations
 *
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 * @author smittyfest
 */
public class Problem24 {
  public static void main(String[] args) {
    String s = "0123456789";
    List<String> permutations = generateAllPermutations(s);
    System.out.println(permutations.get(999999));
  }

  /**
   * "Generating All Permutations",
   * The Art of Computer Programming, Volume 4A,
   * Combinatorial Algorithms, Part 1,
   * By Donald E. Knuth
   *
   * @param s a sequence of characters
   * @return a list of all the permutations of s in lexicographic ordering
   */
  private static List<String> generateAllPermutations(String s) {
    List<String> permutations = Lists.newArrayList();
    if (s.length() <= 1) {
      permutations.add(s);
      return permutations;
    }
    char[] original = s.toCharArray();
    Arrays.sort(original);
    permutations.add(new String(original));

    while (true) {
      int j = original.length - 2;
      while (original[j] >= original[j + 1]) {
        if (j == 0) {
          return permutations;
        }
        j--;
      }
      int last = original.length - 1;
      while (original[j] >= original[last]) {
        --last;
      }
      swap(original, j, last);
      int k = j + 1;
      last = original.length - 1;
      while (k < last) {
        swap(original, k, last);
        ++k;
        --last;
      }
      permutations.add(new String(original));
    }
  }

  private static void swap(char[] data, int i, int j) {
    char tmp = data[i];
    data[i] = data[j];
    data[j] = tmp;
  }
}
