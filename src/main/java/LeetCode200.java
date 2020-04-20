import java.util.Collection;

public class LeetCode200 {

  public int numIslands(char[][] grid) {
    if(grid.length == 0) {
      return 0;
    }
    int ROW_MAX = grid.length;
    int COL_MAX = grid[0].length;
    int count = 0;
    for(int row = 0; row < ROW_MAX; row++) {
      for (int col = 0; col < COL_MAX; col++) {
        if(grid[row][col] == '1') {
          exploreIsland(grid, row, col);
          count++;
        }
      }
    }

    return count;
  }

  private void exploreIsland(char[][]grid, int row, int col) {
    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
      return;
    }

    grid[row][col] = '0';

    exploreIsland(grid, row+1, col);
    exploreIsland(grid, row - 1, col);
    exploreIsland(grid, row, col - 1);
    exploreIsland(grid, row, col + 1);
  }

  public int THIS_WONT_WORK_numIslands(char[][] grid) {
    if(grid.length == 0) {
      return 0;
    }
    int ROW_MAX = grid.length;
    int COL_MAX = grid[0].length;
    Integer[][] seen = new Integer[ROW_MAX][COL_MAX];
    int count = 0;
    int marker = 0;
    int cur_marker = 0;
    for(int row = 0; row < ROW_MAX; row++) {
      for(int col = 0; col < COL_MAX; col++) {

        if(grid[row][col] == '1') {

          if (seen[row][col] == null) {
            count++;
            marker++;
            seen[row][col] = marker;
            cur_marker = marker;
          }
          else {
            cur_marker = seen[row][col];
          }

          if (row < ROW_MAX - 1 && grid[row + 1][col] == '1') {
            seen[row + 1][col] = cur_marker;
          }

          if(col < COL_MAX - 1 && grid[row][col+1] == '1' && seen[row][col + 1]!= null && !seen[row][col + 1].equals(seen[row][col])) {
            count --;
            for(int i = 0; i < row-1; i++) {
              for(int j=0; j < col-1; j++) {
                if(seen[i][j] != null && seen[i][j].equals(seen[row][col])) {
                  seen[i][j] = seen[row][col+1];
                }
              }
            }
            seen[row][col] = seen[row][col+1];
          }
          else if (col < COL_MAX - 1 && grid[row][col + 1] == '1' && seen[row][col + 1] == null) {
            seen[row][col + 1] = cur_marker;
          }
        }
      }
    }
    return count;
  }
}
