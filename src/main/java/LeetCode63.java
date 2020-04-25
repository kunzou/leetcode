import sun.util.resources.cldr.ka.LocaleNames_ka;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    /*Dynamic Programming*/
    int ROW_MAX = obstacleGrid.length;
    int COL_MAX = obstacleGrid[0].length;
    int[][] pathsCount = new int[ROW_MAX][COL_MAX];
    pathsCount[0][0] = 1;

    for (int row = 0; row < ROW_MAX; row++) {
      for (int col = 0; col < COL_MAX; col++) {
        if(obstacleGrid[row][col] == 1) {
          pathsCount[row][col] = 0;
        }
        else if(row > 0 && col > 0) {
          pathsCount[row][col] = pathsCount[row-1][col] + pathsCount[row][col-1];
        }
        else if (row > 0) {
          pathsCount[row][col] = pathsCount[row-1][col];
        }
        else if (col > 0){
          pathsCount[row][col] = pathsCount[row][col-1];
        }
      }
    }
    return pathsCount[ROW_MAX-1][COL_MAX-1];
  }
}

/* TIME OUT
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid.length == 0) {
      return 0;
    }

    if(obstacleGrid[0][0] == 1) {
      return 0;
    }

    int ROW_MAX = obstacleGrid.length;
    int COL_MAX = obstacleGrid[0].length;
    Queue<Grid> grids = new LinkedList<>();
    int path = 0;
    grids.add(new Grid(0, 0));

    while(!grids.isEmpty()) {
      int size = grids.size();

      for(int i = 0; i < size; i++) {
        Grid cell = grids.poll();

        if(cell.getRow() == ROW_MAX - 1 && cell.getCol() == COL_MAX - 1) {
          path++;
        }

        if(cell.getRow() < ROW_MAX - 1 && obstacleGrid[cell.getRow()+1][cell.getCol()] != 1) {
          grids.add(new Grid(cell.getRow()+1, cell.getCol()));
        }

        if(cell.getCol() < COL_MAX - 1 && obstacleGrid[cell.getRow()][cell.getCol()+1] != 1) {
          grids.add(new Grid(cell.getRow(), cell.getCol()+1));
        }
      }
    }
    return path;
  }*/

class Grid {
  private int row;
  private int col;

  public Grid(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }
}