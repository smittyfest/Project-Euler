package euler.level.zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Maximum path sum
 *
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 *               75
 *              95 64
 *             17 47 82
 *            18 35 87 10
 *           20 04 82 47 65
 *          19 01 23 75 03 34
 *         88 02 77 73 07 63 67
 *        99 65 04 28 06 16 70 92
 *       41 41 26 56 83 40 80 70 33
 *      41 48 72 33 47 32 37 16 94 29
 *     53 71 44 65 25 43 91 52 97 51 14
 *    70 11 33 28 77 73 17 78 39 68 17 57
 *   91 71 52 38 17 14 91 43 58 50 27 29 48
 *  63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve
 * this problem by trying every route. However, Problem 67,
 * is the same challenge with a triangle containing one-hundred rows;
 * it cannot be solved by brute force, and requires a clever method! ;o)
 *
 * @author smittyfest
 */
public class Problem18 {
  public static void main(String[] args) {

    // Populate a 2-dimensional array with the integers
    int size = 15;
    int[][] numbers = new int[size][size];
    BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread()
        .getContextClassLoader().getResourceAsStream("problem18.txt")));

    String line = "";
    try {
      int row = 0;
      while ((line = reader.readLine()) != null) {
        String[] nums = line.split(" ");
        for (int column = 0; column < nums.length; ++column) {
          numbers[row][column] = Integer.parseInt(nums[column]);
        }
        row++;
      }
    } catch (IOException e) {
      System.out.println("IOException occurred: " + e.getMessage());
    }

    for (int i = size - 1; i > 0; --i) {
      for (int j = 0; j <= i; ++j) {
        if (i > 0 && j < i) {
          numbers[i - 1][j] = getMaxPath(numbers[i][j], numbers[i][j + 1], numbers[i - 1][j]);
        }
      }
    }
    System.out.println(numbers[0][0]);
  }

  private static int getMaxPath(int first, int second, int nextNode) {
    return ((first + nextNode) > (second + nextNode) ? (first + nextNode) : (second + nextNode));
  }
}
