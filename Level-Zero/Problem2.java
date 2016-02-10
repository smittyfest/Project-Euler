package euler.level.zero;

/**
 * Even Fibonacci numbers
 *
 * Each new term in the Fibonacci sequence is generated by
 * adding the previous two terms. By starting with 1 and 2,
 * the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose
 * values do not exceed four million, find the sum of the
 * even-valued terms.
 * 
 * @author smittyfest
 */
public class Problem2 {
  public static void main(String[] args) {

    int limit = 4000000;

    int pred = 1;
    int succ = 2;
    int sum = 0;
    int next;

    while (pred <= 4000000) {
      if (pred % 2 == 0) {
        sum += pred;
      }
      next = pred + succ;
      pred = succ;
      succ = next;
    }
    System.out.println(sum);
  }
}
