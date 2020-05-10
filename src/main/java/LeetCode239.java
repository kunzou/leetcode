import java.util.*;

/*Sliding window*/

public class LeetCode239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k == 0) return nums;

    int[] ans = new int[nums.length - k + 1];
    Deque<Integer> indices = new LinkedList<>();

    for (int i = 0; i < nums.length; ++i) {
      while (indices.size() > 0 && nums[i] >= nums[indices.getLast()]) {
        indices.removeLast();
      }

      indices.addLast(i);
      if (i - k + 1 >= 0) {
        ans[i - k + 1] = nums[indices.getFirst()];
      }
      if (i - k + 1 >= indices.getFirst()) {
        indices.removeFirst();
      }
    }

    return ans;
  }
}
