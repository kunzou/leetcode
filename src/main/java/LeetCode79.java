import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode79 {
  public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[0].length; col++) {
        if(board[row][col] == word.charAt(0) && findWord(board, word, 0, row, col, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean findWord(char[][] board, String word, int index, int row, int col, boolean[][] visited) {
    if(index == word.length()) {
      return true;
    }

    if(row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || visited[row][col] || board[row][col] != word.charAt(index)) {
      return false;
    }

    visited[row][col] = true;

    if(
        findWord(board, word, index + 1, row + 1, col, visited)
        || findWord(board, word, index + 1, row - 1, col, visited)
        || findWord(board, word, index + 1, row, col + 1, visited)
        || findWord(board, word, index + 1, row, col - 1, visited)) {
      return true;
    }

    visited[row][col] = false;
    return false;




/*    if(board[row][col] != word.charAt(index)) {
      visited[row][col] = false;
      return false;
    }
    visited[row][col] = true;

    if(index == word.length() - 1 && board[row][col] == word.charAt(index)) {
      return true;
    }

    int[][] DIRECTION = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    for(int[] dir : DIRECTION) {
      int nextRow = row + dir[0];
      int nextCol = col + dir[1];
      if(nextRow < 0 || nextRow > board.length - 1 || nextCol < 0 || nextCol > board[0].length - 1 || visited[nextRow][nextCol]) {
        continue;
      }

      if(findWord(board, word, index+1, nextRow, nextCol, visited)) {
        return true;
      }
    }
    visited[row][col] = false;
    return false;*/
  }
}
