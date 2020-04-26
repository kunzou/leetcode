import org.redisson.misc.Hash;

import java.util.*;

/*Sliding window*/
public class AMZ_SubstringsOfSizeKWithKDistinctChars {
  public List<String> Count(String S, int k) {

    Set<String> result = new HashSet<>();
    Map<Character, Integer> hmap = new HashMap<>();

    for(int right = 0, left = 0; right < S.length(); right++) {
      char c = S.charAt(right);

      if(hmap.containsKey(c)) {
        left = Math.max(hmap.get(c), left);
      }

      if(right - left + 1 == k) {
        result.add(S.substring(left, right + 1));
        left++;  // meet a K candidate, update j immediately
      }
      hmap.put(c, right + 1);
    }

    return new ArrayList<>(result);
/*    int left = 0;
    int right = left + k - 1;
    LinkedList<Character> characters = new LinkedList<>();
    Map<Character, Integer> currentWord = new HashMap<>();
    Set<String> results = new HashSet<>();
    for (int i = 0; i < k; i++) {
      characters.add(S.charAt(i));
    }

    while(right < S.length()-1) {
      if(characters.size() == k && currentWord.size() == k) {
        results.add(S.substring(left, right+1));
      }
      characters.removeLast();
//      currentWord.put(S.charAt(left), );
      currentWord.put(S.charAt(left), currentWord.get(S.charAt(left) -1));
      if(currentWord.get(S.charAt(left)) == 0) {
        currentWord.remove(S.charAt(left));
      }
      left++;
      right++;
      characters.addFirst(S.charAt(right));
      currentWord.put(S.charAt(right), currentWord.getOrDefault(S.charAt(right), 0));
    }

    return new ArrayList<>(results);*/
  }
}
