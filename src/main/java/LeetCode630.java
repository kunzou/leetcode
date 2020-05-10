import java.util.Arrays;
import java.util.Comparator;

public class LeetCode630 {
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
    Integer[][] cache = new Integer[courses.length][courses[courses.length-1][1] + 1];

    return countCourses(courses, 0, 0, 0, cache);
  }

  public int countCourses(int[][] courses, int index, int currentTime, int count, Integer[][] cache) {
    if(index == courses.length) {
      return count;
    }

    if(cache[index][currentTime] != null) {
      return cache[index][currentTime];
    }

    if(currentTime+courses[index][0] > courses[index][1]) {
      cache[index][currentTime] = countCourses(courses, index+1, currentTime, count, cache);
      return cache[index][currentTime];
    }

    cache[index][currentTime] = Math.max(countCourses(courses, index+1, currentTime+courses[index][0], count+1, cache),
        countCourses(courses, index+1, currentTime, count, cache));
    return cache[index][currentTime];
  }

/*  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
    Integer[][] memo = new Integer[courses.length][courses[courses.length - 1][1] + 1];
    return schedule(courses, 0, 0, memo);
  }
  public int schedule(int[][] courses, int i, int time, Integer[][] memo) {
    if (i == courses.length)
      return 0;
    if (memo[i][time] != null)
      return memo[i][time];
    int taken = 0;
    if (time + courses[i][0] <= courses[i][1])
      taken = 1 + schedule(courses, i + 1, time + courses[i][0], memo);
    int not_taken = schedule(courses, i + 1, time, memo);
    memo[i][time] = Math.max(taken, not_taken);
    return memo[i][time];
  } */
}
