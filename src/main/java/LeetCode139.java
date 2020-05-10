import java.util.*;

/*trie
* interview
* */
public class LeetCode139 {
  public boolean wordBreak(String s, List<String> wordDict) {
    Trie trie = new Trie();
    for (String word : wordDict) {
      trie.insert(word);
    }
    HashMap<String, Boolean> memo = new HashMap<>();
    return canBreak(s, trie, memo);
  }

  private boolean canBreak(String s, Trie trie, HashMap<String, Boolean> memo) {
    if (memo.containsKey(s)) {
      return memo.get(s);
    }

    for (int i = 1; i <= s.length(); i++) {
      TrieNode trieNode = trie.searchNode(s.substring(0, i)).orElse(null);
      if (trieNode != null) {
        if (trieNode.isEnd()) {
          if (i == s.length() || canBreak(s.substring(i), trie, memo)) {
            memo.put(s, true);
            return true;
          }
        }
      }
      else {
        memo.put(s, false);
        return false;
      }
    }
    memo.put(s, false);
    return false;
  }


/*  public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> dictionary = new HashSet<>(wordDict);
    Map<String, Boolean> memory = new HashMap<>();
    return isInDictionary(s, dictionary, memory);
  }

  boolean isInDictionary(String word, Set<String> dictionary, Map<String, Boolean> memory) {
    if(memory.get(word) != null) {
      return memory.get(word);
    }

    if(dictionary.contains(word)) {
      memory.put(word, true);
      return true;
    }

    for(int i = 1; i < word.length(); i++) {
      String left = word.substring(0, i);
      String right = word.substring(i);
      if(isInDictionary(left, dictionary, memory) && isInDictionary(right, dictionary, memory)){
        memory.put(word, true);
        return true;
      }
    }

    memory.put(word, false);
    return false;
  }*/

}

class Trie {
  private TrieNode root;

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode currentNode = this.root;
    for(Character character : word.toLowerCase().toCharArray()) {
      currentNode.getChildren().computeIfAbsent(character, (key) -> new TrieNode());
      currentNode = currentNode.getChildren().get(character);
    }
    currentNode.setEnd(true);
  }

  public boolean search(String word) {
    return searchNode(word).map(TrieNode::isEnd).orElse(false);
  }

  public boolean startWith(String word) {
    return searchNode(word).isPresent();
  }

  public Optional<TrieNode> searchNode(String word) {
    TrieNode trieNode = this.root;

    for(Character character : word.toLowerCase().toCharArray()) {
      trieNode = trieNode.getChildren().get(character);
      if(trieNode == null) {
        return Optional.empty();
      }
    }
    return Optional.of(trieNode);
  }

  public TrieNode getRoot() {
    return root;
  }
}


class TrieNode {
  private HashMap<Character, TrieNode> children;
  private boolean end;

  public TrieNode() {
    this.children = new HashMap<>();
  }

  public HashMap<Character, TrieNode> getChildren() {
    return children;
  }

  public void setChildren(HashMap<Character, TrieNode> children) {
    this.children = children;
  }

  public boolean isEnd() {
    return end;
  }

  public void setEnd(boolean end) {
    this.end = end;
  }
}
