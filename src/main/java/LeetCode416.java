import java.lang.reflect.Array;
import java.util.*;

public class LeetCode416 {

  public boolean canPartition(int[] nums) {
    Arrays.sort(nums);

    int sum = Arrays.stream(nums).sum();
    if(sum % 2 != 0) {
      return false;
    }

    return canPartition(nums, 0, 0, sum/2);
  }

  boolean canPartition(int[] nums, int index, int sum, int target) {
    if(index == nums.length || sum > target) {
      return false;
    }

    if(sum == target) {
      return true;
    }

    if(canPartition(nums, index + 1, sum+nums[index], target)) {
      return true;
    }
    while(index < nums.length -1 && nums[index] == nums[index+1]) {
      index++;
    }
    index++;
    return canPartition(nums, index, sum, target);
  }


/*  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();

    if(sum % 2 != 0) {
      return false;
    }
    Arrays.sort(nums);
    Set<Integer> integers = new HashSet<>();
    integers.add(0);

    for (int number : nums) {
      List<Integer> list = new ArrayList<>();

      for(Integer i : integers) {
        if(i+number == sum/2) {
          return true;
        }

        list.add(i+number);
      }

      integers.addAll(list);
    }
    return false;
  }*/






}
