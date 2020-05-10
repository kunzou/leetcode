import java.util.HashMap;
import java.util.Optional;

public class LeetCode208 {
  /*Trie see 1268*/
}

/*
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

  private Optional<TrieNode> searchNode(String word) {
    TrieNode trieNode = this.root;

    for(Character character : word.toLowerCase().toCharArray()) {
      trieNode = trieNode.getChildren().get(character);
      if(trieNode == null) {
        return Optional.empty();
      }
    }
    return Optional.of(trieNode);
  }
}


class TrieNode {
  private HashMap<Character, TrieNode> children;
  private boolean isEnd;

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
    return isEnd;
  }

  public void setEnd(boolean end) {
    isEnd = end;
  }
}*/
