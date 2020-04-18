import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class Utlity {
  private static List<Integer> convertIntArrayToList(int[] input) {

    /*List<Integer> list = new ArrayList<>();
    for (int i : input) {
      list.add(i);
    }
    return list;*/
    return Arrays.stream(input).boxed().collect(Collectors.toList());
  }

  private static List<Integer> reverse(List<Integer> input) {
    return Lists.reverse(input);
  }

  private static void reverseVoid(List<Integer> input) {
    Collections.reverse(input);
  }

  private static LinkedList<Integer> toLinkedList(int[] input) {
    return Arrays.stream(input).boxed().sorted().collect(Collectors.toCollection(LinkedList::new));
  }

  public static int binarySearch(int[] arr, int x) {
    return Collections.binarySearch(Arrays.stream(arr).boxed().collect(Collectors.toList()), x);
  }
}
