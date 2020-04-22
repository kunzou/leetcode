import java.util.*;

public class LeetCode763 {
  public List<Integer> partitionLabels(String S) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < S.length(); i++) {
      map.put(S.charAt(i), i);
    }

    List<Integer> results = new ArrayList<>();
    int maxLastOccurrence = map.get(S.charAt(0));
    int start = 0;
    for (int i = 0; i < S.length(); i++) {
      maxLastOccurrence = Math.max(maxLastOccurrence, map.get(S.charAt(i)));
      if(maxLastOccurrence == i) {
        results.add(i - start + 1);
        start = i + 1;
      }
    }
    return results;
  }
}
