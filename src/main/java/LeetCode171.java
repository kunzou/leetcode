public class LeetCode171 {
  public int titleToNumber(String s) {
    int value = 0;
    for(int i = 0; i < s.length(); i++) {
      value += (s.charAt(s.length() - 1 -i) - 'A' + 1) *  Math.pow(26,i);
    }

    return value;
  }

  public int titleToNumberAlternative(String s) {
    int result = 0;
    for(int i = 0 ; i < s.length(); i++) {
      result = result * 26 + (s.charAt(i) - 'A' + 1);
    }
    return result;
  }
}
