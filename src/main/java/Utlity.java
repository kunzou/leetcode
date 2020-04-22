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

  public static void here() {
    //List of String to string[]
    String[] strings = Arrays.asList(new ArrayList<>()).toArray(new String[0]);

    //sort array
    String[] logs = new String[100];
    Arrays.sort(logs, (log1, log2) -> {
      String[] split1 = log1.split(" ", 2);
      String[] split2 = log2.split(" ", 2);
      boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
      boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
      if (!isDigit1 && !isDigit2) {
        int cmp = split1[1].compareTo(split2[1]);
        if (cmp != 0) return cmp;
        return split1[0].compareTo(split2[0]);
      }
      return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
    });

  }

}
