public class LeetCode348 {

  private int[][] rows;
  private int[][] cols;
  private int[] diag;
  private int[] xdiag;

  public LeetCode348(int n) {
    rows = new int[2][n];
    cols = new int[2][n];
    diag = new int[2];
    xdiag = new int[2];
  }

  public int move(int row, int col, int player) {
    int p = player - 1;

    rows[p][row]++;
    cols[p][col]++;

    if(row == col) {
      diag[p]++;
    }
    if(row + col == rows[0].length) {
      xdiag[p]++;
    }

    if(cols[p][col] == cols[0].length || rows[p][row] == rows[0].length || diag[p] == rows[0].length || xdiag[p] == rows[0].length) {
      return p+1;
    }

    return 0;
  }
}
