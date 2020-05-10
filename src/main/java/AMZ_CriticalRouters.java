import net.bytebuddy.matcher.HasSuperTypeMatcher;

import javax.print.attribute.standard.PresentationDirection;
import java.lang.reflect.Array;
import java.util.*;

public class AMZ_CriticalRouters {
  public List<Integer> getCreditRouters(int[][] edges, int numberOfNodes) {
    List<Integer> results = new ArrayList<>();
    int[] stepsTo = new int[numberOfNodes];
    int[] lowestStepsTo = new int[numberOfNodes];

    Arrays.fill(stepsTo, -1);
    Arrays.fill(lowestStepsTo, -1);

    Map<Integer, List<Integer>> network = new HashMap<>();

    for(int[] edge : edges) {
      addToNetwork(edge[0], edge[1], network);
      addToNetwork(edge[1], edge[0], network);
    }

    for(int node : network.keySet()) {
      if(stepsTo[node] == -1) {
        walkThroughNetwork(node, network, results, stepsTo, lowestStepsTo, node, 0);
      }
    }
    return new ArrayList<>(new HashSet<>(results));
  }

  void walkThroughNetwork(int currentNode, Map<Integer, List<Integer>> network, List<Integer> criticalNodes, int[] stepsTo, int[] lowestStepsTo, int parentNode, int steps) {
    stepsTo[currentNode] = steps;
    lowestStepsTo[currentNode] = steps;
    steps++;
    for(int child : network.get(currentNode)) {
      if(child != parentNode && stepsTo[child] == -1) {
        walkThroughNetwork(child, network, criticalNodes, stepsTo, lowestStepsTo, currentNode, steps);
        lowestStepsTo[currentNode] = Math.min(lowestStepsTo[currentNode], lowestStepsTo[child]);
        if(lowestStepsTo[child] > lowestStepsTo[currentNode]) {
          criticalNodes.add(child);
          criticalNodes.add(currentNode);
        }
      }
      else if(child != parentNode) {
        lowestStepsTo[currentNode] = Math.min(lowestStepsTo[currentNode], lowestStepsTo[child]);
      }
    }
  }

  void addToNetwork(int parent, int child, Map<Integer, List<Integer>> network) {
    if(network.containsKey(parent)) {
      List<Integer> children = network.get(parent);
      children.add(child);
      network.put(parent, children);
    }
    else {
      network.put(parent, new ArrayList<>(Collections.singletonList(child)));
    }
  }
}

class GraphNode {
  private int value;
  private List<GraphNode> children;
  private int stepsFromParent;
  private int deepestSteps;
  private boolean visited;

  public GraphNode(int value) {
    this.value = value;
    this.visited = false;
    this.children = new ArrayList<>();
  }

  public List<GraphNode> addAndGetChildren(int value) {
    GraphNode node = new GraphNode(value);
    this.getChildren().add(node);
    return this.getChildren();
  }

  public void addChild(GraphNode graphNode) {
    this.getChildren().add(graphNode);
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public List<GraphNode> getChildren() {
    return children;
  }

  public void setChildren(List<GraphNode> children) {
    this.children = children;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public int getStepsFromParent() {
    return stepsFromParent;
  }

  public void setStepsFromParent(int stepsFromParent) {
    this.stepsFromParent = stepsFromParent;
  }

  public int getDeepestSteps() {
    return deepestSteps;
  }

  public void setDeepestSteps(int deepestSteps) {
    this.deepestSteps = deepestSteps;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GraphNode)) return false;
    GraphNode graphNode = (GraphNode) o;
    return getValue() == graphNode.getValue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }
}


