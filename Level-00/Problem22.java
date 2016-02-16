package euler.level.zero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Names scores
 *
 * Using names.txt (right click and 'Save Link/Target As...'),
 * a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list
 * to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order,
 * COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th
 * name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 * @author smittyfest
 */
public class Problem22 {
  public static void main(String[] args) {

    Map<String, Integer> letterScores = Maps.newHashMap();
    letterScores.put("A", 1);
    letterScores.put("B", 2);
    letterScores.put("C", 3);
    letterScores.put("D", 4);
    letterScores.put("E", 5);
    letterScores.put("F", 6);
    letterScores.put("G", 7);
    letterScores.put("H", 8);
    letterScores.put("I", 9);
    letterScores.put("J", 10);
    letterScores.put("K", 11);
    letterScores.put("L", 12);
    letterScores.put("M", 13);
    letterScores.put("N", 14);
    letterScores.put("O", 15);
    letterScores.put("P", 16);
    letterScores.put("Q", 17);
    letterScores.put("R", 18);
    letterScores.put("S", 19);
    letterScores.put("T", 20);
    letterScores.put("U", 21);
    letterScores.put("V", 22);
    letterScores.put("W", 23);
    letterScores.put("X", 24);
    letterScores.put("Y", 25);
    letterScores.put("Z", 26);

    BufferedReader reader = new BufferedReader(new InputStreamReader(Thread.currentThread()
        .getContextClassLoader().getResourceAsStream("problem22.txt")));
    List<String> names = Lists.newArrayList();
    try {
      String line = "";
      while ((line = reader.readLine()) != null) {
        names.addAll(Arrays.asList(line.split(",")));
      }
    } catch (IOException e) {
      System.out.println("IOException occurred: " + e.getMessage());
    }

    Collections.sort(names);

    long totalNameScores = 0;
    for (String name : names) {
      int index = names.indexOf(name);
      name = name.replaceAll("^\"|\"$", "");
      totalNameScores += (getNameSum(name, letterScores) * (index + 1));
    }
    System.out.println(totalNameScores);
  }

  private static int getNameSum(String name, Map<String, Integer> letterScores) {
    int nameSum = 0;
    for (int i = 0; i < name.length(); ++i) {
      nameSum += letterScores.get(String.valueOf(name.charAt(i)));
    }
    return nameSum;
  }
}
