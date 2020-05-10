import java.util.Arrays;
import java.util.Stack;

public class LeetCode503 {
  public int[] nextGreaterElements(int[] nums) {
    if(nums.length == 0) {
      return new int[0];
    }
    Stack<Integer> stack = new Stack<>();
    int[] result = new int[nums.length];
    Arrays.fill(result, Integer.MIN_VALUE);
    int index = nums.length - 1;
    stack.push(nums[0]);
    int steps = (nums.length+1)*2;
    while(steps > 0) {
      while(!stack.isEmpty() && stack.peek() <= nums[index]) {
        stack.pop();
      }
      if(stack.isEmpty()) {
        result[index] = -1;
      }
      else {
        result[index] = stack.peek();
      }
      stack.push(nums[index]);

      index--;
      if(index == -1) {
        index = nums.length - 1;
      }
      steps--;
    }

    return result;
  }

}
