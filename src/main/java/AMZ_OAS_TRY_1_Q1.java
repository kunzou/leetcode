import java.util.List;

public class AMZ_OAS_TRY_1_Q1 {

  int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
    if(rows == 0) {
      return 0;
    }
    int[][] lands = new int[rows][column];
    for (int row = 0; row < rows-1; row++) {
      for (int col = 0; col < column-1; col++) {
        lands[row][col] = grid.get(row).get(col);
      }
    }

    int count = 0;
    for(int row = 0; row < rows; row++) {
      for (int col = 0; col < column; col++) {
        if(lands[row][col] == 1) {
          findClusters(lands, row, col, rows, column);
          count++;
        }
      }
    }

    return count;
  }

  private void findClusters(int[][] lands, int row, int col, int MAX_ROW, int MAX_COL) {
    if(row < 0 || col < 0 || row >= MAX_ROW || col >= MAX_COL || lands[row][col] == 0) {
      return;
    }

    lands[row][col] = 0;

    findClusters(lands, row+1, col, MAX_ROW, MAX_COL);
    findClusters(lands, row - 1, col, MAX_ROW, MAX_COL);
    findClusters(lands, row, col - 1, MAX_ROW, MAX_COL);
    findClusters(lands, row, col + 1, MAX_ROW, MAX_COL);
  }
}
