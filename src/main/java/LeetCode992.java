import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode992 {
  public int subarraysWithKDistinct(int[] A, int K) {
//    return subarraysWithKDistinct(A, 0, K, new HashSet<>(), 0, );
    return 0;
  }

  int subarraysWithKDistinct(int[] A, int index, int targetSize, Set<Integer> numbers, int count ) {
    if(numbers.size() > targetSize) {
      return count;
    }

    if(numbers.size() == targetSize) {
      count++;
    }

    if(index == A.length) {
      return count;
    }

    Set<Integer> setPlus = new HashSet<>(numbers);
    setPlus.add(A[index]);


    return subarraysWithKDistinct(A, index + 1, targetSize, setPlus, count)
        + subarraysWithKDistinct(A, index + 1, targetSize, numbers, count);
  }
}


