public class LeetCode896 {
  public boolean isMonotonic(int[] A) {

    boolean isIncreasing = false;
    boolean isDecreasing = false;

    for(int i = 1; i <A.length; i++){
      if(isIncreasing && isDecreasing){
        return false;
      }

      if(A[i] > A[i-1]){
        isIncreasing = true;
      } else if(A[i] < A[i-1]){
        isDecreasing = true;
      }
    }

    return !(isIncreasing && isDecreasing);
  }



/*  public boolean isMonotonic(int[] A) {
    if(A.length <=2) {
      return true;
    }

    int index = 1;
    while(A[0] == A[index]) {
      index++;
      if(index>=A.length) {
        return true;
      }
    }

    boolean isIncreasing = A[0] < A[index];

    for (int i = 2; i < A.length; i++) {
      index = i;
      while(A[index] == A[i-1]) {
        index++;
        if(index>=A.length) {
          return true;
        }
      }

      if(isIncreasing ^ (A[i-1] < A[index])) {
        return false;
      }
    }
    return true;
  }*/
}
