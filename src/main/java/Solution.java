import com.google.common.collect.Lists;
import com.google.common.math.IntMath;

import java.math.RoundingMode;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {
  public static int lengthOfLongestSubstring(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))){
        set.add(s.charAt(j));
        j++;
        ans = Math.max(ans, j - i);
      }
      else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    return ans;
  }

  public static double findMedianOfTwoSortedArrays(int[] array1, int[] array2) {
    int[] combinedArray = new int[array1.length + array2.length];
    System.arraycopy(array1, 0, combinedArray, 0, array1.length);
    System.arraycopy(array2, 0, combinedArray, array1.length, array2.length);

    List<Integer> list = Arrays.stream(combinedArray).boxed().sorted().collect(Collectors.toList());

    if(list.size() % 2 != 0) {
      return list.get(list.size()/2);
    }
    else {
      return (double)(list.get(list.size()/2-1)+list.get(list.size()/2))/2;
    }
  }

  public static String longestPalindromicSubstring(String input) {
    int length = input.length();

    if(length<2) {
      return input;
    }

//    String longestPalindrom = "";

    int start = 0;
    int end = 0;
    int wordLength = 0;
    int maxLength = 0;

    int index = 0;
    int step;

    while(index < length - 1) {
//      String palindrom = "";
//      if(input.charAt(index) == input.charAt(index+1)) {
//        palindrom = input.substring(index, index+1+1);
        step = 0;
        while(index-step>=0 && index+step<length-1 && input.charAt(index-step) == input.charAt(index+1+step)) {
//          palindrom = input.substring(index-step, index+1+step+1);
          wordLength = index+1+step+1 - (index-step);
          step++;
        }
//        if(palindrom.length()>longestPalindrom.length()) {
        if(wordLength > maxLength) {
//          longestPalindrom = palindrom;
          start = index - step;
          end = index+1+step+1;
          maxLength = wordLength;
        }
//      }

//      if(index>0 && input.charAt(index-1) == input.charAt(index+1)) {
//        palindrom = input.substring(index-1, index+1+1);
        step = 0;

        while(index-step>=0 && index+step<=length-1 && input.charAt(index-step) == input.charAt(index+step)) {
//          palindrom = input.substring(index-step, index+step+1);
          wordLength = index+step+1 - (index-step);
          step++;
        }
//        if(palindrom.length()>longestPalindrom.length()) {
        if(wordLength > maxLength) {
//          longestPalindrom = palindrom;
          maxLength = wordLength;
          start = index - step;
          end = index+step+1;
        }
//      }
      index++;
    }

    return wordLength == 0 ?input.substring(0,1):input.substring(start, end);
  }

  public static String longestPalindrome(String s) {

    if (s == null || s.length() < 1) return "";
    String longest = "";
    String word;
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
        word = s.substring(start, end + 1);
        if(word.length() > longest.length()) {
          longest = word;
        }
      }

    }
    return longest;
  }

  private static int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }

  public static String zigZagConversion(String input, int rows) {
    if(rows==1) {
      return input;
    }
    if(input.length()<rows) {
      return input;
    }

    List<String> rowString = new ArrayList<>();

    int index;
    int i;
    for(i=0;i<rows;i++) {
      rowString.add(String.valueOf(input.charAt(i)));
    }

    index = rows-2;
    boolean directionDown = false;

    for(; i < input.length(); i++) {
      rowString.set(index, rowString.get(index)+input.charAt(i));
      if(directionDown) {
        index++;
      }
      else {
        index--;
      }

      if(index == rows && directionDown) {
        directionDown = false;
        index=index-2;
      }
      else if(index == -1 && !directionDown) {
        directionDown = true;
        index=index+2;
      }
    }

    return String.join("", rowString);
  }

  public static int reverseInteger(int number) {
    if(number>Integer.MAX_VALUE/10 || number<Integer.MIN_VALUE/10) {
      return 0;
    }

    int cur;
    int rev=0;
    while(number!=0) {
      cur = number%10;
      rev = rev*10+cur;
      number=number/10;
    }

    return rev;
  }

  public static int[] cellCompete(int[] states, int days) {
    if(days == 0 || states.length == 0) {
      return states;
    }

    if(states.length == 1) {
      return new int[]{0};
    }

    int today = 0;

    while(today<days) {
      int[] temp = new int[states.length];
      System.arraycopy(states, 0, temp, 0, states.length);
      for(int i = 0; i < states.length; i++) {
        if(i==0) {
          states[i] = 0;
        }
        else if(i==states.length-1) {
          states[i] = 0;
        }
        else {
          states[i] = temp[i-1]^temp[i+1];
        }
      }

      today++;
    }

    return states;
  }


  public static int generalizedGCD(int num, int[] arr) {
    // WRITE YOUR CODE HERE
    if(num == 1 && arr.length==1) {
      return arr[0];
    }

    int maxGcd = 0;
    for(int i=0;i<arr.length-1;i++) {
      int gcd = IntMath.gcd(arr[i], arr[i+1]);
      if(gcd == 1) {
        return 1;
      }
      maxGcd = Math.max(maxGcd, gcd);
    }
    return maxGcd;
  }

  private static List<Integer> getDivider(int n) {
    return Lists.reverse(IntStream.rangeClosed(0, IntMath.sqrt(n, RoundingMode.HALF_UP))
        .filter(i->n%i==0)
        .boxed()
        .collect(Collectors.toList()));
  }

  public static int maxArea(int[] height) {
    if(height.length < 2) {
      return 0;
    }

    int left = 0;
    int right = height.length - 1;
    int maxArea = 0;
    int area = 0;
    while(left < right) {
      area = (right - left) * (Math.min(height[left], height[right]));

      maxArea = Math.max(area, maxArea);

      if(height[left] < height[right]) {
        left++;
      }
      else {
        right--;
      }
    }

    return maxArea;
  }

  public static int lastStoneWeightII(int[] stones) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)-> b - a);
    for (int a : stones)
      pq.offer(a);
    for (int i = 0; i < stones.length - 1; ++i)
      pq.offer(pq.poll() - pq.poll());
    return pq.poll();
  }

  public static int maxProfit(int[] wines) {
    int[][] cache = new int[wines.length][wines.length];
    return calculateProfit1(1, 0, wines.length-1, wines, cache);
//    return calculateProfit(1, 0, wines.length-1, wines);
  }

  private static int calculateProfit(int year, int left, int right, int[] wines) {
    if(left>right) {
      return 0;
    }

    return Math.max(calculateProfit(year+1, left+1, right, wines) + wines[left]*year,
                    calculateProfit(year+1, left, right-1, wines) + wines[right]*year);
  }

  private static int calculateProfit1(int year, int left, int right, int[] wines, int[][] cache) {
    if(left>right) {
      return 0;
    }

    if(cache[left][right] != 0) {
      return cache[left][right];
    }

    cache[left][right] = Math.max(calculateProfit1(year+1, left+1, right, wines, cache) + wines[left]*year,
        calculateProfit1(year+1, left, right-1, wines, cache) + wines[right]*year);
    return cache[left][right];
  }

  public static int fib(int n) {
    if(n==1||n==2) {
      return 1;
    }
    return fib(n-1)+fib(n-2);
  }

  public static int fibMemo(int n) {
    int[][] cache = new int[n][n];
    return calFib(n, cache);
  }

  private static int calFib(int n, int[][] cache) {
    if(n==1||n==2) {
      return 1;
    }

    if(cache[n][n-2] != 0) {
      return cache[n][n-2];
    }

    cache[n][n-2] = calFib(n-1, cache)+calFib(n-2, cache);

    return cache[n][n-2];
  }

  public static int minRotatedArray(int[] nums) {
    if(nums.length==1) {
      return nums[0];
    }

    if(nums.length==2) {
      return Math.min(nums[0], nums[1]);
    }

    if(nums[0] < nums[nums.length-1]) {
      return nums[0];
    }

    int left = 0;
    int right = nums.length-1;

    return splitArray(nums, left, right);
  }

  private static int splitArray(int[] nums, int left, int right) {
    int middle = (right+left)/2;

    if(nums[left]<nums[middle] && nums[middle+1]<=nums[right]) {
      return nums[middle+1];
    }

    if(nums[left] > nums[middle] && middle-left==1) {
      return nums[middle];
    }

    if(nums[middle+1] > nums[right] && right-middle ==2 ) {
      return nums[right];
    }

    if(nums[left]<nums[middle]) {
      return splitArray(nums, middle+1, right);
    }
    else {
      return splitArray(nums, left, middle);
    }
  }

  public static List<Integer> findClosestElements(int[] arr, int k, int x) {
    if(x<arr[0]) {
      return Arrays.stream(arr).boxed().limit(k).collect(Collectors.toList());
    }

    if(x>arr[arr.length-1]) {
      return IntStream.range(arr.length-k, arr.length)
          .map(i->arr[i])
          .boxed()
          .collect(Collectors.toList());
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)-> b - a);
    int startPos = 0;
    boolean everIecrease = false;
    for(int i=0;i<arr.length;i++) {
      if(i>0 && arr[i]>arr[i-1]) {
        everIecrease = true;
      }

      if(queue.size() < k) {
        queue.offer(Math.abs(x-arr[i]));
      }
      else {
        if(Math.abs(x-arr[i]) <= queue.peek() || !everIecrease) {
          queue.poll();
          queue.offer(Math.abs(x-arr[i]));
          startPos++;
        }
        else if(Math.abs(x-arr[i]) > queue.peek()) {
          break;
        }

      }
    }

    return IntStream.range(startPos, startPos+k)
        .map(i->arr[i])
        .boxed()
        .collect(Collectors.toList());
  }

  public static int maxValue(int[]values, int[] weights, int n, int w) {
    if(n<=0 || w<=0) {
      return 0;
    }

    if(weights[n] > w) {
      return maxValue(values, weights, n-1, w);
    }

    int include = values[n] + maxValue(values, weights, n-1, w-weights[n]);
    int exclude = maxValue(values, weights, n-1, w);

    return Math.max(include, exclude);

  }

  public static int knapsack(int[] values, int[] weights, int n, int capacity, int[][]cache) {
    if(cache[n][capacity] != 0) {
      return cache[n][capacity];
    }
    if(n==0 || capacity==0) {
      return 0;
    }
    if(weights[n-1] > capacity) {
      cache[n][capacity] = knapsack(values, weights, n-1, capacity,cache);
      return cache[n][capacity];
    }

    int exclude = knapsack(values, weights, n-1, capacity,cache);
    int include = values[n-1] + knapsack(values, weights, n-1, capacity - weights[n-1],cache);

    cache[n][capacity] = Math.max(exclude, include);
    return cache[n][capacity];
  }

  public static int coinChange(int amount, int[] coins) {
    if(amount == 0) {
      return 1;
    }
    if(coins.length == 0) {
      return 0;
    }


    return countCoins(amount, coins, 0, new Integer[amount+1][coins.length]);
  }

  private static int countCoins(int curAmount, int[] coins, int curCoin, Integer[][] cache) {
    if(curAmount < 0) {
      return 0;
    }
    if(curAmount == 0) {
      return 1;
    }

    if(cache[curAmount][curCoin]!=null) {
      return cache[curAmount][curCoin];
    }

    int count = 0;
    for(int i=curCoin;i<coins.length;i++) {
      count += countCoins(curAmount-coins[i], coins, i, cache);
      cache[curAmount][curCoin] = count;
    }

    return count;
  }

  public static int change(int amount, int[] coins) {
    if(amount == 0)
      return 1;
    if(coins.length == 0)
      return 0;
    return memo(amount,coins,coins.length-1,new Integer[amount+1][coins.length]);
  }

  static int memo(int curr, int[] coins, int last, Integer[][] dp){

    if(curr < 0)
      return 0;
    if(curr == 0)
      return 1;

    if(dp[curr][last] == null){
      int val = 0;
      for(int i = last; i >= 0; i--)
        val +=  memo(curr-coins[i],coins,i,dp);
      dp[curr][last] = val;
    }

    return dp[curr][last];
  }

  public static List<String> findAndReplacePattern(String[] words, String pattern) {
    return Arrays.stream(words)
        .filter(word->matchPattern(pattern, word))
        .collect(Collectors.toList());
  }

  static boolean matchPattern(String pattern, String word) {
    Map<Character, Character> mapP2W = new HashMap<>();
    Map<Character, Character> mapW2P = new HashMap<>();
    for(int i=0;i<pattern.length();i++) {
      Character p = pattern.charAt(i);
      Character w = word.charAt(i);

      if(!mapP2W.containsKey(p)) {
        mapP2W.put(p,w);
      }
      else {
        if(mapP2W.get(p)!=w) {
          return false;
        }
      }

      if(!mapW2P.containsKey(w)) {
        mapW2P.put(w,p);
      }
      else {
        if(mapW2P.get(w)!=p) {
          return false;
        }
      }
    }
    return true;
  }

  public static int rob(int[] nums) {
    return robHouse(nums, 0, new Integer[nums.length]);
  }

  public static int robHouse(int[] nums, int index, Integer[] cache) {
    if(index>=nums.length) {
      return 0;
    }
    if(cache[index] != null) {
      return cache[index];
    }

    int include = nums[index] + robHouse(nums, index + 2, cache);
    int exclude = robHouse(nums, index+1, cache);

    cache[index] = Math.max(include, exclude);

    return cache[index];
  }

  public static int robLevel2(int[] nums) {
    if(nums.length ==1) {
      return nums[0];
    }

    return Math.max(robHouseLevel2FirstHouse(nums, 0, new Integer[nums.length]), robHouseLevel2SecondHouse(nums, 1, new Integer[nums.length]));
  }

  static int robHouseLevel2FirstHouse(int[] nums, int index, Integer[] cache) {
    if(index>=nums.length-1) {
      return 0;
    }
    if(cache[index] != null) {
      return cache[index];
    }

    int include = nums[index] + robHouseLevel2FirstHouse(nums, index + 2, cache);
    int exclude = robHouseLevel2FirstHouse(nums, index+1, cache);

    cache[index] = Math.max(include, exclude);

    return cache[index];
  }

  static int robHouseLevel2SecondHouse(int[] nums, int index, Integer[] cache) {
    if(index>=nums.length) {
      return 0;
    }
    if(cache[index] != null) {
      return cache[index];
    }

    int include = nums[index] + robHouseLevel2SecondHouse(nums, index + 2, cache);
    int exclude = robHouseLevel2SecondHouse(nums, index+1, cache);

    cache[index] = Math.max(include, exclude);

    return cache[index];
  }

  private static int coinChange(int[] coins, int remainder) {

    /*
      Minimum coins to make change for a negative amount is -1.
      This is just a base case we arbitrarily define.
    */
    if (remainder < 0) {
      return -1;
    }

    /*
      The minimum coins needed to make change for 0 is always 0
      coins no matter what coins we have.
    */
    if (remainder == 0) {
      return 0;
    }

    /*
      No answer yet. Try each coin as the last coin in the change that
      we make for the amount
    */
    int minimum = Integer.MAX_VALUE;
    for (int coin : coins) {
      int changeResult = coinChange(coins, remainder - coin);

      /*
        If making change was possible (changeResult >= 0) and
        the change result beats our present minimum, add one to
        that smallest value

        We accept that coin as the last coin in our change making
        sequence up to this point since it minimizes the coins we
        need
      */
      if (changeResult >= 0 && changeResult < minimum) {
        minimum = 1 + changeResult;
      }
    }

    /*
      If no answer is found (minimum == Integer.MAX_VALUE) then the
      sub problem answer is just arbitrarily made to be -1, otherwise
      the sub problem's answer is "minimum"
    */
    return (minimum == Integer.MAX_VALUE) ? -1 : minimum;

    // Return the sub problem's answer
  }

  public static int maxStockProfit(int[] prices) {
    int maxProfit = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;

    for(int price:prices) {
      minPrice = Math.min(price, minPrice);
      maxProfit = Math.max(maxProfit, price-minPrice);
    }
    return maxProfit;
  }

  public static int lenLongestFibSubseq(int[] A) {
    int max = 0;
    Map<Integer, Set<Pair>> map = getMap(A);

    Integer[] cache = new Integer[99];

    for(int number:A) {
      max = Math.max(max, lenFib(number, map, cache));
    }

    return max+2;
  }

  private static int lenFib(int remaining, Map<Integer, Set<Pair>> map, Integer[] cache) {
    if(cache[remaining]!=null) {
      return cache[remaining];
    }

    List<Integer> smaller = getSmallerPiece(map, remaining);
    if(smaller.isEmpty()) {
      cache[remaining] = 0;
      return 0;
    }

    cache[remaining] = Collections.max(smaller.stream().map(small->1+lenFib(small, map, cache)).collect(Collectors.toList()));
    return cache[remaining];
  }

  static List<Integer> getSmallerPiece(Map<Integer, Set<Pair>> map, int number) {
    return map.getOrDefault(number, new HashSet<>()).stream()
        .flatMap(pair->pair.getAll().stream())
        .collect(Collectors.toList());
  }

  static Map<Integer, Set<Pair>> getMap(int[] array) {
    Map<Integer, Set<Pair>> map = new HashMap<>();
    for(int i=0;i<array.length;i++) {
      for(int j=i+1;j<array.length;j++) {
        if(array[i]+array[j]>array[array.length-1]) {
          break;
        }
        if(!map.containsKey(array[i]+array[j])) {
          Pair pair = new Pair(array[i], array[j]);
          Set<Pair> set = new HashSet<>();
          set.add(pair);
          map.put(array[i]+array[j], set);
        }
        else {
          Set<Pair> list = map.get(array[i]+array[j]);
          list.add(new Pair(array[i], array[j]));
          map.put(array[i]+array[j], list);
        }
      }
    }
    return map;
  }

  public static int numSubarrayProductLessThanK(int[] nums, int k) {
    if(nums.length==0) {
      return 0;
    }
    if(nums.length==1) {
      return nums[0]<k?1:0;
    }

    int first = 0;
    int second = 0;
    int count=0;
    int sum = 1;
    while(first<nums.length || second<nums.length) {
      if(first==second) {
        sum = nums[first];
      }
      else if(second == nums.length) {
        sum/=nums[first];
        first++;
      }
      else {
        sum = sum*nums[second];
      }

      if(sum<k) {
        count++;
        if(second<nums.length) {
          second++;
        }
      }
      else {
        sum/=nums[first];
        first++;
      }

    }
    return count;
  }

  public static int addDigits(int num) {
    int result = 0;
    while(true) {
      result = 0;
      while(num!=0) {
        result = result + num%10;
        num = num/10;
      }
      if(result > 9) {
        num = result;
      }
      else {
        break;
      }
    }
    return result;
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    if(nums.length<3) {
      return new ArrayList<>();
    }

    if(nums.length == 3 && Arrays.stream(nums).sum()==0) {
      return Arrays.asList(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    if(Arrays.stream(nums).distinct().count() == 1) {
      if(nums[0]==0) {
        return Arrays.asList(Arrays.stream(nums).limit(3).boxed().collect(Collectors.toList()));
      }
      return new ArrayList<>();
    }

    Set<List<Integer>> result = new HashSet<>();
    for(int i=0;i<nums.length;i++) {
      Map<Integer, Integer> sumToi = new HashMap<>();

      for(int j=i+1;j<nums.length;j++) {
        if(!sumToi.containsKey(nums[j])){
          sumToi.put(-nums[i]-nums[j], j);
        }
        else {
          List<Integer> list = Stream.of(nums[i], nums[sumToi.get(nums[j])], nums[j]).sorted().collect(Collectors.toList());
          result.add(list);
        }
      }
    }

    return new ArrayList<>(result);
  }

  public static List<String> letterCombinations(String digits) {
    if("".equals(digits)) {
      return new ArrayList<>();
    }

    final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> ret = new ArrayList<>();
    combineLetters(KEYS, 0, digits, ret, "");
    return ret;
  }

  private static void combineLetters(String[] KEYS, int index, String digits, List<String> result, String word) {
    if(index == digits.length()) {
      result.add(word);
      return;
    }

    for(int i=0;i<KEYS[digits.charAt(index)-'0'].length();i++) {
      combineLetters(KEYS, index+1, digits, result, word+KEYS[digits.charAt(index)-'0'].charAt(i));
    }
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    if(head==null) {
      return head;
    }
    if(head.next == null && n==1) {
      return null;
    }

    LinkedList<ListNode> queue = new LinkedList<>();
    ListNode cur = head;

    while(cur!=null) {
      if(queue.size()<n+1) {
        queue.addLast(cur);
      }
      else {
        queue.removeFirst();
        queue.addLast(cur);
      }
      cur = cur.next;
    }

    ListNode node = queue.getFirst();
    if(node.next == null) {
      head = node;
    }
    else if(queue.size()<n+1) {
      head = node.next;
    }
    else {
      node.next = node.next.next;
    }


    return head;
  }

  public static int removeDuplicates(int[] nums) {
    Set<Integer> set = new HashSet<>();
//    Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    Arrays.stream(nums).forEach(set::add);
    System.out.println(set);
    return set.size();
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode curL1 = l1;
    ListNode curL2 = l2;
    ListNode result = new ListNode(99);
    ListNode combined = result;
    while(curL1!=null && curL2!=null) {
      if(curL1.val>curL2.val) {
        combined.next = new ListNode(curL2.val);
        curL2 = curL2.next;
        combined = combined.next;
      }
      else {
        combined.next = new ListNode(curL1.val);
        curL1=curL1.next;
        combined = combined.next;
      }
    }
    if(curL1==null) {
      combined.next = curL2;
    }
    else {
      combined.next = curL1;
    }
    return result.next;
  }

  public static List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    combineParenthesess(result, 0, "", n, 0, 0);
    return result;
  }

  private static void combineParenthesess(List<String> result, int index, String cur, int n, int open, int close) {
    if(index==n*2) {
      result.add(cur);
      return;
    }

    if(open<n) {
      combineParenthesess(result, index+1, cur+'(', n, open+1, close);
    }
    if(close<open) {
      combineParenthesess(result, index+1, cur+')', n, open, close+1);
    }
  }

  private static void combineParenthesess(List<String> result, int index, String cur, int n) {
    if(index==n*2) {
      if(isValid(cur)) {
        result.add(cur);
      }
      return;
    }

    for(int i=0;i<2;i++) {
      combineParenthesess(result, index+1, cur+"()".charAt(i), n);
    }
  }

  private static boolean isValid(String cur) {
    Stack<Character> stack = new Stack<>();
    for(int i=0;i<cur.length();i++) {
      if(cur.charAt(i)=='(') {
        stack.push('(');
      }
      else {
        if(stack.isEmpty()) {
          return false;
        }
        else {
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    if(matrix == null) {
      return new ArrayList<>();
    }

    if(matrix.length == 1) {
      return Arrays.stream(matrix[0]).boxed().collect(Collectors.toList());
    }

    if(matrix[0].length == 1) {
      List<Integer> result = new ArrayList<>();
      for(int i=0;i<matrix.length;i++) {
        result.add(matrix[i][0]);
      }
      return result;
    }

    LinkedList<Integer> columns = IntStream.range(0, matrix[0].length)
        .boxed()
        .collect(Collectors.toCollection(LinkedList::new));

    LinkedList<Integer> rows = IntStream.range(0, matrix.length)
        .boxed()
        .collect(Collectors.toCollection(LinkedList::new));

    List<Integer> result = new ArrayList<>();
    int curRow=0;
    int curCol=rows.pollFirst();
    while(!rows.isEmpty() || !columns.isEmpty()) {
      //right
      if(!columns.isEmpty()) {
        int tempCol = curCol;
        curCol = columns.pollLast();
        for(int i=tempCol;i<curCol;i++) {
          result.add(matrix[curRow][i]);
        }
      }
      //down
      if(!rows.isEmpty()) {
        curRow = rows.pollLast();
        for(int i=0;i<curRow;i++) {
          result.add(matrix[i][curCol]);
        }
      }
      //left
      if(!columns.isEmpty()) {
        int tempCol = curCol;
        curCol = columns.pollFirst();
        for(int i=tempCol;i>curCol;i--) {
          result.add(matrix[curRow][i]);
        }
      }
      //up
      if(!rows.isEmpty()) {
        int tempRow = curRow;
        curRow = rows.pollFirst();
        for(int i=tempRow;i>curRow;i--) {
          result.add(matrix[i][curCol]);
        }
      }
    }
    if(matrix[0].length==matrix.length) {
      result.add(matrix[curRow][curCol]);
    }

    return result;
  }

  public static int climbStairs(int n) {
    return goClimb(n, new Integer[n+1]);
  }

  private static int goClimb(int n, Integer[] cache) {
    if(cache[n]!=null) {
      return cache[n];
    }

    if(n==0) {
      return 1;
    }

    if(n==1) {
      return 1;
    }

    cache[n] = goClimb(n-1, cache)+goClimb(n-2, cache);

    return cache[n];
  }

  public static List<List<Integer>> subsets(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    addToSet(result, new ArrayList<>(), 0, nums);
    return new ArrayList<>(result);
  }

  private static void addToSet(Set<List<Integer>> result, List<Integer> subResult, int index, int[] nums) {
    if(index == nums.length) {
      List<Integer> newResult = new ArrayList<>(subResult);
      result.add(newResult);
      subResult.clear();
      return;
    }

    //include
    List<Integer> include = new ArrayList<>(subResult);
    include.add(nums[index]);

    addToSet(result, include, index+1, nums);
    addToSet(result, subResult, index+1, nums);
  }

  public static int largestRectangleArea(int[] heights) {
    if(heights.length==0) {
      return 0;
    }
    if(heights.length==1) {
      return heights[0];
    }
    if(heights.length==2) {
      if(heights[0]==0&&heights[1]==0) {
        return 0;
      }
      else if (heights[0]==0||heights[1]==0){
        return heights[0]==0?heights[1]:heights[0];
      }
      else {
        return Math.min(heights[0],heights[1])*2;
      }
    }
    if(heights[0]==0) {
      if(Arrays.stream(heights).boxed().distinct().count()==1) {
        return heights.length;
      }
    }
    int left = 0;
    int right = heights.length-1;
    int maxArea = 0;
    int curHeight = 0;
    while(left<right) {
      curHeight = findHeight(heights,left,right);
      int area = curHeight*(right-left+1);
      if (area >= maxArea) {
        maxArea = area;
      }

      if(heights[left]<heights[right]) {
        left++;
      }
      else {
        right--;
      }
    }
    return maxArea;
  }

  private static int findHeight(int[] heights, int left, int right) {
    int max = Integer.MAX_VALUE;
    for(int i=left;i<=right;i++) {
      max=Math.min(max, heights[i]);
    }
    return max==0?1:max;
  }

  public static boolean wordBreak(String s, List<String> wordDict) {
    if(wordDict.isEmpty()) {
      return false;
    }
    String remaining = s;
    for (String s1 : wordDict) {
      if (remaining!=null && remaining.contains(s1)) {
        remaining = Arrays.stream(remaining.split(s1))
            .filter(word -> !word.equals(""))
            .findAny()
            .orElse(null);
      } else {
        return false;
      }
    }
    return true;
  }

  public static int findPeakElement(int[] nums) {
    return search(nums, 0, nums.length - 1);
  }

  private static int search(int[] nums, int l, int r) {
    if (l == r)
      return l;
    int mid = (l + r) / 2;
    if (nums[mid] > nums[mid + 1])
      return search(nums, l, mid);
    return search(nums, mid + 1, r);
  }

  class MedianFinder {
    private int sum;
    private int size=0;
    private List<Integer> list;

    public void addNum(int num) {
      if(list == null) {
        list = new ArrayList<>();
      }
      list.add(num);
      sum+=num;
      size++;
    }

    public double findMedian() {
      Collections.sort(list);
      if(size%2==0) {
        return (double)((double)(list.get(size/2-1)+list.get(size/2))/2);
      }
      else {
        return list.get(size/2);
      }
    }

  }

  public static int lengthOfLIS(int[] nums) {
    return getMaxLengthIncrease(nums, -9999, 0, new Integer[nums.length+1][2501]);
//    return getMaxLengthIncrease(nums, -9999, 0, 0);
  }

  private static int getMaxLengthIncrease(int[] nums, int curMax, int index, Integer[][] cache) {
    if (curMax > 0) {
      if(cache[index][curMax]!=null) {
        return cache[index][curMax];
      }
    }

    if(index == nums.length) {
      return 0;
    }

    if(nums[index]>curMax) {
      int include = 1+getMaxLengthIncrease(nums, nums[index], index+1, cache);
      int exclude = getMaxLengthIncrease(nums, curMax, index+1, cache);
      if (curMax >= 0) {
        cache[index][curMax] = Math.max(include, exclude);
        return cache[index][curMax];
      }
      else {
        return Math.max(include, exclude);
      }

    }

    if (curMax >= 0) {
      cache[index][curMax] = getMaxLengthIncrease(nums, curMax, index+1, cache);
      return cache[index][curMax];
    }
    else {
      return getMaxLengthIncrease(nums, curMax, index+1, cache);
    }
  }

  private static int getMaxLengthIncrease(int[] nums, int curMax, int index, int length) {
    if(index == nums.length) {
      return length;
    }

    if(nums[index]>curMax) {
      int include = getMaxLengthIncrease(nums, nums[index], index+1, length+1);
      int exclude = getMaxLengthIncrease(nums, curMax, index+1, length);
      return Math.max(include, exclude);
    }

    return getMaxLengthIncrease(nums, curMax, index+1, length);
  }


  public static int coinChangeMin(int[] coins, int amount) {
    if(amount == 0) {
      return 1;
    }
    if(coins.length == 0) {
      return -1;
    }

    return coinCountMin(coins, amount, 0, 0);
  }

  private static int coinCountMin(int[] coins, int amount, int index, int count) {
    if(amount == 0) {
      return 1;
    }
    if(amount < 0) {
      return -999;
    }
    int min = 999;
    for(int i=index;i<coins.length;i++) {
      int result = coinCountMin(coins, amount-coins[i],i, count+1);
      if(result>0) {
        min = Math.min(min, count);
      }
    }

    return count;
  }

  public static boolean canJump(int[] nums) {
    return canJump(nums, 0, new Boolean[9999]);
  }

  private static boolean canJump(int[] nums, int index, Boolean[] cache) {
    if(cache[index]!=null) {
      return cache[index];
    }
    if(index==nums.length-1) {
      return true;
    }
    if(index>=nums.length) {
      return false;
    }

    for(int i = nums[index]; i >= 1; i--) {
      cache[index] = canJump(nums, i+index, cache);
      if(cache[index]){
        return true;
      }
    }

    cache[index] = false;
    return cache[index];
  }

  public int findDuplicate(int[] nums) {
    return Arrays.stream(nums).boxed()
        .collect(Collectors.collectingAndThen(
            Collectors.groupingBy(Function.identity(), Collectors.counting()),
            i->i.entrySet().stream()
                .filter(entry->entry.getValue()>1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1)
            ));
  }

  public static int[] searchRange(int[] nums, int target) {
    if(nums.length<1) {
      return new int[]{-1, -1};
    }
    if(nums.length==1) {
      return nums[0]==target?new int[]{0, 0}:new int[]{-1, -1};
    }
    if(nums.length==2 && nums[0]==nums[1] && target==nums[0]) {
      return new int[]{0, 1};
    }

    if(nums[0]==target && nums[nums.length-1]==target) {
      return new int[]{0, nums.length-1};
    }

    if(nums[0]==target && nums[1]!=target) {
      return new int[]{0, 0};
    }
    else if(nums[0]==target) {
      for(int i=1;i<nums.length-1;i++) {
        if(nums[i+1]!=target) {
          return new int[]{0, i};
        }
      }
    }

    if(nums[nums.length-1]==target && nums[nums.length-2]!=target) {
      return new int[]{nums.length-1, nums.length-1};
    }
    else if(nums[nums.length-1]==target) {
      for(int i=nums.length-2;i>=0;i--) {
        if(nums[i-1]!=target) {
          return new int[]{i, nums.length-1};
        }
      }
    }

    int first = searchRange(nums,target,0,nums.length-1, true);
    int second = -1;
    if(first != -1) {
      second = searchRange(nums,target,0,nums.length-1, false);
      if(second == -1) {
        second = first;
      }
    }
    return new int[]{first, second};
  }

  private static int searchRange(int[] nums, int target, int left, int right, boolean findFirst) {
    int mid = (left + (right - left) / 2);
    if(nums[mid] == target
        && ((findFirst && nums[mid-1] != target)
          || (!findFirst && nums[mid+1] != target))

    ) {
      return mid;
    }
    if(left == right) {
      return -1;
    }

    if(target==nums[mid] && findFirst) {
      return searchRange(nums, target, left, mid, findFirst);
    }
    else if(target == nums[mid] && !findFirst) {
      return searchRange(nums, target, mid+1, right, findFirst);
    }

    if (target < nums[mid]) {
      return searchRange(nums, target, left, mid, findFirst);
    } else {
      return searchRange(nums, target, mid+1, right, findFirst);
    }
  }

  public static int maxProduct(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int max = A[0], min = A[0], result = A[0];
    for (int i = 1; i < A.length; i++) {
      int temp = max;
      max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
      min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
      if (max > result) {
        result = max;
      }
    }
    return result;

  }

  public static int[] plusOne(int[] digits) {
    int[] result = new int[digits.length];
    int cur=digits.length-1;
    int carry = 0;
    boolean add = false;
    while(cur>=0) {
      if(!add) {
        result[cur] = digits[cur]+1;
        add=true;
      }
      else {
        result[cur] = digits[cur];
      }
      if(carry==1) {
        result[cur] = result[cur]+1;
      }

      if(result[cur]==10) {
        carry=1;
        result[cur]=0;
      }
      else {
        carry=0;
      }
      cur--;
    }

    if(result[0]==0) {
      result = new int[digits.length+1];
      result[0]=1;
    }

    return result;
  }

  public ArrayList groupAnagrams(String[] strs) {
    return new ArrayList<>(Arrays.stream(strs)
        .collect(Collectors.groupingBy(word ->word.chars()
                .sorted()
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining()),

            Collectors.toList())).values());
  }

  public static int uniquePaths(int m, int n) {
    return botGo(m, n, new Integer[m+1][n+1]);
  }

  private static int botGo(int m, int n, Integer[][] cache) {
    if(cache[m][n]!=null) {
      return cache[m][n];
    }
    if(m==1) {
      return 1;
    }

    if(n==1) {
      return 1;
    }

    cache[m][n] = botGo(m-1,n, cache)+botGo(m,n-1, cache);
    return cache[m][n];
  }

  public static List<Integer> topKFrequent(int[] nums, int k) {
    return Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(
            Function.identity(), Collectors.counting()
        ))
        .entrySet().stream()
        .sorted((f1, f2) -> Long.compare(f2.getValue(), f1.getValue()))
        .limit(k)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  public static int canCompleteCircuit(int[] gas, int[] cost) {
    if(gas.length==1) {
      return (gas[0]-cost[0])>0?0:-1;
    }
    int[] map = new int[gas.length];
    int total = 0;
    for(int i=0;i<gas.length;i++) {
      map[i] = gas[i]-cost[i];
      total+=map[i];
    }
    if(total<0) {
      return -1;
    }

    for(int i=0;i<map.length;i++) {
      if(map[i]>0) {
        if(driveToNext(map,map[i]+map[i==map.length-1?0:i+1], i, i==map.length-1?0:i+1)){
          return i;
        }
      }
    }
    return -1;
  }

  private static boolean driveToNext(int[] map, int curValue, int start, int index) {
    if(curValue<0) {
      return false;
    }
    if(index==start) {
      return true;
    }
    return driveToNext(map, curValue+map[index==map.length-1?0:index+1], start, index==map.length-1?0:index+1);
  }

  public static String removeKdigits(String num, int k) {
    if(num.length()==k) {
      return "0";
    }
    return removeKdigits(num, k, 0);
  }

  private static String removeKdigits(String num, int remaining, int index) {
    if(remaining==0 || index==num.length()) {
      return num;
    }

    String remove = removeKdigits(num.substring(0, index) + num.substring(index+1), remaining-1, index);
    String keep = removeKdigits(num, remaining, index+1);

    return Integer.valueOf(remove)>Integer.valueOf(keep)?keep:remove;
  }

  public static void solve(char[][] board) {
    if(board.length<=2 || board[0].length<=2) {
      return;
    }

    Boolean[][] cache = new Boolean[board[0].length][board.length];

    int row = board.length;
    int col = board[0].length;

    for(int i=1;i<row-1;i++) {
      for(int j=1;j<col-1;j++) {
        if(board[i][j] == 'O' && !canGoOut(board, i, j, cache)) {
          board[i][j] = 'X';
        }
      }
    }

    for(int i=0;i<board.length;i++) {
      for(int j=0;j<board[0].length;j++) {
        System.out.print(board[i][j]+",");
      }
      System.out.println();
    }
  }

  private static boolean canGoOut(char[][] board, int row, int col, Boolean[][] cache) {
//    if(cache[row][col]!=null) {
//      return cache[row][col];
//    }
    if(board[row][col]=='X') {
      return false;
    }

    if(row==0||col==0||row==board[0].length-1||col==board.length-1) {
      return true;
    }

    boolean goRight = false;
    boolean goLeft = false;
    boolean goUp = false;
    boolean goDown = false;
    if(board[row-1][col]!='X') {
      goUp = canGoOut(board, row-1,col,cache);
    }
    if(board[row+1][col]!='X') {
      goDown = canGoOut(board, row+1,col,cache);
    }
    if(board[row][col-1]!='X') {
      goLeft = canGoOut(board, row,col-1,cache);
    }
    if(board[row][col+1]!='X') {
      goRight = canGoOut(board, row,col+1,cache);
    }

    /*cache[row][col] =*/ return  goUp||goDown|goLeft||goRight;
//    return cache[row][col];
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> resultSet = new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    combinationSum(resultSet, result, candidates, target, 0);
    return resultSet.stream()
        .map(integers -> integers.stream().sorted().collect(Collectors.toList()))
        .distinct()
        .collect(Collectors.toList());
  }

  private static void combinationSum(List<List<Integer>> resultSet, List<Integer> result, int[] candidates, int target, int curSum) {
    if(curSum == target) {
      List<Integer> newResult = new ArrayList<>(result);
      resultSet.add(newResult);
      result.clear();
      return;
    }

    if(curSum > target) {
      result.clear();
      return;
    }

    for(int cur:candidates) {
      List<Integer> include = new ArrayList<>(result);
      include.add(cur);
//      result.add(cur);
      combinationSum(resultSet, include, candidates, target, cur+curSum);
//      result.remove(cur);
    }

    return;
  }
//abcaebcbb
  public static int longestSubstring(String s) {
    int n = s.length();
    Set<Character> set = new HashSet<>();
    int ans = 0, i = 0, j = 0;
    while (i < n && j < n) {
      // try to extend the range [i, j]
      if (!set.contains(s.charAt(j))){
        set.add(s.charAt(j++));
        ans = Math.max(ans, j - i);
      }
      else {
        set.remove(s.charAt(i++));
      }
    }
    return ans;

//    if(s.length()<2) {
//      return s.length();
//    }
//    if(s.length()==2) {
//      return s.charAt(0)==s.charAt(1)?1:2;
//    }
//
//    int first = 0;
//    int second = 1;
//
//    int maxLength = 0;
//    Set<Character> set = new HashSet<>();
//    set.add(s.charAt(0));
//    while(second != s.length()) {
//      if(first==second && second!=s.length()-1) {
//        second++;
//        set.add(s.charAt(second));
//      }
//      else if(set.contains(s.charAt(second))) {
//        maxLength = Math.max(second-first, maxLength);
//        if(s.charAt(first)!=s.charAt(second)) {
//          set.remove(s.charAt(first));
//        }
//        first++;
//      }
//      else {
//        set.add(s.charAt(second));
//        second++;
//      }
//    }
//    return maxLength;
  }

  public static List<List<Integer>> findSubsequences(int[] nums) {
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> curResult = new ArrayList<>();
    Arrays.sort(nums);
    findSubsequences(result, curResult, nums, 0);

    return result.stream().filter(i->!i.isEmpty() && i.size()>1).collect(Collectors.toList());
  }

  private static void findSubsequences(Set<List<Integer>> result, List<Integer> curResult, int[] nums, int index) {
    if(index == nums.length) {
      List<Integer> res = new ArrayList<>(curResult);
      result.add(res);
      curResult.clear();
      return;
    }

    List<Integer> include = new ArrayList<>(curResult);
    if(index == 0 || (nums[index] >= nums[index-1])) {
      curResult.add(nums[index]);
      findSubsequences(result, include, nums, index+1);
      findSubsequences(result, curResult, nums, index+1);
    }
    else {
      findSubsequences(result, curResult, nums, index+1);
    }
  }

}
