import org.apache.commons.lang3.tuple.MutablePair;

import java.util.ArrayList;
import java.util.List;

public class LeetCode474 {
  public int findMaxForm(String[] strs, int m, int n) {
    return findMaxForm(strs, 0, m, n, new ArrayList<>());
  }

  int findMaxForm(String[] strings, int index, int numberOfZero, int numberOfOne, List<String> result) {
    if(numberOfOne == 0 && numberOfZero == 0) {
      return result.size();
    }

    if(index == strings.length && (numberOfOne > 0 || numberOfZero > 0)) {
      return result.size();
    }

    if(numberOfOne < 0 || numberOfZero < 0) {
      return 0;
    }

    int[] count = count(strings[index]);
    List<String> plusString = new ArrayList<>(result);
    plusString.add(strings[index]);
    return Math.max(findMaxForm(strings, index + 1, numberOfZero - count[0], numberOfOne - count[1], plusString),
        findMaxForm(strings, index + 1, numberOfZero, numberOfOne, result));
  }

  int[] count(String string) {
    int[] counter = {0,0};
    for (int i = 0; i < string.length(); i++) {
      if(string.charAt(i) == '0') {
        counter[0] ++;
      }
      else {
        counter[1] ++;
      }
    }
    return counter;
  }
}
