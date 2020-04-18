import java.util.Arrays;
import java.util.List;

class Pair {
  Integer left;
  Integer right;

  public Pair(Integer left, Integer right) {
    this.left = left;
    this.right = right;
  }

  public Integer getLeft() {
    return left;
  }

  public List<Integer> getAll() {
    return Arrays.asList(left, right);
  }
}