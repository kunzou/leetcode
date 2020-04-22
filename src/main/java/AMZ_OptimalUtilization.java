import java.util.*;
import java.util.stream.Collectors;

public class AMZ_OptimalUtilization {

  public List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
    Map<Integer, List<Integer>> map = new HashMap<>(); //Key: value, value: id

    for (int[] value: a) {
      if(map.get(value[1]) == null) {
        map.put(value[1], Collections.singletonList(value[0]));
      }
      else {
        List<Integer> indices = map.get(value[1]);
        indices.add(value[0]);
        map.put(value[1], indices);
      }
    }

    TreeMap<Integer, List<int[]>> resultsMap = new TreeMap<>();
    for (int[] bValues: b) {

      int desired = target - bValues[1];
      while(map.get(desired) == null) {
        desired --;
        if(desired < 0) {
          break;
        }
      }

      if(desired < 0) {
        continue;
      }

      List<Integer> aListIndexes = map.get(desired);
      List<int[]> indexes = new ArrayList<>();

      for (Integer index : aListIndexes) {
        int[] x = {index, bValues[1]};
        indexes.add(x);
      }
      resultsMap.put(desired+bValues[1], indexes);
    }

    return resultsMap.lastEntry().getValue();
  }
}
