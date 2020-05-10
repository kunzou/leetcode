public class FirstBadVersion {
  public int firstBadVersion(int n) {

    while(n>=0) {
      if (isBadVersion(n / 2 + 1)) {
        if (!isBadVersion(n / 2 )) {
          return n / 2 + 1;
        } else {
          n = n / 2 + 1;
        }
      } else {
        if (isBadVersion(n / 2 + 2)) {
          return n / 2 + 2;
        } else {
          n = (n + n / 2 + 1) / 2;
        }
      }
    }

    return -1;
  }

  boolean isBadVersion(int n) {
    return n > 4;
  }
}

