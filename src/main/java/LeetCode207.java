import java.util.*;

public class LeetCode207 {

  enum Status { TODO, PROGRESS, DONE;}

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Node> network = new HashMap<>();
    for(int[] prerequisite : prerequisites) {
      Node pre = network.computeIfAbsent(prerequisite[1], key -> new Node(prerequisite[1]));
      network.computeIfAbsent(prerequisite[0], key->new Node(prerequisite[0])).addPre(pre);
    }

    for(Map.Entry<Integer, Node> entry : network.entrySet()) {
      if(isCircular(entry.getValue())) {
        return false;
      }
    }
    return true;
  }

  boolean isCircular(Node node) {
    if(node.getStatus() == Status.DONE) {
      return false;
    }

    if(node.getStatus() == Status.PROGRESS) {
      return true;
    }

    node.setStatus(Status.PROGRESS);
    for(Node pre : node.getPrerequisite()) {
      if(isCircular(pre)) {
        return true;
      }
    }
    node.setStatus(Status.DONE);
    return false;
  }

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
