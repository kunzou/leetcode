import com.google.common.math.IntMath;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class temp {

  /*  public static void main(String[] args) throws Exception {
    Config config = new Config();
    // use single Redis server
    config.useSingleServer().setAddress("redis://127.0.0.1:6379");
    RedissonClient redisson = Redisson.create(config);
    // perform operations
    RBucket<String> bucket = redisson.getBucket("simpleObject");
//    bucket.set("This is object value");
    RMap<String, String> map = redisson.getMap("simpleMap");
//    map.put("mapKey", "This is map value");
    String objectValue = bucket.get();
    System.out.println("stored object value: " + objectValue);
    String mapValue = map.get("mapKey");
    System.out.println("stored map value: " + mapValue);
    redisson.shutdown();
  }*/

  public static int solution(int[] A, int K, int L) {
    if (A.length < K + L) {
      return -1;
    }
    return Math.max(getConditionOneResult(A,K,L), getConditionTwoResult(A,K,L));

  }

  private static int getConditionOneResult(int[] A, int K, int L) {
    Result firstResult = calculateMax(A, K, 0, A.length);
    return firstResult.getMax()+Math.max(calculateMax(A, L, 0, firstResult.getStart()).getMax(), calculateMax(A, L, firstResult.getEnd()+1, A.length).getMax());
  }

  private static int getConditionTwoResult(int[] A, int K, int L) {
    Result firstResult = calculateMax(A, L, 0, A.length);
    return firstResult.getMax()+Math.max(calculateMax(A, K, 0, firstResult.getStart()).getMax(), calculateMax(A, K, firstResult.getEnd()+1, A.length).getMax());
  }

  private static Result calculateMax(int[] array, int n, int start, int end) {
    int max = 0;
    if(start>=array.length) {
      return new Result(0, -1, -1);
    }
    for (int i=start; i<start+n; i++) {
      max += array[i];
    }

    int curSum = max;
    int resultStart = 0;
    int resultEnd = 0;
    for (int i=n+start; i<=end-1; i++) {
      curSum += array[i] - array[i-n];
      if(curSum > max) {
        max = curSum;
        resultStart = i-n+1;
        resultEnd = i;
      }
    }

    return new Result(max, resultStart, resultEnd);
  }

  static class Result {
    private int max;
    private int start;
    private int end;

    public Result(int max, int start, int end) {
      this.max = max;
      this.start = start;
      this.end = end;
    }

    public int getMax() {
      return max;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }
  }
/*
  private static int caseOne(int[] A, int K, int L) {
    int maxK = 0;
    int maxKIndex = 0;
    int sumK;
    for(int i=0;i<A.length-K;i++) {
      sumK = sumK(A, i);
      if(sumK>maxK) {
        maxK = sumK;
        maxKIndex = i;
      }
    }

    int max2 = 0;
    int sum2;
    for(int i=0;i<A.length-2;i++) {
      if(i != max3Index) {
        sum2 = sum2(A, i);
        if(sum2>max2) {
          max2 = sum2;
        }
      }
    }
    return max2+maxK;
  }

  private static int caseTwo(int[] A, int K, int L) {
    int max2 = 0;
    int sum2;
    int max2Index = 0;

    for(int i=0;i<A.length-2;i++) {
      sum2 = sum2(A, i);
      if(sum2>max2) {
        max2 = sum2;
        max2Index = i;
      }
    }

    int max3 = 0;
    int sum3;
    for(int i=0;i<A.length-3;i++) {
      if(i != max2Index) {
        sum3 = sumK(A, i);
        if(sum3>max3) {
          max3 = sum3;
        }
      }
    }

    return max2+max3;
  }

  private static int sumK(int[] array, int index) {
    return array[index]+array[index+1]+array[index+2];
  }

  private static int sum2(int[] array, int index) {
    return array[index]+array[index+1];
  }*/

//  public static int solution(int[] ranks) {
//    Map<Integer, Long> numberMap = Arrays.stream(ranks).boxed()
//        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//    int count = 0;
////    for(int i=0;i<ranks.length;i++) {
//    for(int i:ranks) {
//      if(numberMap.containsKey(i+1) && numberMap.get(i+1)>0) {
//        count++;
//        numberMap.computeIfPresent(i+1, (k,v)->v-1);
//      }
//    }
//    return count;
//  }

//  public static int solution(int[] ranks) {
//    Set<Integer> set = Arrays.stream(ranks).boxed().collect(Collectors.toSet());
//
//    return Arrays.stream(ranks).boxed()
//        .filter(i->set.contains(i+1))
//        .mapToInt(i -> 1)
//        .sum();
////    int count = 0;
////    for(int i:ranks) {
////      if(set.contains(i+1)) {
////        count++;
////      }
////    }
////    return count;
//  }



  /*
   *//*    BinaryTree tree = new BinaryTree();

    // Let us create the tree shown in above diagram
    tree.root = new Node(10);
    tree.root.left = new Node(12);
    tree.root.right = new Node(15);
    tree.root.left.left = new Node(25);
    tree.root.left.right = new Node(30);
    tree.root.right.left = new Node(36);
    tree.root.right.left.left = new Node(36);

    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);*//*

//    int[] arr1 = {1,3};
    Integer[] arr2 = {0,0,1,2,3,3,4,7,7,8};

    int[] values =  {10, 40, 30, 50,90,100,70,80,50,60,20,10,50,40,90,80};
    int[] weights = {5,   4,  6,  3, 6, 2,  5, 7, 6, 8, 7, 5, 4, 8, 5, 4};

    final long startTime = System.currentTimeMillis();


    File file = new File("/home/kun/workspace/json1");
    String content = FileUtils.readFileToString(file, Charset.defaultCharset());
    Gson gson = new Gson();
    JsonObj obj = gson.fromJson(content, JsonObj.class);
//    JsonObject obj = gson.fromJson(content, JsonObject.class);

//    String firstName = obj.get("address").getAsString();

//    JSONObject obj = new JSONObject(content);
//    System.out.println(obj.getString("lastName"));

    System.out.println(obj);



//    System.out.println(Solution.maxProfit(arr2));
//    int n = 5;int capacity = 30;
//    int[][] cache = new int[n+1][capacity+1];

//    String[] words = {"abc","deq","mee","aqq","dkd","ccc"};



//    ListNode listNode = new ListNode(1);
//    listNode.next = new ListNode(2);
//    listNode.next.next = new ListNode(3);
//
//    ListNode listNode2 = new ListNode(1);
//    listNode2.next = new ListNode(2);
//    listNode2.next.next = new ListNode(4);

//    listNode.next.next.next = new ListNode(4);
//    listNode.next.next.next.next = new ListNode(5);

//    int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
//    String[] arr = {"leet", "code"};

    int[] gas  = {1,2,3,4,5};
    int[] cost = {3,4,5,1,2};


//    [1,2,3,4,5]
//    [3,4,5,1,2]

//    [5,1,2,3,4]
//    [4,4,1,5,1]

    char[][] board = {
        {'X','X','X','X'},
        {'X','O','O','X'},
        {'X','X','O','X'},
        {'X','O','X','X'}
    };
//    Solution.solve(board);

    int[] arr = {-8,28,68,-54,96,97,84,-32,8,-87,1,-7,-20,12,22};







//    System.out.println(Solution.findSubsequences(arr));
//    Solution.mergeTwoLists(listNode, listNode2).print();

//    System.out.println(Arrays.stream(Solution.plusOne(arr)).boxed().collect(Collectors.toList()));

    final long endTime1 = System.currentTimeMillis();

    System.out.println("Time consume:" + (endTime1 - startTime));

//    System.out.println(Solution.fibMemo(n));

//    final long endTime2 = System.currentTimeMillis();
//    System.out.println("Time consume:" + (endTime2 - endTime1));


//    System.out.println(Arrays.stream(Solution.maxProfit(arr2,7)).boxed().collect(Collectors.toList()));



//    System.out.println(getUniqueCharacterSubstring("abcabcbb"));
  }*/

  //123456
  static int reverseInteger(int n) {
    int pow = 0;
    int output = 0;
    while(n!=0) {
      output = output*10+n%10;
      n=n/10;
      pow++;
    }
    return output;
  }

  static int steps(int n) {
    if(n==0) {
      return 1;
    }

    if(n==1) {
      return 1;
    }

    return steps(n-1)+steps(n-2);
  }

  static int maxSubArray(int[] A) {
    int max = A[0];
    int[] sum = new int[A.length];
    sum[0] = A[0];

    for (int i = 1; i < A.length; i++) {
      sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
      max = Math.max(max, sum[i]);
    }

    return max;
  }

  static TrinaryNode removeNthFromEnd(TrinaryNode root, int n) {
    Queue<TrinaryNode> queue = new LinkedList<>();

    TrinaryNode cur = root;
    while(cur!=null) {
      cur=cur.next;
      if (queue.size() >= n+1) {
        queue.poll();
      }
      queue.add(cur);
    }
    cur = queue.poll();
    if(cur.next!=null && cur.next.next!=null) {
      cur.next=cur.next.next;
    }

    return root;
  }

  //"abcabcbb"
  static String longestString(String input) {
    int length = input.length();
    int begin = 0;
    int end = 0;
    Set<Character> set = new HashSet<>();

    while(/*begin<length && */end<length) {
      Character cur = input.charAt(end);
      set.add(cur);
    }
    return null;
  }

  static String getUniqueCharacterSubstring(String input) {
    Map<Character, Integer> visited = new HashMap<>();
    String output = "";
    for (int start = 0, end = 0; end < input.length(); end++) {
      char currChar = input.charAt(end);
      if (visited.containsKey(currChar)) {
        start = Math.max(visited.get(currChar)+1, start);
      }
      if (output.length() < end - start + 1) {
        output = input.substring(start, end + 1);
      }
      visited.put(currChar, end);
    }
    return output;
  }

  static String getUniqueCharacterSubstringBruteForce(String input) {
    String output = "";
    for (int start = 0; start < input.length(); start++) {
      Set<Character> visited = new HashSet<>();
      int end = start;
      for (; end < input.length(); end++) {
        char currChar = input.charAt(end);
        if (visited.contains(currChar)) {
          break;
        } else {
          visited.add(currChar);
        }
      }
      if (output.length() < end - start + 1) {
        output = input.substring(start, end);
      }
    }
    return output;
  }

  static void copy(TrinaryNode oldTrinaryNode, TrinaryNode newTrinaryNode) {
    if(oldTrinaryNode.left!=null) {
      newTrinaryNode.left = new TrinaryNode(oldTrinaryNode.left.data);

      copy(oldTrinaryNode.left, newTrinaryNode.left);
    }

    if(oldTrinaryNode.right!=null) {
      newTrinaryNode.right = new TrinaryNode(oldTrinaryNode.right.data);

      copy(oldTrinaryNode.right, newTrinaryNode.right);
    }
  }

  static int maxDepth(TrinaryNode trinaryNode) {
    if(trinaryNode == null) {
      return 0;
    }
    else {
      int ld = maxDepth(trinaryNode.left);
      int rd = maxDepth(trinaryNode.right);
      return Math.max(ld, rd)+1;
    }
  }

  static void reverse(TrinaryNode root) {
    if(root == null) {
      return;
    }

    reverse((root.next));
    System.out.print(root.data+" ");
  }

  static void inorder(TrinaryNode trinaryNode, List<TrinaryNode> list) {
    if(trinaryNode !=null) {
      inorder(trinaryNode.left, list);
//      list.add(node);
      System.out.print(trinaryNode.data+" ");
      inorder(trinaryNode.right, list);
    }
  }

  static void inorderNR(TrinaryNode root, List<TrinaryNode> list) {
    if (root == null)
      return;

    Stack<TrinaryNode> s = new Stack<>();
    TrinaryNode curr = root;

    // traverse the tree
    while (curr != null || !s.isEmpty()) {

            /* Reach the left most Node of the
            curr Node */
      while (curr !=  null) {
                /* place pointer to a tree node on
                   the stack before traversing
                  the node's left subtree */
        s.push(curr);
//        System.out.print(curr.data+" ");
        curr = curr.left;
      }

      /* Current must be NULL at this point */
      curr = s.pop();

      System.out.print(curr.data + " ");
//      list.add(curr);
            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
      curr = curr.right;
    }


  }

  //[ S : ADOBECODEBANC | T :"ABC" ]
  static String minWindow(String s, String t) {
    HashMap<Character, Integer> table = new HashMap<>();

    // initialize frequency table for t
    for(Character c : t.toCharArray()) {
      table.put(c, 1);
    }

    // initialize sliding window
    int begin = 0, end = 0;
    int counter = table.size();
    int len = Integer.MAX_VALUE;

    String ans = "";

    // start sliding window
    while(end < s.length()){
      Character endchar = s.charAt(end);

      // if current char found in table, decrement count
      if(table.containsKey(endchar)){
//        table.get(endchar)--;
        table.replace(endchar, table.get(endchar)-1);

        if(table.get(endchar) == 0) {
          counter--;
        }
      }

      end++;

      // if counter == 0, means we found an answer, now try to trim that window by sliding begin to right.
      while(counter == 0){
        // store new answer if smaller than previously best
        if(end-begin < len){
          len = end - begin;
          ans = s.substring(begin, end);
        }

        // begin char could be in table or not,
        // if not then good for us, it was a wasteful char and we shortened the previously found substring.

        // if found in table increment count in table, as we are leaving it out of window and moving ahead,
        // so it would no longer be a part of the substring marked by begin-end window
        // table only has count of chars required to make the present substring a valid candidate
        // if the count goes above zero means that the current window is missing one char to be an answer candidate
        Character startchar = s.charAt(begin);

        if(table.containsKey(startchar)){
          table.replace(startchar, table.get(startchar)+1);
          if(table.get(startchar) > 0) {
            counter++;
          }
        }

        begin++;
      }
    }

    return ans;
  }

  static List<Integer> maxSlidingWindow(List<Integer> numbers, int k) {
    Deque<Integer> deque = new LinkedList<>();
    List<Integer> result = new ArrayList<>();

    for(int i=0;i<numbers.size();i++) {
      if(!deque.isEmpty() && deque.peekFirst()==i-k) {
        deque.removeFirst();
      }

      while(!deque.isEmpty() && numbers.get(deque.peekLast())<numbers.get(i)) {
        deque.removeLast();
      }

      deque.addLast(i);
      if(i>=k-1) {
        result.add(numbers.get(deque.peekFirst()));
      }
    }
    return  result;
  }

  static int fractional(int n) {
    if(n==0) {
      return 1;
    }

    return n*fractional(n-1);
  }

  static int fib(int n) {
    if(n==0){
      return 0;
    }
    if(n==1) {
      return 1;
    }

    return fib(n-1)+fib(n-2);
  }

  static void kLargest(int[] input, int x, int k) {
    TreeSet<Pair<Integer, Integer>> set = new TreeSet<>();

    for(int i=0;i<input.length;i++) {
      if(set.size()<k) {
        set.add(new MutablePair<>(Math.abs(x - input[i]), input[i]));
      }
      else {
        int diff = Math.abs(x-input[i]);
        if(diff<set.last().getKey()) {
          set.pollLast();
          set.add(new MutablePair<>(diff, input[i]));
        }
      }



    }

    set.stream()./*map(i->i.getKey()).*/forEach(System.out::println);
  }

  static int[] rotateMatrix(int[] input) {
    int n = IntMath.sqrt(input.length-1, RoundingMode.HALF_UP);
    int[] output = new int[input.length];
    int[][] matrix = new int[n][n];

    for(int row=0;row<n;row++) {
      for(int col=0;col<n;col++) {
        matrix[row][col] = input[n*row+col];
        System.out.print(matrix[row][col] + " ");
      }
      System.out.println();
    }
    System.out.println("after");

    int count = 0;
    for(int row=n-1;row>=0;row--) {
      for(int col=0;col<n;col++) {
        output[count] = matrix[col][row];
        count++;
        System.out.print(matrix[col][row] + " ");
      }
      System.out.println();
    }

    return output;
  }

  public static int[] stockSpan(int[] prices){

    Stack<Integer> s = new Stack();
    int[] span = new int[prices.length];

    //Step 1. Initialization
    span[0] = 1;
    s.push(0);

    for(int i=1; i<prices.length; i++){
      //Find the price on stack which is greater than current day's price
      while(!s.empty() && prices[i] > prices[s.peek()]) {
        s.pop();
      }

      if(s.empty())
        span[i] = i+1;
      else
        span[i] =  i - s.peek();

      //Push current day onto top of stack
      s.push(i);
    }

    return span;
  }

  public static int[] getNextGreater() {
//    int[] numbers = new int[]{4, 5, 2, 25};
    int[] numbers = new int[]{4, 73, 21, 25};
//    int[] allNumbers = new int[]{4, 5, 2, 25, 73, 11, 85, 45, 21, 1, 56};
    int[] allNumbers = new int[]{4, 73, 21, 25};
    TreeMap<Integer, Integer> mapOfLocations = new TreeMap<>();

    for(int i = 0; i<allNumbers.length;i++) {
      mapOfLocations.put(allNumbers[i], i);
    }

    List<Map.Entry<Integer, Integer>> listOfLocationTree = new ArrayList<>(mapOfLocations.entrySet());
    int[] result = new int[numbers.length];

    HashMap<Integer, Integer> nextGreaterHashMap = new HashMap<>();

    for(int i = 1; i < listOfLocationTree.size();i++) {
      Map.Entry<Integer, Integer> cur = listOfLocationTree.get(i-1);
      Map.Entry<Integer, Integer> next = listOfLocationTree.get(i);
      nextGreaterHashMap.put(cur.getKey(), next.getValue());
    }
    nextGreaterHashMap.put(listOfLocationTree.get(listOfLocationTree.size()-1).getKey(), -1);

    for(int i=0;i<numbers.length;i++) {
      result[i] = nextGreaterHashMap.get(numbers[i]);
    }
    return result;
  }


  public static int maxSum(int arr[]) {
    int excl = 0;
    int incl = arr[0];
    for (int i = 1; i < arr.length; i++) {
      int temp = incl;
      incl = Math.max(excl + arr[i], incl);
      excl = temp;
    }
    return incl;
  }

//  List<Pair<Integer, Integer>> getListWithSumOf(List<Pair<Integer, Integer>> list, Integer sum) {
//    return integers.stream()
//        .filter(i->numberSet.contains(sum-i))
//        .map(i-> new MutablePair<>(i, sum - i))
//        .collect(Collectors.toList());
//  }

//  List<Set<Integer>> getListWithSumOf(Set<Integer> pairs, Integer sum, Set<Integer> numbers) {
//    return pairs.stream().
//  }


  Integer getListWithSumOf(Integer integer, Integer sum, Set<Integer> numbers) {
    return numbers.contains(sum-integer)?sum-integer:null;
  }
/*
  GraphNode createGraph() {
    GraphNode node40 =new GraphNode(40);
    GraphNode node10 =new GraphNode(10);
    GraphNode node20 =new GraphNode(20);
    GraphNode node30 =new GraphNode(30);
    GraphNode node60 =new GraphNode(60);
    GraphNode node50 =new GraphNode(50);
    GraphNode node70 =new GraphNode(70);

    node40.addneighbours(node10);
    node40.addneighbours(node20);
    node10.addneighbours(node30);
    node20.addneighbours(node10);
    node20.addneighbours(node30);
    node20.addneighbours(node60);
    node20.addneighbours(node50);
    node30.addneighbours(node60);
    node60.addneighbours(node70);
    node50.addneighbours(node70);

    return node40;
  }

  public static void bfs(GraphNode node) {
    Queue<GraphNode> queue = new LinkedList<>();
    queue.add(node);
    node.visited=true;
    while (!queue.isEmpty()) {
      GraphNode element=queue.poll();
      System.out.print(element.data + " ");
      element.getNeighbours().stream()
          .filter(n->n!=null && !n.visited)
          .forEach(n->{
            queue.add(n);
            n.visited=true;
          });

    }
  }

  // Recursive DFS
  public static void dfs(GraphNode node) {
    System.out.print(node.data + " ");

    node.visited=true;
    node.getNeighbours().stream()
        .filter(n->n!=null && !n.visited)
        .forEach(temp::dfs);
  }

  public static void dfsUsingStack(GraphNode node) {
    Stack<GraphNode> stack= new Stack<>();
    stack.add(node);
    node.visited=true;
    while (!stack.isEmpty()) {
      GraphNode element=stack.pop();
      System.out.print(element.data + " ");
      element.getNeighbours().stream()
          .filter(n->n!=null && !n.visited)
          .forEach(n->{
            stack.add(n);
            n.visited=true;
          });

    }
  }*/

  public static TrinaryNode LCA(TrinaryNode root, TrinaryNode a, TrinaryNode b) {
    if (root == null) {
      return null;
    }

    // If the root is one of a or b, then it is the LCA
    if (root == a || root == b) {
      return root;
    }

    TrinaryNode left = LCA(root.left, a, b);
    TrinaryNode right = LCA(root.right, a, b);

    // If both nodes lie in left or right then their LCA is in left or right,
    // Otherwise root is their LCA
    if (left != null && right != null) {
      return root;
    }

    return (left != null) ? left : right;
  }

  static void traverse(TrinaryNode trinaryNode, List<TrinaryNode> route) {
    if(trinaryNode != null) {
      route.add(trinaryNode);
      traverse(trinaryNode.left, route);
      traverse(trinaryNode.right, route);
    }
  }

  static void traverseForData(TrinaryNode trinaryNode, List<TrinaryNode> route, int data) {
    if(trinaryNode != null) {
      route.add(trinaryNode);
      traverseForData(trinaryNode.left, route, data);
      traverseForData(trinaryNode.right, route, data);
    }
  }

  static List<Integer> createIntegerList(int n) {
    return IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
  }

  static List<Integer> getSquare(List<Integer> source) {
    return source.stream()
        .map(i->i*i)
        .collect(Collectors.toList());
  }

  static List<Triple<Integer, Integer, Integer>> getPairWithSumMatchesValueFromList(List<Integer> list, Integer sum) {
    Set<Integer> numbers = new HashSet<>(list);
    return list.stream()
        .filter(i->numbers.contains(sum-i))
        .map(i-> new MutableTriple<>(IntMath.sqrt(i, RoundingMode.HALF_UP), IntMath.sqrt(sum - i, RoundingMode.HALF_UP), IntMath.sqrt(sum, RoundingMode.HALF_UP)))
        .collect(Collectors.toList());
  }


  static String sortPattern(String pattern) {
    char[] sorted = pattern.toCharArray();
    Arrays.sort(sorted);

    return new String(sorted);
  }




//           Map<Integer, Long> counts = list.stream()
//            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        System.out.print("Union: ");
//
//        counts.keySet().forEach(i->System.out.print(i+ " "));
//
//        System.out.println();
//
//
//        System.out.println("Intersection: " +
//            counts.entrySet().stream()
//                .filter(entry->entry.getValue().equals(2L))
//                .map(Map.Entry::getKey)
//                .collect(Collectors.toList())
//        );
//
//System.out.print(findBinaryGap(20));




  static class Graph{
    int vertices;
    LinkedList<Integer>[] adjList;

    Graph(int vertices){
      this.vertices = vertices;
      adjList = new LinkedList[vertices];
      for (int i = 0; i <vertices ; i++) {
        adjList[i] = new LinkedList<>();
      }
    }
    public void addEgde(int source, int destination){
      adjList[source].addFirst(destination);
    }

    public void printGraph(){
      for (int i = 0; i <vertices ; i++) {
        if(adjList[i].size()>0) {
          System.out.println("Vertex " + i + " is connected to: ");
          for (int j = 0; j < adjList[i].size(); j++) {
            System.out.print(adjList[i].get(j) + " ");
          }
          System.out.println();
        }
      }
    }

    public void DFSRecursion(int startVertex){
      boolean [] visited = new boolean[vertices];
      dfs(startVertex, visited);
    }

    public void dfs(int start, boolean [] visited){
      visited[start] = true;
      System.out.print(start + " ");
      for (int i = 0; i <adjList[start].size() ; i++) {
        int destination = adjList[start].get(i);
        if(!visited[destination])
          dfs(destination,visited);
      }
    }
  }

  public static void dfs() {
    int vertices = 6;
    Graph graph = new Graph(vertices);
    graph.addEgde(0, 1);
    graph.addEgde(0, 2);
    graph.addEgde(1, 2);
    graph.addEgde(1, 3);
    graph.addEgde(3, 4);
    graph.addEgde(2, 3);
    graph.addEgde(4, 0);
    graph.addEgde(4, 1);
    graph.addEgde(4, 5);
    System.out.println(graph);

    graph.DFSRecursion(0);
  }

  static int findBinaryGap(int input) {
    System.out.println(Integer.toBinaryString(input));
    return Arrays.stream(Integer.toBinaryString(input).split("1")).mapToInt(String::length).max().getAsInt();
  }

  static String holy = "99641436378815361153471302158193420182863684789411484994976484827114595334610042544056442370530816060833617030976813134098793056155103202008549344446519354408307307071055065112738442020228471569394796174150323080161225901964338837341524253243218509500254619223683091799365677720582389568156585225666197123093377871100002481402486219837255411382162499321193416524972275273471969155848742457476556433737281147710021781210134765321761285612276511917324552585569882156635094670362653567596144728653795007023230933817566104488637696450166087905100823699425798763598444326069357052842379918535855296915760054459317433521878778171811081076593166663090948029793113626852462712388116483774713426183911481230884393594249331828165503798269634244430773693033882708000249632850148799859322024693146577635543114657662418998860517525989192973250701631765598465053097616804817344343895016724561947860836117504915797011185132674255278236597746042138768473723059825948301565719437610732907662545499042953499866813741157301003371005200992314265077531029437948931255617153417148822355928318598517533241719641002712204874161001604269216566928220767474713135516717997491363360204764154264989004671363541097433484822118483642107547658581450616821769964767032521138851570822729134762460014265433227201724724004338494552397280090568164786109721571436206198382814849033856987338787473335772666933218810822482848994610491705665155516384799459418594559136827941106387689501641851101743298582575466303864906673788496628288920867422193950180810131396612913851112593807649152972068279299934113463669714575613645929365652921808836725682390026075559320995704880149764583379697505303474550029059828116836469203370428449330442281563135568935742669243344218603994417955703485059862132359688776290378210392955310785874528205203788559715493852405991380290274268143557970398441851157977520689440430265144029789788511042795879174567381358510694749512938934687979305099149575464220629804942550564164786808856897809863824121659548034395539735407069279457678613909222371848892294754933299091164656871086269084324529512544747434123547189729993758337622038098699448815701644934651292719067683227727438808955969543542319197883567369733867364250353136697865107182282929655918362211832327827571354787535611501731943856155003853732339819594939524719169561110698571676562329360803282215467534058504728127731515598941143637827010955579092451405821352126706550438315176049692316210490899702613078702535716735901806171522853021035597316703390478571485677998207922773938829371460838611214446417528913575284776737837046439695408523434414916342979688820197836458637694991540998291690345194205452439239827382953039810367712244590155940394387554911786652478111954297185544106384174592451680875083737874735810068767866214924634885513828808880161930987276602570872860752119813042414550396358433893592777541756673206882876746731707766966268096104320061937913505893028833592137540396064375155513979764728180927083060481127522118240026140625647313783901073938419240249929000962722034273952683635919540169732220854978101308126446671885186032295490845060116567165945677975672981321362161949418405852378788584602802612398876874288293756055559457538271197205867506313677160755990736347314715042607243878693780144368083800080967842966193539823770427967091132770230485036143223363387876244958899577538069175123004651952588711287008791159682042581943812962882375293348462523257081140457567348612069746943329842264291823570671268374580651696311114624358304235261945894627668267192756606441264485628097480920062857007640396910214970556623416565940789636657349735150043836194242061994234044262604284350296258397208287158735477739515615890093167555389262170576609082365199242352356197706754361085079177223144662701424848070607319078068303190442737202186364818021792860690571733432439513976759807778513151206801184300729685910765785586373831699595178352610150383283823456881293647763022411686252640648120690251120902631370825525354213297549430441989419362406888242180413640397005462289002837178086683143441254722528075315187910994986929463063282350677644105312484770818851268755183086729904524488901102287310169865855725358976453628171038414004415469635124255044890245890050115901243603489384920067923087045070616429510114587493955384903357111302068595548921504222171096098548413208088831560744996899783844118318185694142620796984004522106434428513215881883542758888862576036415421097762413907290417004936441609238204617100586876487061497586106631983740139555573272626681186969272113315348553052708453716313010811194726904231406455432865684477036960953564406390115786323388585604716504384778912812410729908949581143722120318954849846535676912868526526501078193502393524062471534154104899815734648650035608611113327222040864146091286020205304970098510045582130989981665393076480660907742469107193219475618455618115516353495211289597815564506193368287178714208989206470099207227171770619580227427772058576958549342547850566371060314330889132466260972915500785842700966615103949831075688522846389635990078358138687466663099265099431775674237640711466272609872329090894406587154198409486434056948991642623725868520261081714501891452704954562834244485695899485150794033902595303371632597184940525684558272222395813587950566598836575728711404672894869851301199508345442816914540274231773573695049117433232750564343477296571911336451338765122801905492189124021699698020217831160061375249740348841211772476455089061870953510480256335713228323198782026742817220321247980121667780800877801219532811542139900480803615083739957513418528009253849655053312995534574307148952727627870318872325094411860749809155407484065987101730385346571248798467212335910821152286411077915790397497756477613051365987943518909759211252763081626026136209474490841118337332773116122063152414208776801671614382203998310801791046109980464795153775904284579208046765170299376571712696359391195309011046580945099118345329164807866461624513459858969478261348365746242842254100449074846018162381649508771205692387943049083877156128753239386498305599949138477358461424273464036997642435352074743094695564535693378173888280633866732018710701060752702258884562187458492514181027419045608607139753797741693225900923436163273291784047946102859573341135995351940672974945745062320931107916232460722010886651827074516009065280667168017782964663521168472263155891094369134584611694802620433621767214124173962636180142978128638945692419270222518432363382128100260544917455244318162619360808797214154001396840051520865249909119773623276044783996235484958441702533661095335337458603732924068113476544273220040621287278168707393471504842692312354782265568742305367773635557008065688109790648713350572351799924638273829816187626279342407486758617884199669669286080608957640162096427744397522103026413782698158732581790000716751490076906346484023835702438474105176931779065689980130347837155056303467742499515965713045957954225592059807462917282749105358673064716135765849677591608061323905019687616579401117839719269327243007586938365568212311638431283680946079388989080798521721770825311237382299640977231722390040018733060008726711369177955792504805871660952275133036361448257222162174106121886956846208577175900217031085260775753651365765038925717954695019720235653672968689019573262654460436772900765775615489257834882352941349073672575670561593061387879337673233294306479935031268311515186416299622966578517978675818927585118344348361158710756313053131716293124192982037977789379782122120656399498488608931743952536041546453299501041577456229618221253519224906611827751220393777623642577532653929191439603183004880021982807536023221789599010502125687724004685177438516674638976736887749480118357141229355178588718777866510629202733751110559334924038607709059709853979249569510212755627954315025008066453716096825677236680969921750877126730256949811077056975031686370565845816981036167892330455103497165407984322792515265566483796338273488042877728447328933645773410093062365682687268013318931065552717013674172822704288279197461978805944285413220284999303849740540429893025407810120053701999064303195562726870079068213843151094378846458471168159763363401468459072474435300433314015701363633705309153196187013664717617975618648227816754951474354742056233896619815305871556180590934191775446450232435064334173434855333465262160341517250209548644211312373841441024747539900101488865742679168673356769004244781832745045012713439497231232255815861738982590755401780194874615548229070120796893835181030047378827641086164272219294123942746140207443292075817414598536256892540490923602419336928186124051416665048479530882042184097629985897052425322145715174649893481917612568426372077919256931921063600255204010662044398922537796993713110889134889921360833579323314386803074533058134342770923839546994120322442157750203621967931319597649960815556196358566683782572730174920215034531104191490057838260392829741446722127017532444082857280503217574522928285094747407153894570747792487061998260753833304433675066923630595212677695003060727653119915126939127827754432456052655283764591328484359469704894122366077507922825301623961196207923544095047285011474898262448957681893278273601046641810135121516552187096005252171171905022763076761687166299014789581539855448453229411352775826042558462563147630238335355859149814380543807473386539264830261256996173935860136236427622918234260408201158550118527706241993700526213016072648406003487895118011337828945314863348154387066988573131543747121745028364818130265528614742576976975564213718421245904443000581698214695522541683926528961160986876871840844632069685227319014872180179370554032205521013345746425253133686231659075343389374580200717637698542920298315739628019867736462368334051114029380922339886663078026309916370486909128253195100898377068612057592121356555290537815049586626181680384845905180029133497372417653664436161971980137048236053329456957495141918670077299206755740534997886723627476115663811233372206043170460623060506091246306386543951687123557178508806912199010111871";

}
