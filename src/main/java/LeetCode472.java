import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*trie
* interview
* */

public class LeetCode472 {

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> concatenated = new ArrayList<>();
    if (words == null || words.length <= 1) {
      return concatenated;
    }
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    for (String word : words) {
      if(isConcatenated(trie.getRoot(), trie.getRoot(), word,0)) {
        concatenated.add(word);
      }
    }
    return concatenated;
  }

  boolean isConcatenated(TrieNode root, TrieNode current, String word, int countConcatenatedWords) {
    if (word.isEmpty())
      return countConcatenatedWords >= 2;

    current = root;
    for (int i = 0; i < word.length(); i++) {
      if (!current.getChildren().containsKey(word.charAt(i))) {
        return false;
      }
      current = current.getChildren().get(word.charAt(i));

      if (current.isEnd()) {
        if (isConcatenated(root, current, word.substring(i+1),countConcatenatedWords + 1)) {
          return true;
        }
      }
    }

    return false;
  }

  boolean isConcatenated(TrieNode root, TrieNode current, String word, int index, int countConcatenatedWords) {
    if (index == word.length())
      return countConcatenatedWords >= 2;

    current = root;
    for (int i = index; i < word.length(); i++) {
      if (!current.getChildren().containsKey(word.charAt(i))) {
        return false;
      }
      current = current.getChildren().get(word.charAt(i));

      if (current.isEnd()) {
        if (isConcatenated(root, current, word, i + 1, countConcatenatedWords + 1)) {
          return true;
        }
      }
    }

    return false;
  }

/*  private int segments(TrieNode root, TrieNode current, String word, int index) {
    if (word == null || index >= word.length()) {
      return 0;
    }
    char ch = word.charAt(index);
    if (!current.getChildren().containsKey(ch)) {
      return 0;
    }

    int candidate1 = 0;
    if (current.getChildren().get(ch).isEnd()) {
      int recursive = segments(root, root, word, index + 1);
      candidate1 = recursive > 0 ? 1 + recursive : (index == word.length() - 1 ? 1 : 0);
    }
    if (candidate1 > 1) {
      return candidate1;
    }

    int candidate2 = segments(root, current.getChildren().get(ch), word, index + 1);

    return Math.max(candidate1, candidate2);
  }*/


}
