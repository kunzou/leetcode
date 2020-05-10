import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeetCode210 {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if(prerequisites.length == 0) {
      return IntStream.range(0, numCourses).toArray();
    }

    Set<Integer> integers = IntStream.range(0, numCourses).boxed().collect(Collectors.toSet());

    Map<Integer, Node> network = new HashMap<>();
    List<Integer> results = new ArrayList<>();
    for(int[] prerequisite : prerequisites) {
      Node pre = network.computeIfAbsent(prerequisite[1], key -> new Node(prerequisite[1]));
      network.computeIfAbsent(prerequisite[0], key->new Node(prerequisite[0])).addPre(pre);
    }

    for(Map.Entry<Integer, Node> entry : network.entrySet()) {
      isCircular(entry.getValue(), results);
      if(entry.getValue().getStatus() != Status.DONE) {
        return new int[]{};
      }
      integers.remove(entry.getKey());
    }

    for(int integer : integers) {
      results.add(0, integer);
    }

    return results.stream().mapToInt(i -> i).toArray();
  }

  boolean isCircular(Node node, List<Integer> results) {
    if(node.getStatus() == Status.DONE) {
      return false;
    }

    if(node.getStatus() == Status.PROGRESS) {
      return true;
    }

    node.setStatus(Status.PROGRESS);
    for(Node pre : node.getPrerequisite()) {
      if(isCircular(pre, results)) {
        return true;
      }
    }
    node.setStatus(Status.DONE);
    results.add(node.value);
    return false;
  }

  enum Status { TODO, PROGRESS, DONE;}
  
  class Node {
    private int value;
    private Set<Node> prerequisite;
    private Status status;

    public Node(int value) {
      this.value = value;
      prerequisite = new HashSet<>();
      this.status = status.TODO;
    }

    public void addPre(Node node) {
      prerequisite.add(node);
    }

    public Status getStatus() {
      return status;
    }

    public void setStatus(Status status) {
      this.status = status;
    }

    public Set<Node> getPrerequisite() {
      return prerequisite;
    }
  }  
}
