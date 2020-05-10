public class LeetCode583 {
  public int minDistance(String s1, String s2) {
    Integer[][] cache = new Integer[s1.length()+1][s2.length()+1];
    return s1.length() + s2.length() - 2 * lcs(s1, s2, s1.length(), s2.length(), cache);
  }
  public int lcs(String s1, String s2, int m, int n, Integer[][] cache) {
    if (m == 0 || n == 0) {
      return 0;
    }
    if(cache[m][n] != null) {
      return cache[m][n];
    }
    if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
      cache[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, cache);
      return cache[m][n];
    }
    else {
      cache[m][n] = Math.max(lcs(s1, s2, m, n - 1, cache), lcs(s1, s2, m - 1, n, cache));
      return cache[m][n];
    }
  }
}
