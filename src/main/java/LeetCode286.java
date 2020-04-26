import java.util.LinkedList;
import java.util.Queue;

public class LeetCode286 {
  public void wallsAndGates(int[][] rooms) {
    int MAX_ROW = rooms.length;
    int MAX_COL = rooms[0].length;
    int INF = 2147483647;
    int[][] DIRS = {{0,1},{0,-1},{1,0},{-1,0}};

    Queue<int[]> roomQueue = new LinkedList<>();
    int steps = 0;
    for(int row = 0; row < MAX_ROW; row++) {
      for(int col = 0; col < MAX_COL; col++) {
        if(rooms[row][col] == 0) {
          roomQueue.add(new int[]{row, col});
        }
      }
    }

    while(!roomQueue.isEmpty()) {
      int size = roomQueue.size();
      steps++;
      for(int i = 0; i < size; i++) {
        int[] curRoom = roomQueue.poll();

        for (int[] dir : DIRS) {
          int row = curRoom[0] + dir[0];
          int col = curRoom[1] + dir[1];

          if(row < 0 || row > MAX_ROW - 1 || col < 0 || col > MAX_COL - 1) {
            continue;
          }

          if(rooms[row][col] == INF) {
            rooms[row][col] = steps;
            roomQueue.add(new int[]{row, col});
          }
        }

/*      if(curRoom.getRow() > 0 && rooms[curRoom.getRow()-1][curRoom.getCol()] == INF) {
          rooms[curRoom.getRow()-1][curRoom.getCol()] = steps;
          roomQueue.add(new Room(curRoom.getRow()-1, curRoom.getCol()));
        }

        if(curRoom.getRow() < MAX_ROW-1 && rooms[curRoom.getRow()+1][curRoom.getCol()] == INF) {
          rooms[curRoom.getRow()+1][curRoom.getCol()] = steps;
          roomQueue.add(new Room(curRoom.getRow()+1, curRoom.getCol()));
        }

        if(curRoom.getCol() < MAX_COL-1 && rooms[curRoom.getRow()][curRoom.getCol()+1] == INF) {
          rooms[curRoom.getRow()][curRoom.getCol()+1] = steps;
          roomQueue.add(new Room(curRoom.getRow(), curRoom.getCol()+1));
        }

        if(curRoom.getCol() > 0 && rooms[curRoom.getRow()][curRoom.getCol()-1] == INF) {
          rooms[curRoom.getRow()][curRoom.getCol()-1] = steps;
          roomQueue.add(new Room(curRoom.getRow(), curRoom.getCol()-1));
        }*/

      }
    }
  }

  public void wallsAndGates_DFS(int[][] rooms) {
    if (rooms == null || rooms.length == 0) {
      return;
    }

    int m = rooms.length;
    int n = rooms[0].length;

    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rooms[i][j] == 0) {
          wallsAndGatesHelper(i, j, 0, visited, rooms);
        }
      }
    }
  }

  private void wallsAndGatesHelper(int row, int col, int distance, boolean[][] visited, int[][] rooms) {
    int rows = rooms.length;
    int cols = rooms[0].length;

    if (row < 0 || row >= rows || col < 0 || col >= cols) {
      return;
    }

    // visited
    if (visited[row][col]) {
      return;
    }

    // Is wall?
    if (rooms[row][col] == -1) {
      return;
    }

    // Distance greater than current
    if (distance > rooms[row][col]) {
      return;
    }


    // Mark as visited
    visited[row][col] = true;

    if (distance < rooms[row][col]) {
      rooms[row][col] = distance;
    }

    // go up, down, left and right
    wallsAndGatesHelper(row - 1, col, distance + 1, visited, rooms);
    wallsAndGatesHelper(row + 1, col, distance + 1, visited, rooms);
    wallsAndGatesHelper(row, col - 1, distance + 1, visited, rooms);
    wallsAndGatesHelper(row, col + 1, distance + 1, visited, rooms);

    // Mark as unvisited
    visited[row][col] = false;
  }


}

class Room {
  private int row;
  private int col;
  private int distance;

  public Room(int row, int col) {
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

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }
}


