import java.util.*;

public class Main {
  public static void main(String[] args) {
    solve116();
  }

  static void solve116() {
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
}
