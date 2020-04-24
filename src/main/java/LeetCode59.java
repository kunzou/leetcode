public class LeetCode59 {
    public int[][] generateMatrix(int n) {
      int[] ROW_DIR = {0, 1, 0, -1};
      int[] COL_DIR = {1, 0, -1, 0};
      int[][] result = new int[n][n];

      int steps = 1;
      int row = 0;
      int col = 0;
      int direction = 0;
      boolean[][] visited = new boolean[n][n];
      while (steps <= n * n) {
        result[row][col] = steps;
        visited[row][col] = true;

        if (row + ROW_DIR[direction] > n - 1 || row + ROW_DIR[direction] < 0 || col + COL_DIR[direction] > n - 1 || col + COL_DIR[direction] < 0 || visited[row + ROW_DIR[direction]][col + COL_DIR[direction]]) {
          direction = (direction + 1) % 4;
          row = row + ROW_DIR[direction];
          col = col + COL_DIR[direction];
        } else {
          row = row + ROW_DIR[direction];
          col = col + COL_DIR[direction];
        }

        steps++;
      }

      return result;
    }

}
