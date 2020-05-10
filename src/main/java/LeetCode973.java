import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LeetCode973 {

    /*You can see the same question and answer below: Diff: quick sort v.s. quick select here!!!!
"Because in the quicksort, you have to take care of two sides of the pivot. But in quickselect, you only focus on the side the target object should be. So, in optimal case, the running time of quicksort is (n + 2 * (n/2) + 4 * (n/4)...), it has logn iterations. Instead, the running time of quickselect would be (n + n/2 + n/4 +...) it has logn iterations as well. Therefore, the running time of quicksort is O(nlogn), instead, the running time of quickselect of quickselect is O(n)"
Hope this can help you:)

Partition sort see LC 215.
worstCase: O(N*N), average: O(N(1+1/2+1/4+...+1)) ==> O(N)*/

  public int[][] kClosest(int[][] points, int K) {
    if (points == null || points.length < K) return points;
    int start = 0;
    int end = points.length - 1;
    while (start < end) {
      int mid = partition(points, start, end);
      if (mid == K - 1) {
        break;
      }
      if (mid < K - 1) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return Arrays.copyOfRange(points, 0, K);
  }
  private int partition(int[][] points, int s, int e) {
    int[] pivot = points[s];
    int j = s + 1;
    for (int i = s + 1; i <= e; i++) {
      if (compare(points[i], pivot) <= 0) {
        swap(points, i, j++);
      }
    }
    swap(points, s, j - 1);
    return j - 1;
  }
  private void swap(int[][] points, int i, int j) {
    int[] t = points[i];
    points[i] = points[j];
    points[j] = t;
  }
  private int compare(int[] pointA, int[] pointB) {
    return pointA[0] * pointA[0] + pointA[1] * pointA[1] - pointB[0] * pointB[0] - pointB[1] * pointB[1];
  }


/*  public int[][] kClosest(int[][] points, int K) {



    Arrays.sort(points, (a,b) -> getDistance(b) - getDistance(a));

    int[][] results = new int[K][2];
    for (int i = 0; i < K; i++) {
      results[i] = points[i];
    }
    return results;


*//*    PriorityQueue<int[]> queue = new PriorityQueue<int[]>(K, (a,b) -> getDistance(b) - getDistance(a));

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
    return results;*//*
  }

  int getDistance(int[] point) {
    return point[0]*point[0] + point[1]*point[1];
  }*/
}
