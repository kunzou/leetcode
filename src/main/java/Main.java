
import com.google.common.math.IntMath;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;

import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class Main {
  public static void main(String[] args) {
    solve1();
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
    Node head = new Node(7);
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
