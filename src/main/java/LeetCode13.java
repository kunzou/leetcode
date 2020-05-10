import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LeetCode13 {
  public int romanToInt(String s) {
    Map<Character, Integer> values = new HashMap<>();

    values.put('I',1);
    values.put('V',5);
    values.put('X',10);
    values.put('L',50);
    values.put('C',100);
    values.put('D',500);
    values.put('M',1000);
    int value = 0;
    Character pre = null;
    for (Character character : s.toCharArray()) {
      value+=values.get(character);
      if (Arrays.asList('V', 'X').contains(character) && Arrays.asList('I').contains(pre)
          || Arrays.asList('L', 'C').contains(character) && Arrays.asList('X').contains(pre)
          || Arrays.asList('D', 'M').contains(character) && Arrays.asList('C').contains(pre)) {
        value = value - 2*values.get(pre);
      }
      pre = character;
    }
    return value;
  }
}
