public class LeetCode1066 {
  public int assignBikes(int[][] workers, int[][] bikes) {

    int[][] workersToBikesDistance = new int[workers.length][bikes.length];

    for (int i = 0; i < workers.length; i++) {
      workersToBikesDistance[i] = getDistanceToBikes(workers[i], bikes);
    }

    boolean[] bikesUsed = new boolean[bikes.length];
//    return getMinimumDistance(workersToBikesDistance, 0, Integer.MAX_VALUE, bikesUsed);

    //Hungarian algorithm
    return 0;
  }

  private int[] getDistanceToBikes(int[] worker, int[][] bikes) {
    int[] result = new int[bikes.length];

    for (int i = 0; i < bikes.length; i++) {
      result[i] = calculateDistance(worker, bikes[i]);
    }
    return result;
  }


/*  private int getMinimumDistance(int[][] workersToBikesDistance, int workerIndex, int bikeIndex, int sum, boolean[] used) {
    if(workerIndex == workersToBikesDistance.length) {
      return sum;
    }

    if(used[bikeIndex]) {
      sum+=getMinimumDistance(workersToBikesDistance, workerIndex+1, bikeIndex, sum+workersToBikesDistance[workerIndex][bikeIndex], used);
    }

    boolean[] takingCurrentBike = used;
    takingCurrentBike[bikeIndex] = true;
    getMinimumDistance(workersToBikesDistance, workerIndex+1, bikeIndex, sum+workersToBikesDistance[workerIndex][bikeIndex], takingCurrentBike)

  }*/

  private int calculateDistance(int[] bike, int[] worker) {
    return Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
  }
/*  public int assignBikes(int[][] workers, int[][] bikes) {
    int n = bikes.length;
    int [] dp = new int[1 << n];
    return dfs(workers, 0, bikes, 0, dp);
  }

  private int dfs(int [][] workers, int workerIndex, int [][] bikes, int state, int [] dp){
    if(workerIndex == workers.length){
      return 0;
    }

    if(dp[state] != 0){
      return dp[state];
    }

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < bikes.length; i++){
      if((state & (1 << i)) == 0){
        min = Math.min(min, dist(workers[workerIndex], bikes[i]) + dfs(workers, workerIndex + 1, bikes, state | (1 << i), dp));
      }
    }

    dp[state] = min;
    return min;
  }

  private int dist(int [] a, int [] b){
    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
  }*/
}
