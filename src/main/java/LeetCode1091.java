import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1091 {
  public int shortestPathBinaryMatrix(int[][] grid) {
    if(grid.length == 0) {
      return -1;
    }

    if(grid[grid.length-1][grid[0].length-1] == 1) {
      return -1;
    }

    if(grid.length == 1) {
      for (int i = 0; i < grid[0].length; i++) {
        if(grid[0][i] == 1) {
          return -1;
        }
      }
      return grid[0].length;
    }

    Queue<int[]> cells = new LinkedList<>();
    boolean[][] isVisited = new boolean[grid.length][grid[0].length];
    int[][] DIRECTIONS = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0},
        {1,1},
        {-1,-1},
        {1,-1},
        {-1,1}
    };
    int steps = 0;
    if(grid[0][0] != 1) {
      cells.add(new int[]{0, 0});
    }

    while(!cells.isEmpty()) {
      int size = cells.size();
      steps++;

      for(int i = 0; i < size; i++) {
        int[] cell = cells.poll();

        for(int[] dir : DIRECTIONS) {
          int row = cell[0] + dir[0];
          int col = cell[1] + dir[1];

          if(row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length -1 || isVisited[row][col] || grid[row][col]==1) {
            continue;
          }

          if(row == grid.length-1 && col == grid[0].length-1) {
            return steps + 1;
          }

          cells.add(new int[]{row, col});
          isVisited[row][col] = true;

        }
      }
    }

    return -1;
  }
}
