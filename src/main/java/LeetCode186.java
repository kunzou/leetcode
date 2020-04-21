public class LeetCode186 {
    //"t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"
  public void reverseWords(char[] s) {
    reverse(s, 0, s.length);

    int index1 = 0;
    int index2 = 1;
    int size = s.length;

    while(index2 < size) {
      if(s[index2] == ' ') {
        reverse(s, index1, index2);
        index2++;
        index1 = index2;
      }
      index2++;
    }
    reverse(s, index1, index2);
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
}
