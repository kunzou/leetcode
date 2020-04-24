import java.util.Arrays;

public class AMZ_LoadBalancer {
  /*1, 3, 4, 2, 2, 2, 1, 1, 2*/
  public boolean loadBalancer(int[] numbers) {
    int left = 1;
    int right = numbers.length -2;
    int leftSum;
    int rightSum;
    int sum = calculateSum(numbers, 0, numbers.length-1);
    int middleSum;

    /*left first*/
    boolean moveLeft = true;
    while(left < right) {
      leftSum = calculateSum(numbers,0, left-1);
      rightSum = calculateSum(numbers, right+1, numbers.length-1);
      middleSum = sum - leftSum - rightSum - numbers[left] - numbers[right];

      if(isBalanced(leftSum, middleSum, rightSum)) {
        return true;
      }

      if(moveLeft) {
        left++;
      }
      else {
        right --;
      }

      moveLeft = !moveLeft;
    }

    /*right first*/
    left = 1;
    right = numbers.length -2;
    moveLeft = false;
    while(left < right) {
      leftSum = calculateSum(numbers,0, left-1);
      rightSum = calculateSum(numbers, right+1, numbers.length-1);
      middleSum = sum - leftSum - rightSum - numbers[left] - numbers[right];

      if(isBalanced(leftSum, middleSum, rightSum)) {
        return true;
      }

      if(moveLeft) {
        left++;
      }
      else {
        right --;
      }

      moveLeft = !moveLeft;
    }

    return false;
  }

  private int calculateSum(int[] numbers, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum+=numbers[i];
    }
    return sum;
  }

  private boolean isBalanced(int leftSum, int middleSum, int rightSum) {
    return leftSum == middleSum && middleSum == rightSum;
  }
}
