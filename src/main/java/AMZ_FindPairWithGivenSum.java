import java.util.HashMap;
import java.util.Map;

public class AMZ_FindPairWithGivenSum {
  public int[] findPairWithGivenSum(int[] numbers, int target) { //target - 30
    Map<Integer, Integer> numberPosition = new HashMap<>();

    for (int i = numbers.length -1; i >= 0; i--) {
      if(numberPosition.get(target-30-numbers[i]) != null) {
        return new int[]{i, numberPosition.get(target-30-numbers[i])};
      }
      numberPosition.put(numbers[i], i);
    }
    return new int[]{-1,-1};
  }
}
