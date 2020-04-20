import java.util.ArrayList;
import java.util.List;

public class LeetCode88 {

  public void merge(int[] nums1, int m, int[] nums2, int n) {
//    if(m == 0) {
//      System.arraycopy(nums2, 0, nums1, 0, n);
//    }

    int index1 = m - 1;
    int index2 = n - 1;
    int index = m + n -1;
    while(index1 >= 0 && index2 >= 0) {
      if(nums1[index1] > nums2[index2]) {
        nums1[index] = nums1[index1];
        index1--;
      }
      else if(nums1[index1] < nums2[index2]){
        nums1[index] = nums2[index2];
        index2--;
      }
      else {
        nums1[index] = nums1[index1];
        nums1[index-1] = nums2[index2];
        index1--;
        index2--;
        index--;
      }
      index--;
    }

    while(index2 >= 0) {
      nums1[index] = nums2[index2];
      index2--;
      index--;
    }

  }


  public void merge_NOT_BEST_SOLUTION(int[] nums1, int m, int[] nums2, int n) {
    int index1 = 0;
    int index2 = 0;
    int[] result = new int[m+n];
    int index = 0;
    while(index1 < m && index2 < n) {
      if(nums1[index1] <= nums2[index2]) {
        result[index] = nums1[index1];
        index1++;
      }
      else {
        result[index] = nums2[index2];
        index2++;
      }
      index++;
    }

    if(index1 < m) {
      for(int i = index1; i < m; i++) {
        result[index] = nums1[i];
        index++;
      }
    }

    if(index2 < n) {
      for(int i = index2; i < n; i++) {
        result[index] = nums2[i];
        index++;
      }
    }

    System.arraycopy(result, 0, nums1, 0, m + n);
  }
}
