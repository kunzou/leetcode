public class LeetCode153 {
  public int findMin(int[] nums) {
    return getMin(nums, 0, nums.length-1);
  }

  private int getMin(int[] nums, int left, int right) {
    if(right - left == 1) {
      return Math.min(nums[left], nums[right]);
    }

    if(nums[(left+right)/2] > nums[right]) {
      return getMin(nums, (left+right)/2, right);
    }

    if(nums[(left+right)/2] < nums[right]) {
      return getMin(nums, left, (left+right)/2);
    }

    return nums[right];
  }
}
