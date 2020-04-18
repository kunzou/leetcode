
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
}
