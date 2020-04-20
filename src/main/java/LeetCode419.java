public class LeetCode419 {
  public int countBattleships(char[][] board) {
    if(board.length == 0) {
      return 0;
    }

    int ROW_MAX = board.length;
    int COL_MAX = board[0].length;
    int count = 0;
    for(int row = 0; row < ROW_MAX; row++) {
      for(int col = 0; col < COL_MAX; col++) {
        if(board[row][col] == 'X' && (row == 0 || board[row-1][col] != 'X') && (col == 0 || board[row][col-1] != 'X')) {
          count ++;
        }

      }
    }
    return count;
  }
}
