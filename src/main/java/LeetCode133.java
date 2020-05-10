import java.util.*;

public class LeetCode133 {
  public void runner() {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    node1.neighbors = Arrays.asList(node2,node4);
    node2.neighbors = Arrays.asList(node1,node3);
    node3.neighbors = Arrays.asList(node2,node4);
    node4.neighbors = Arrays.asList(node1,node3);

    Node clone = cloneGraph(node1);
  }

  public Node cloneGraph(Node node) {
    Map<Integer, Node> cache = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    Node clone = new Node(node.val);
    queue.add(node);
    Queue<Node> cloneQueue = new LinkedList<>();
    cloneQueue.add(clone);
    cache.put(clone.val, clone);
    while(!queue.isEmpty()) {
      Node current = queue.poll();
      Node cloneNode = cloneQueue.poll();

      if(visited.contains(current.val)) {
        continue;
      }
      visited.add(current.val);
      for(Node neighbor : current.neighbors) {
        Node newNode = cache.computeIfAbsent(neighbor.val, k->new Node(neighbor.val));
        cloneNode.neighbors.add(newNode);
        queue.add(neighbor);
        cloneQueue.add(newNode);
      }
    }
    return clone;
  }

  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
