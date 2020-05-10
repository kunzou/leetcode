import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode212 {
  public List<String> findWords(char[][] board, String[] words) {
    Set<String> result = new HashSet<>();
    Trie trie = new Trie();
    for(String word : words) {
      trie.insert(word);
    }

    TrieNode root = trie.root;
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        searchForWord(board, row, col, root, "", result, new boolean[board.length][board[0].length]);
      }
    }
    return new ArrayList<>(result);
  }

  private void searchForWord(char[][] board, int row, int col, TrieNode node, String word, Set<String> results, boolean[][] visited) {
    if(row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1 || node.getChildren()[board[row][col] - 'a'] == null || visited[row][col]) {
      return;
    }
    word = word + board[row][col];
    node = node.getChildren()[board[row][col] - 'a'];
    if(node.isEndOfWord()) {
      results.add(word);
    }
    visited[row][col] = true;
    searchForWord(board, row + 1, col, node, word, results, visited);
    searchForWord(board, row - 1, col, node, word, results, visited);
    searchForWord(board, row, col + 1, node, word, results, visited);
    searchForWord(board, row, col - 1, node, word, results, visited);
    visited[row][col] = false;
  }

  class Trie {
    private final TrieNode root;

    public Trie() {
      this.root = new TrieNode('!');
    }

    public void insert(String word) {
      TrieNode node = root;
      for(Character character : word.toCharArray()) {
        if(node.getChildren()[character - 'a'] == null) {
          node.getChildren()[character - 'a'] = new TrieNode(character);
        }
        node = node.getChildren()[character - 'a'];
      }
      node.setEndOfWord(true);
    }

    public boolean contains(String word) {
      TrieNode node = root;
      for(char character : word.toCharArray()) {
        if(node.getChildren()[character - 'a'] != null) {
          node = node.getChildren()[character - 'a'];
        }
        else {
          return false;
        }
      }
      return true;
    }

  }

  class TrieNode {
    private char character;
    private TrieNode[] children;
    private boolean endOfWord;

    public TrieNode(Character character) {
      this.character = character;
      children = new TrieNode[26];
    }

    public char getCharacter() {
      return character;
    }

    public void setCharacter(char character) {
      this.character = character;
    }

    public TrieNode[] getChildren() {
      return children;
    }

    public boolean isEndOfWord() {
      return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
      this.endOfWord = endOfWord;
    }
  }

/*  private boolean findWord(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
    if (index == word.length()) {
      return true;
    }

    if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || visited[row][col] || board[row][col] != word.charAt(index)) {
      return false;
    }

    visited[row][col] = true;

    if (
        findWord(board, word, index + 1, row + 1, col, visited)
            || findWord(board, word, index + 1, row - 1, col, visited)
            || findWord(board, word, index + 1, row, col + 1, visited)
            || findWord(board, word, index + 1, row, col - 1, visited)) {
      return true;
    }

    visited[row][col] = false;
    return false;
  }*/
}
