import java.util.HashMap;
import java.util.Map;

public class LeetCode953 {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> dictionary = new HashMap<>();
    int index = 0;
    int dictionaryIndex = -1;
    for(int i = 0; i < order.length(); i++) {
      dictionary.put(order.charAt(i), i);
    }

    for(int i = 1; i < words.length; i++) {
      if(!compare(words[i-1], words[i], dictionary)) {
        return false;
      }
    }
    return true;

  }

  private boolean compare(String word1, String word2, Map<Character, Integer> dictionary) {
    int index = 0;

    while(index < word1.length() && index < word2.length()) {
      if(dictionary.get(word1.charAt(index)) > dictionary.get(word2.charAt(index))) {
        return false;
      }
      index++;
    }
    return true;

  }
}
