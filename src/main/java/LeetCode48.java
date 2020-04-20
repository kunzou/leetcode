import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class LeetCode48 {
  public void rotate(int[][] matrix) {
    int MAX_ROW = matrix.length;
    int MAX_COL = matrix[0].length;
    int cache;
    for(int row = 0; row < MAX_ROW; row++) {
      for(int col = row; col < MAX_COL; col++) {
        cache = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = cache;
      }
    }

    for(int row = 0; row < MAX_ROW; row++) {
      for (int col = 0; col < MAX_COL/2; col++) {
        cache = matrix[row][col];
        matrix[row][col] = matrix[row][MAX_COL-1-col];
        matrix[row][MAX_COL-1-col] = cache;
      }
    }
  }
}
