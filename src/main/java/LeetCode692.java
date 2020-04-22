import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCode692 {
  public List<String> topKFrequent(String[] words, int k) {
    List<String> result = new LinkedList<>();
    Map<String, Long> map = Arrays.stream(words)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    List<String> candidates = new ArrayList(map.keySet());
    Collections.sort(candidates, (w1, w2) -> (int) (map.get(w1).equals(map.get(w2)) ?
            w1.compareTo(w2) : map.get(w2) - map.get(w1)));

    return candidates.subList(0, k);

/*    return Arrays.stream(words)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList()).subList(0,k);*/
  }
}
