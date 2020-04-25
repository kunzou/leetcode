import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode973 {
  public int[][] kClosest(int[][] points, int K) {

    Arrays.sort(points, (a,b) -> getDistance(b) - getDistance(a));

    int[][] results = new int[K][2];
    for (int i = 0; i < K; i++) {
      results[i] = points[i];
    }
    return results;


/*    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(K, (a,b) -> getDistance(b) - getDistance(a));

    for (int i = 0; i < points.length; i++) {
      if(queue.size() < K) {
        queue.add(points[i]);
      }
      else if(queue.size() == K) {
        int smallest = getDistance(queue.peek());
        if(smallest > getDistance(points[i])) {
          queue.poll();
          queue.add(points[i]);
        }
      }
    }
    int[][] results = new int[K][2];
    for (int i = 0; i < K; i++) {
      results[i] = queue.poll();
    }
    return results;*/
  }

  int getDistance(int[] point) {
    return point[0]*point[0] + point[1]*point[1];
  }
}
