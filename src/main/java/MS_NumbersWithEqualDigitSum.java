import java.util.HashMap;
import java.util.Map;

public class MS_NumbersWithEqualDigitSum {
  int numbersWithEqualDigitSum(int[] numbers) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum;
    int max = Integer.MIN_VALUE;

    for(int i = 0; i < numbers.length; i++) {
      sum = numbers[i]/10 + numbers[i]%10;
      if(map.get(sum) == null) {
        map.put(sum, numbers[i]);
        max = Math.max(numbers[i], max);
      }
      else {
        int curMax = map.get(sum)+numbers[i];
//        map.put(sum, curMax);
        max = Math.max(curMax, max);
        map.put(sum, Math.max(numbers[i], map.get(sum)));
      }
    }
    return max;
  }
}
