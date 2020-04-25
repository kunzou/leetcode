import java.util.*;

public class Main {
  public static void main(String[] args) {
    solve896();
  }

  static void solve896() {
//    int[] grid = {5,3,2,4,1};
    int[] grid = {-1,-1,0};
//    int[] grid = {6,5,4,4};
//    int[] grid = {1,2,2,3};
//        {"10","0001","111001","1","0"};
//        {"00", "000"};
    System.out.println(new LeetCode896().isMonotonic(grid));
  }

  static void sovlve973() {
    int[][] grid =
        {{3,3},{5,-1},{-2,4}};
    printArray(new LeetCode973().kClosest(grid, 2));
  }  
  
  static void AMZ_BattleShip() {
    String S = "1B 2C,2D 4D";
    String T = "2B 2D 3D 4D 4A";
//    String S="1A 1B,2C 2C";
//    String T="1B";
    System.out.println(new AMZ_BattleShip().solution(4, S, T));
  }

  static void sovlve474() {
    String[] grid =
//        {"10","0001","111001","1","0"};
        {"00", "000"};
    System.out.println(new LeetCode474().findMaxForm(grid, 3, 4));
  }


  static void sovlve63() {
    int[][] grid =
        {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
    System.out.println(new LeetCode63().uniquePathsWithObstacles(grid));
  }

  static void maxOfMinAltitudes() {
    int[][] numbers =
        {
            {6, 7, 8},
            {5, 4, 2},
            {8, 7, 6}
        };
    System.out.println(new AMZ_MaxOfMinAltitudes().minOfMinAltitudes(numbers));
  }

  static void solve64() {
    int[][] numbers =
        {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
/*    {
        {1,2},
        {1,1}
    };*/
    System.out.println(new LeetCode64().minPathSum(numbers));
  }


  static void solve990() {
    String[] numbers = {
        "f==a","a==b","f!=e","a==c","b==e","c==f"
    };
    System.out.println(new LeetCode990().equationsPossible(numbers));
  }


  static void solve992() {
    int[] numbers = {1,2,1,2,3};
    System.out.println(new LeetCode992().subarraysWithKDistinct(numbers, 2));
  }

  static void solve560() {
    int[] nums = {1,1,1};
    System.out.println(new LeetCode560().subarraySum(nums, 2));
  }

  static void solve416() {
    int[] nums =
//        {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        {1,2,5};
//        {1,2,3,5};

    System.out.println(new LeetCode416().canPartition(nums));
  }

  static void solve59() {
    printArray(new LeetCode59().generateMatrix(3));
  }

  static void solveAMZ_LoadBalancer() {
//    int[] numbers = {1, 3, 4, 2, 2, 2, 1, 1, 2};
    int[] numbers = {1,1,1,1,1,1};

    System.out.println(new AMZ_LoadBalancer().loadBalancer(numbers));
  }

  static void solveAMZ_FavoriteGenres() {
    Map<String, List<String>> userSongs = new HashMap<>();
    userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
    userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

    Map<String, List<String>> songGenres = new HashMap<>();
    songGenres.put("Rock", Arrays.asList("song1", "song3"));
    songGenres.put("Dubstep", Arrays.asList("song7"));
    songGenres.put("Techno", Arrays.asList("song2", "song4"));
    songGenres.put("Pop", Arrays.asList("song5", "song6"));
    songGenres.put("Jazz", Arrays.asList("song8", "song9"));


    System.out.println(new AMZ_FavoriteGenres().favoritegenre(userSongs, songGenres));
  }

  static void solve240() {
    int matrix[][] = //{{-1,3}};
/*        {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };*/
/*        {
            {1,  2, 3, 4, 5},
            {6,  7, 8, 9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25}
        };
    */

/*        {
            {1,4},
            {2,5}
        };*/

/*        {
            {1,  3, 5, 7, 9},
            {2,  4, 6, 8,10},
            {11,13,15,17,19},
            {12,14,16,18,20},
            {21,22,23,24,25}};*/

/*        {
            {2, 3, 8,11,15,19,20,20},
            {4, 8,12,15,18,21,25,28},
            {5, 8,17,20,22,23,30,34},
            {6,12,18,20,25,25,34,34},
            {9,14,21,24,25,29,39,40}};*/
        {
            {3,  6, 9,12,17,22},
            {5, 11,11,16,22,26},
            {10,11,14,16,24,31},
            {10,15,17,17,29,31},
            {14,17,20,23,34,37},
            {19,21,22,28,37,40},
            {22,22,24,32,37,43}};
      
        
    System.out.println(new LeetCode240().searchMatrix(matrix, 20));

  }

  static void solve572() {
    TreeNode treeNode = new TreeNode(4);
    treeNode.addLeft(new TreeNode(1)).addRight(new TreeNode(2));
    TreeNode treeNode1 = new TreeNode(3);
    treeNode1.addLeft(treeNode).addRight(new TreeNode(5));

    TreeNode treeNode2 = new TreeNode(4);
    treeNode2.addLeft(new TreeNode(1)).addRight(new TreeNode(2));

    TreeNode treeNode11 = new TreeNode(1);
    TreeNode treeNode22 = new TreeNode(1);
    treeNode11.addLeft(new TreeNode(1));

    System.out.println(new LeetCode572().isSubtree(treeNode11, treeNode22));
  }

  static void solve542() {
    int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};

    printArray(matrix);
    System.out.println();

    printArray(new LeetCode542().updateMatrix(matrix));
  }

  static void solveOptimalUtilization() {

    int[][] alist = {{1, 8}, {2, 7}, {3, 14}};
    int[][] blist = {{1, 5}, {2, 10}, {3, 14}};
    List<int[]> a = Arrays.asList(alist);
    List<int[]> b = Arrays.asList(blist);

    System.out.println(new AMZ_OptimalUtilization().getPairs(a, b, 20));

  }

  static void solveTreasure() {
    char[][] island = new char[][]{
        {'O', 'O', 'O', 'O'},
        {'D', 'O', 'D', 'O'},
        {'O', 'O', 'O', 'O'},
        {'X', 'D', 'D', 'O'}
    };
    System.out.println(new AMZ_TresureIsland().treasureIsland(island));
  }

  static void solve763() {
//    String s = "ababcbacadefegdehijhklij";
//    String s = "caedbdedda";
    String s = "eaaaabaaec";
//    String s = "vhaagbqkaq";
    System.out.println(new LeetCode763().partitionLabels(s));
  }

  static void solve937() {
    String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
    System.out.println(new LeetCode937().reorderLogFiles(logs));
  }

  static void solve1168() {
    String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
    String searchWord = "mouse";
    new LeetCode1268().suggestedProducts(products, searchWord);
  }

  static void solve286() {
    int[][] rooms = {{3,-1,0,1},{2,2,1,-1},{1,-1,2,-1},{0,-1,3,4}};
    new LeetCode286().wallsAndGates(rooms);
    printArray(rooms);
  }

  static void solve1192() {
    List<List<Integer>> lists = new ArrayList<>();
    lists.add(Arrays.asList(0,1));
    lists.add(Arrays.asList(1,2));
    lists.add(Arrays.asList(2,0));
    lists.add(Arrays.asList(1,3));
    System.out.println(new LeetCode1192().criticalConnections(4, lists));
  }

//739,560,234
  static void solve994() {
    int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
//    int[][] grid = {{0}};
//    int[][] grid = {{1,2}};
    System.out.println(new LeetCode994().orangesRotting(grid));
  }

  static void solve234() {
    ListNode listNode = new ListNode(0);
    listNode.addNode(1).addNode(0);
    System.out.println(new LeetCode234().isPalindrome(listNode));
  }

  static void solve116() {
    Stack<Integer> integers = new Stack<>();LinkedList linkedList = new LinkedList();
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    node2.addLeft(new Node(4)).addRight(new Node(5));
    node3.addLeft(new Node(6)).addRight(new Node(7));
    Node node1 = new Node(1);
    node1.addLeft(node2).addRight(node3);

    new LeetCode116().connect(node1);
  }

  static void solve151() {
    System.out.println(new LeetCode151().reverseWords(" 1"));
  }

  static void numbersWithEqualDigitSum() {
    int[] numbers = {51, 71, 17, 42, 33, 44, 24, 62};
    System.out.println(new MS_NumbersWithEqualDigitSum().numbersWithEqualDigitSum(numbers));
  }

  static void solve103() {
    TreeNode treeNode20 = new TreeNode(20);
    treeNode20.addLeft(new TreeNode(15)).addRight(new TreeNode(7));
    TreeNode node = new TreeNode(3);
    node.addLeft(new TreeNode(9)).addRight(treeNode20);

    new LeetCode103().zigzagLevelOrder(node);
  }

  static void solve53() {
    int[] nums = {1};
    System.out.println(new LeetCode53().maxSubArray(nums));
  }
  
  static void solve186() {
    char[] input = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
    new LeetCode186().reverseWords(input);
    System.out.println(input);
  }
  
  static void solve218() {
    int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//    int[][] buildings = {{0,2,3},{2,5,3}};
//    int[][] buildings = {{1,2,1},{1,2,2},{1,2,3}};
    new LeetCode218().getSkyline(buildings);
  }

  static void solve1() {
    int[] array = {2,3,4};
    printArray(new LeetCode1().twoSum(array, 6));
  }

  static void solve268() {
    int[] array = {3,0,1};
    System.out.println(new LeetCode268().missingNumber(array));
  }

  static void solve413() {
    int[] array = {1,2,3,5,7};
    System.out.println(new LeetCode413().numberOfArithmeticSlices(array));
//    Integer[] CACHE = new Integer[10];
//    System.out.println(new LeetCode413().getCount(7, CACHE));
  }

  static void solve445() {
    ListNode listNode1 = new ListNode(7);
    listNode1.addNode(2).addNode(4).addNode(3);

    ListNode listNode2 = new ListNode(5);
    listNode2.addNode(6).addNode(4);

    listNode1.print();
    listNode2.print();

    new LeetCode445().addTwoNumbers(listNode1, listNode2).print();

  }

  static void solve88() {
    int[] nums1 = {4,5,6,0,0,0};
    int[] nums2 = {1,2,3};
    new LeetCode88().merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }
  
  static void solve200() {
    char[][] grid =
//        {
//            {'1','0','1','1','1'},
//            {'1','0','1','0','1'},
//            {'1','1','1','0','1'}};
/*        {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}}  ;*/
        {  // 0   1   2   3   4   5   6
            {'1','1','1','1','1','1','1'},    //0
            {'0','0','0','0','0','0','1'},    //1
            {'1','1','1','1','1','0','1'},    //2
            {'1','0','0','0','1','0','1'},    //3
            {'1','0','1','0','1','0','1'},    //4
            {'1','0','1','1','1','0','1'},    //5
            {'1','1','1','1','1','1','1'}};   //6
    System.out.println(new LeetCode200().numIslands(grid));
  }

  static void solve235() {
    TreeNode treeNode = new TreeNode(2);
    TreeNode treeNode1 = new TreeNode(1);
    treeNode.addLeft(treeNode1);

    System.out.println(new LeetCode235().lowestCommonAncestor(treeNode, treeNode, treeNode1));
  }

  static void solve206() {
    ListNode head = new ListNode(1);
    head.addNode(2).addNode(3).addNode(4).addNode(5);
    head.print();

    LeetCode206.reverseList(head).print();
    LeetCode206.reverseListRecursively(head).print();
  }

  static void solve138() {
    NodeRamdom head = new NodeRamdom(7);
    head.addNode(13).addNode(11).addNode(10).addNode(1);
    head.next.setRandom(head);
    head.next.next.setRandom(head.next.next.next.next);
    head.next.next.next.setRandom(head.next.next);
    head.next.next.next.next.setRandom(head);
/*    Node head = new Node(3);
    head.addNode(3).addNode(3);
    head.next.setRandom(head);*/
    head.print();
    LeetCode138.copyRandomList(head).print();
  }

  static void solve273() {
    LeetCode273 leetCode273 = new LeetCode273();
//    System.out.println(leetCode273.numberToWords(99));
//    System.out.println(leetCode273.numberToWords(13271));
//    System.out.println(leetCode273.numberToWords(1100100));
    System.out.println(leetCode273.numberToWords(50868));
//    System.out.println(leetCode273.getSubThousandHelper(10000));
  }

  static void solve54() {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    System.out.println(new LeetCode54().spiralOrder(matrix));
  }

  static void solve171() {
    System.out.println(new LeetCode171().titleToNumber("ZY"));
  }

  static void solve348() {
    LeetCode348 leetCode348 = new LeetCode348(3);
    System.out.println(leetCode348.move(0,0,1));
    System.out.println(leetCode348.move(1,0,2));
    System.out.println(leetCode348.move(1,1,1));
    System.out.println(leetCode348.move(1,1,2));
    System.out.println(leetCode348.move(2,2,1));
  }

  static void printArray(int[] array) {
    System.out.println(Arrays.toString(array));
  }

  static void printArray(int[][] array) {
    for(int i = 0; i < array.length; i++) {
      printArray(array[i]);
//      System.out.println("\n");
    }
  }
}
