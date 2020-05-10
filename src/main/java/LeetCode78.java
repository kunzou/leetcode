import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    createSubSet(nums, 0, new ArrayList<>(), results);
    return results;
  }

  private void createSubSet(int[] nums, int index, List<Integer> subset, List<List<Integer>> results) {
    if(index == nums.length) {
      results.add(subset);
      return;
    }

    List<Integer> withCurrent = new ArrayList<>(subset);
    withCurrent.add(nums[index]);
    createSubSet(nums, index+1, withCurrent, results);
    createSubSet(nums, index+1, subset, results);
  }


}
