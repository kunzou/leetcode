public class LeetCode64 {
  public int minPathSum(int[][] grid) {
    Integer[][] cache = new Integer[grid.length][grid[0].length];
    return calMin(grid, 0, 0, cache);
  }

  public int calMin(int[][] grid, int row, int col, Integer[][] cache) {
    if(cache[row][col] != null) {
      return cache[row][col];
    }

    if(row == grid.length-1 && col == grid[0].length-1) {
      cache[row][col] = grid[row][col];
      return cache[row][col];
    }

    if(row == grid.length-1) {
      cache[row][col] = grid[row][col]+calMin(grid, row, col+1, cache);
      return cache[row][col];
    }

    if(col == grid[0].length-1) {
      cache[row][col] = grid[row][col]+calMin(grid, row+1, col, cache);
      return cache[row][col];
    }

    cache[row][col] = grid[row][col] + Math.min(calMin(grid, row+1, col, cache), calMin(grid, row, col+1, cache));
    return cache[row][col];
  }
/*  public int minPathSum(int[][] grid) {
    int ROW_MAX = grid.length;
    int COL_MAX = grid[0].length;
    int[][] sumMap = new int[ROW_MAX][COL_MAX];

    sumMap[0][0] = grid[0][0];
    for(int row = 0; row < ROW_MAX; row++) {
      for (int col = 0; col < COL_MAX; col++) {
        if(row > 0 && col >0) {
          sumMap[row][col] = grid[row][col] + Math.min(sumMap[row-1][col], sumMap[row][col-1]);
        }
        else if(row == 0 && col > 0) {
          sumMap[row][col] = grid[row][col]+sumMap[row][col-1];
        }
        else if(row > 0) {
          sumMap[row][col] = grid[row][col]+sumMap[row-1][col];
        }
      }
    }
    return sumMap[ROW_MAX-1][COL_MAX-1];
  }*/
}
