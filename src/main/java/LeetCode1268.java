import java.util.*;
import java.util.stream.Collectors;

public class LeetCode1268 {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    Trie root = new Trie();

    for(String p: products) {
      Trie node = root;
      for(char c: p.toCharArray()) {
        int idx = c-'a';
        if(node.links[idx]==null) {
          node.links[idx] = new Trie();
        }
        node = node.links[idx];
        if(node.words.size()<3) {
          node.words.add(p);
        }
      }
    }

    List<List<String>> ans = new ArrayList<>();
    Trie node = root;
    for(int i=0;i<searchWord.length();i++) {
      char c = searchWord.charAt(i);
      node = node.links[c-'a'];
      if(node==null) {
        for(int j=i;j<searchWord.length();j++) {
          ans.add(new ArrayList<>());
        }
        break;
      }
      ans.add(node.words);
    }
    return ans;
  }

  class Trie {
    Trie[] links;
    List<String> words;

    public Trie() {
      words = new ArrayList();
      links = new Trie[26];
    }
  }
}


/*
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie dictionary = new Trie();

    for (String product : products) {
      dictionary.insert(product);
    }

    List<List<String>> results = new ArrayList<>();
    String searchTerm = "";
    for(Character character: searchWord.toLowerCase().toCharArray()) {
      searchTerm = String.format("%s%c", searchTerm, character);
      results.add(dictionary.getWordsStartWith(searchTerm, 3));
    }

    System.out.println(results);

    return results;
  }
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

  public List<String> getWordsStartWith(String word, int number) {
    Optional<TrieNode> trieNode = searchNode(word);
    List<String> result = new ArrayList<>();
    if(trieNode.isPresent()) {
      getWords(trieNode.get(), number, word.chars().mapToObj(e->(char)e).collect(Collectors.toList()), result);
    }

    return result;
  }

  private void getWords(TrieNode trieNode, int number, List<Character> characters, List<String> results) {
    if(trieNode.isEnd()) {
      results.add(characters.stream().map(String::valueOf).collect(Collectors.joining()));
    }

    if(trieNode.getChildren().isEmpty() || results.size() == number) {
      return;
    }

    for(Map.Entry<Character, TrieNode> entry :trieNode.getChildren().entrySet()) {
      List<Character> chars = new ArrayList<>(characters);
      chars.add(entry.getKey());
      getWords(entry.getValue(), number, chars, results);
      if(results.size() == 3) {
        return;
      }
    }
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

*/
