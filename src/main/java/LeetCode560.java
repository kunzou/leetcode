import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> sumMap = new HashMap<>();

    sumMap.put(0,1);
    int result = 0;
    int sum = 0;
    for(int number : nums) {
      sum+=number;
      if(sumMap.containsKey(sum-k)) {
        result += sumMap.get(sum-k);
      }

      sumMap.put(sum, sumMap.getOrDefault(sum, 0)+1);
    }

    return result;
  }
}
