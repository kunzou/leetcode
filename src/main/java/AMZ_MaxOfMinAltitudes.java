import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class AMZ_MaxOfMinAltitudes {

  public int minOfMinAltitudes(int[][] grid) {
    /*DP*/

    int ROW_MAX = grid.length;
    int COL_MAX = grid[0].length;
    int[][] maxMinValues = new int[ROW_MAX][COL_MAX];
    grid[0][0] = Integer.MAX_VALUE;
    grid[ROW_MAX - 1][COL_MAX - 1] = Integer.MAX_VALUE;
    maxMinValues[0][0] = Integer.MAX_VALUE;

    for (int row = 0; row < ROW_MAX; row++) {
      for (int col = 0; col < COL_MAX; col++) {
        if(row > 0 && col > 0) {
          maxMinValues[row][col] = Math.max(Math.min(maxMinValues[row-1][col], grid[row][col]), Math.min(maxMinValues[row][col-1], grid[row][col]));
        }
        else if (row > 0) {
          maxMinValues[row][col] = Math.min(maxMinValues[row-1][col], grid[row][col]);
        }
        else if (col > 0){
          maxMinValues[row][col] = Math.min(maxMinValues[row][col-1], grid[row][col]);
        }

      }
    }

    return maxMinValues[ROW_MAX-1][COL_MAX-1];
  }

/*  int minOfMinAltitudes(int[][] grid, int row, int col*//*, List<Integer> minValues*//*) {

    if(row == grid.length-1 && col == grid[0].length-1) {
      return grid[row][col];
    }

    if(row == grid.length-1) {
      return Math.min(grid[row][col], minOfMinAltitudes(grid, row, col+1));
    }

    if(col == grid[0].length-1) {
      return Math.min(grid[row][col], minOfMinAltitudes(grid, row+1, col));
    }

    return Math.min(Math.min(grid[row][col], minOfMinAltitudes(grid, row+1, col)),
        Math.min(grid[row][col], minOfMinAltitudes(grid, row, col+1)));
  }*/
/*    if(row == grid.length-1 && col == grid[0].length-1) {
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

  int maxValueOnAPath(int[][] grid, int row, int col, int max) {
    if(row == grid.length-1 && col == grid[0].length -1) {
      return Math.max(grid[row][col], max);
    }*/


  }

/*  public int minOfMinAltitudes(int[][] grid) {
    Queue<Grid> gridQueue = new LinkedList<>();
    int ROW_MAX = grid.length;
    int COL_MAX = grid[0].length;
    int[][] DIRS = {{0, 1}, {1,0}};
    
    gridQueue.add(new Grid(0,0,Integer.MAX_VALUE));
    List<Integer> minValues = new ArrayList<>();
    boolean[][] visited = new boolean[ROW_MAX][COL_MAX];
    while(!gridQueue.isEmpty()) {
      int size = gridQueue.size();

      for (int i = 0; i < size; i++) {
        Grid current = gridQueue.poll();

        for(int[] dir : DIRS) {
          int row = current.getRow() + dir[0];
          int col = current.getCol() + dir[1];

          if(row < 0 || row >= ROW_MAX || col < 0 || col >= COL_MAX) {
            continue;
          }
          if(!visited[row][col]) {
            gridQueue.add(new Grid(row, col, Math.min(current.getMin(), grid[row][col])));
          }
        }
      }
NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
    }
       
  }

}*/

