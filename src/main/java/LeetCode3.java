import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode3 {
  public int lengthOfLongestSubstring(String s) {
    int index = 0;
    int countStart = 0;
    int maxLength = 0;
    Map<Character, Integer> charactersLocation = new HashMap<>();

    while(index < s.length()) {
      if (charactersLocation.containsKey(s.charAt(index))) {
        countStart = Math.max(charactersLocation.get(s.charAt(index)) + 1, countStart);
      }

      maxLength = Math.max(index - countStart + 1, maxLength);
      charactersLocation.put(s.charAt(index), index);
      index++;
    }
    return maxLength;
  }
}
