import java.util.LinkedList;
import java.util.Queue;

public class LeetCode542 {
  public int[][] updateMatrix(int[][] matrix) {
    int MAX_ROW = matrix.length;
    int MAX_COL = matrix[0].length;
    int result[][] = new int[MAX_ROW][MAX_COL];

    for (int row = 0; row < MAX_ROW; row++) {
      for (int col = 0; col < MAX_COL; col++) {
        result[row][col] = Integer.MAX_VALUE;
      }
    }

    for (int row = 0; row < MAX_ROW; row++) {
      for (int col = 0; col < MAX_COL; col++) {
        if(matrix[row][col] == 0) {
          result[row][col] = 0;
        }
        else {
          if(row > 0) {
            result[row][col] = Math.min(result[row][col], result[row-1][col] + 1);
          }
          if(col > 0) {
            result[row][col] = Math.min(result[row][col], result[row][col-1] + 1);
          }
        }
      }
    }

    for (int row = 0; row < MAX_ROW; row++) {
      for (int col = 0; col < MAX_COL; col++) {
        if(matrix[row][col] != 0) {
          if(row < MAX_ROW - 1) {
            result[row][col] = Math.min(result[row][col], result[row+1][col] + 1);
          }
          if(col < MAX_COL - 1) {
            result[row][col] = Math.min(result[row][col], result[row][col+1] + 1);
          }
        }
      }
    }

    return result;
  }

  public int[][] updateMatrix_bfs(int[][] matrix) {
    Queue<Cell> cells = new LinkedList<>();
    int MAX_ROW = matrix.length;
    int MAX_COL = matrix[0].length;
    int result[][] = new int[MAX_ROW][MAX_COL];
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int size;
    for (int row = 0; row < MAX_ROW; row++) {
      for (int col = 0; col < MAX_COL; col++) {
        if(matrix[row][col] == 1 && isConnectedToZeros(row, col, matrix)) {
          cells.add(new Cell(row, col));
        }
        if(matrix[row][col] == 0) {
          result[row][col] = 0;
        }
        else {
          result[row][col] = -1;
        }
      }
    }
    int steps = 0;
    while(!cells.isEmpty()) {
      steps ++;
      size = cells.size();
      for (int i = 0; i < size; i++) {
        Cell cell = cells.poll();
        if(result[cell.getRow()][cell.getCol()] == -1) {
          result[cell.getRow()][cell.getCol()] = steps;
        }

        for(int[] dir : dirs) {
          int row = cell.getRow() + dir[0];
          int col = cell.getCol() + dir[1];

          if(row < 0 || row >= MAX_ROW || col < 0 || col >= MAX_COL) {
            continue;
          }
          if(result[row][col] == -1) {
            cells.add(new Cell(row, col));
          }
        }
      }
    }

    return result;
  }
  
  boolean isConnectedToZeros(int row, int col, int[][] matrix) {
    return (row > 0 && matrix[row-1][col] ==0)
        || (row < matrix.length-1 && matrix[row+1][col] ==0)
        || (col >0 && matrix[row][col-1] ==0)
        || (col < matrix[0].length-1 && matrix[row][col+1] ==0);
  }
}

