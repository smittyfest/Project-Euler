package euler.level.zero;

/**
 * Number letter counts
 *
 * If the numbers 1 to 5 are written out in words:
 * one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive
 * were written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342
 * (three hundred and forty-two) contains 23 letters and 115
 * (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance
 * with British usage.
 *
 * @author smittyfest
 */
public class Problem17 {
  public static void main(String[] args) {

    long sum = 0;

    sum += "onetwothreefourfivesixseveneightnineteneleventwelve".length();
    sum += "thirteenfourteenfifteensixteenseventeeneighteennineteen".length();

    sum += "twenty".length() * 10;
    sum += "thirty".length() * 10;
    sum += "forty".length() * 10;
    sum += "fifty".length() * 10;
    sum += "sixty".length() * 10;
    sum += "seventy".length() * 10;
    sum += "eighty".length() * 10;
    sum += "ninety".length() * 10;

    sum += "onetwothreefourfivesixseveneightnine".length() * 8;

    sum += "onehundred".length() * 100;
    sum += "twohundred".length() * 100;
    sum += "threehundred".length() * 100;
    sum += "fourhundred".length() * 100;
    sum += "fivehundred".length() * 100;
    sum += "sixhundred".length() * 100;
    sum += "sevenhundred".length() * 100;
    sum += "eighthundred".length() * 100;
    sum += "ninehundred".length() * 100;

    sum += "onetwothreefourfivesixseveneightnineteneleventwelve".length() * 9;
    sum += "thirteenfourteenfifteensixteenseventeeneighteennineteen".length() * 9;

    sum += "twenty".length() * 10 * 9;
    sum += "thirty".length() * 10 * 9;
    sum += "forty".length() * 10 * 9;
    sum += "fifty".length() * 10 * 9;
    sum += "sixty".length() * 10 * 9;
    sum += "seventy".length() * 10 * 9;
    sum += "eighty".length() * 10 * 9;
    sum += "ninety".length() * 10 * 9;

    sum += "onetwothreefourfivesixseveneightnine".length() * 8 * 9;

    sum += "and".length() * 99 * 9;

    sum += "onethousand".length();

    System.out.println(sum);
  }
}
