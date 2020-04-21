import org.apache.commons.lang3.StringUtils;

public class LeetCode151 {
  public String reverseWords(String s) {
    if (s == null) {
      return null;
    }

    if(s.trim().equals("")) {
      return "";
    }

    char[] chars = s.toCharArray();

    reverse(chars, 0, chars.length);

    int index1 = 0;
    int index2 = 1;
    int size = chars.length;

    while(index2 < size) {
      if(chars[index2] == ' ') {
        reverse(chars, index1, index2);
        index2++;
        index1 = index2;
      }
      index2++;
    }
    reverse(chars, index1, index2);
    return cleanSpaces(chars, chars.length);
  }

  void reverse(char[] s, int start, int end) {
    int index = 0;

    while(start + index < end - index) {
      char temp = s[start+index];
      s[start+index] = s[end-index-1];
      s[end-index-1] = temp;
      index++;
    }
  }

  // trim leading, trailing and multiple spaces
  String cleanSpaces(char[] a, int n) {
    int i = 0, j = 0;

    while (j < n) {
      while (j < n && a[j] == ' ') {
        j++;             // skip spaces
      }
      while (j < n && a[j] != ' ') {
        a[i++] = a[j++]; // keep non spaces
      }
      while (j < n && a[j] == ' ') {
        j++;             // skip spaces
      }
      if (j < n) {
        a[i++] = ' ';                      // keep only one space
      }
    }

    return new String(a).substring(0, i);
  }
}
