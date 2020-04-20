import org.omg.PortableServer.THREAD_POLICY_ID;

public class LeetCode413 {
  public int numberOfArithmeticSlices(int[] A) {
    int size = A.length;
    if(size < 3) {
      return 0;
    }

    int index = 1;
    int sliceSize = A[index] - A[0];
    int sameSliceSize = 0;
    int count = 0;
    Integer[] CACHE = new Integer[size];
    while(index < size) {
      if (A[index] - A[index-1] == sliceSize) {
        sameSliceSize++;
      } else {
        count += getCount(sameSliceSize, CACHE);
        sameSliceSize = 1;
        sliceSize = A[index] - A[index-1];
      }
      index++;
    }

    count+=getCount(sameSliceSize, CACHE);

    return count;
  }

  public int getCount(int occur, Integer[] CACHE) {
    if(CACHE[occur]!=null) {
      return CACHE[occur];
    }

    if(occur < 2) {
      return 0;
    }
    if(occur == 2) {
      return 1;
    }
    CACHE[occur] = getCount(occur - 1, CACHE) + occur-1;
    return CACHE[occur];
  }
}
