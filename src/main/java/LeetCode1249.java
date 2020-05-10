import java.util.*;

public class LeetCode1249 {
  public String minRemoveToMakeValid(String s) {
    Set<Integer> positions = new HashSet<>();
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '(') {
        stack.push(i);
      }
      else if(s.charAt(i) == ')') {
        if(stack.isEmpty()) {
          positions.add(i);
        }
        else {
          stack.pop();
        }
      }
    }

    while(!stack.isEmpty()) {
      positions.add(stack.pop());
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if(!positions.contains(i)) {
        sb.append(s.charAt(i));
      }
    }

    return sb.toString();
  }
}
