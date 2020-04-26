import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994 {
  public int orangesRotting(int[][] grid) {
    int ROW_MAX = grid.length;
    int COL_MAX = grid[0].length;
    Queue<Cell> cells = new LinkedList<>();
    int rottens = 0;
    int minutes = 0;
    int total = 0;
    int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};

    for(int row = 0; row < ROW_MAX; row++) {
      for(int col = 0; col < COL_MAX; col++) {
        if(grid[row][col] == 2) {
          cells.add(new Cell(row, col, grid[row][col]));
        }
        if(grid[row][col] != 0) {
          total++;
        }
      }
    }

    if(!cells.isEmpty()) {
      minutes = -1;
    }

    while(!cells.isEmpty()) {
      rottens = cells.size();

      for(int i = 0; i < rottens; i++) {
        Cell cell = cells.poll();
        total--;

        for(int[] dir : DIRS) {
          int row = cell.getRow() + dir[0];
          int col = cell.getCol() + dir[1];

          if(row < 0 || row > ROW_MAX - 1 || col < 0 || col > COL_MAX -1) {
            continue;
          }
          if(grid[row][col] ==1 ) {
            cells.add(new Cell(row, col));
            grid[row][col] = 2;
          }
        }

/*        if(cell.getRow() < ROW_MAX - 1 && grid[cell.getRow()+1][cell.getCol()] == 1) {
          cells.add(new Cell(cell.getRow()+1, cell.getCol()));
          grid[cell.getRow()+1][cell.getCol()] = 2;
        }

        if(cell.getRow() > 0 && grid[cell.getRow()-1][cell.getCol()] == 1) {
          cells.add(new Cell(cell.getRow()-1, cell.getCol()));
          grid[cell.getRow()-1][cell.getCol()] = 2;
        }

        if(cell.getCol() < COL_MAX - 1 && grid[cell.getRow()][cell.getCol()+1] == 1) {
          cells.add(new Cell(cell.getRow(), cell.getCol()+1));
          grid[cell.getRow()][cell.getCol()+1] = 2;
        }

        if(cell.getCol() > 0 && grid[cell.getRow()][cell.getCol()-1] == 1) {
          cells.add(new Cell(cell.getRow(), cell.getCol()-1));
          grid[cell.getRow()][cell.getCol()-1] = 2;
        }*/

      }
      minutes++;
    }

    return total != 0? -1:minutes;
  }
}

class Cell {
  private int row;
  private int col;
  private int status;

  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public Cell(int row, int col, int status) {
    this.row = row;
    this.col = col;
    this.status = status;
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

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}