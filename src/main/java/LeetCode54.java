import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
  public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();

    if(matrix.length == 0) {
      return result;
    }

    int ROW_MAX = matrix.length;
    int COL_MAX = matrix[0].length;

    int[] ROW_DIR = {0, 1, 0, -1};
    int[] COL_DIR = {1, 0, -1, 0};
    int cur_dir = 0;
    int row = 0;
    int col = 0;
    int next_row;
    int next_col;
    boolean[][] visited = new boolean[ROW_MAX][COL_MAX];

    for(int i = 0; i < ROW_MAX * COL_MAX; i ++) {
      result.add(matrix[row][col]);
      visited[row][col] = true;

      next_row = row + ROW_DIR[cur_dir];
      next_col = col + COL_DIR[cur_dir];

      if(next_row >= 0 && next_row < ROW_MAX && next_col >= 0 && next_col < COL_MAX && !visited[next_row][next_col]) {
        row = next_row;
        col = next_col;
      }
      else {
        cur_dir = (cur_dir + 1) % 4;
        row = row + ROW_DIR[cur_dir];
        col = col + COL_DIR[cur_dir];
      }
    }
    return result;
  }
}
