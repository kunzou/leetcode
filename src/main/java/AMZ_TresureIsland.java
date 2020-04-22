import java.util.LinkedList;
import java.util.Queue;

public class AMZ_TresureIsland {
  public int treasureIsland(char[][] island) {

    int MAX_ROW = island.length;
    int MAX_COL = island[0].length;

    Queue<Area> queue = new LinkedList<>();
    int steps = 0;
    queue.add(new Area(0,0));
    boolean[][]visited = new boolean[MAX_ROW][MAX_COL];

    while(!queue.isEmpty()) {
      int size = queue.size();

      for(int i = 0; i < size; i++) {
        Area curArea = queue.poll();
        visited[curArea.getRow()][curArea.getCol()] = true;

        if(island[curArea.getRow()][curArea.getCol()] == 'X') {
          return steps;
        }

        if(curArea.getRow() > 0 && island[curArea.getRow()-1][curArea.getCol()] != 'D' && !visited[curArea.getRow()-1][curArea.getCol()]) {
          queue.add(new Area(curArea.getRow()-1, curArea.getCol()));
        }

        if(curArea.getRow() < MAX_ROW-1 && island[curArea.getRow()+1][curArea.getCol()] != 'D' && !visited[curArea.getRow()+1][curArea.getCol()]) {
          queue.add(new Area(curArea.getRow()+1, curArea.getCol()));
        }

        if(curArea.getCol() < MAX_COL-1 && island[curArea.getRow()][curArea.getCol()+1] != 'D' && !visited[curArea.getRow()][curArea.getCol()+1]) {
          queue.add(new Area(curArea.getRow(), curArea.getCol()+1));
        }

        if(curArea.getCol() > 0 && island[curArea.getRow()][curArea.getCol()-1] != 'D' && !visited[curArea.getRow()][curArea.getCol()-1]) {
          queue.add(new Area(curArea.getRow(), curArea.getCol()-1));
        }
      }
      steps++;
    }

    return -1;
  }
}

class Area {
  private int row;
  private int col;

  public Area(int row, int col) {
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
