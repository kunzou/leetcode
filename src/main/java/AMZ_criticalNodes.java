import java.util.*;

public class AMZ_criticalNodes {

  /*critical bridge/node*/
  public List<Integer> criticalConnections(int n, List<List<Integer>> connections) {
    int[] stepsToNode = new int[n];
    int[] lowestStepsToNode = new int[n];
    List<Integer>[] graph = new ArrayList[n];
    Set<Integer> result = new HashSet<>();
    Arrays.fill(stepsToNode, -1); // unvisited nodes are marked as -1
    for (int i = 0; i < n; i++) {
      graph[i] = new ArrayList<>();
    }
    // build graph
    for (int i = 0; i < connections.size(); i++) {
      int from = connections.get(i).get(0), to = connections.get(i).get(1);
      graph[from].add(to);
      graph[to].add(from);
    }

    for (int i = 0; i < n; i++) {
      if (stepsToNode[i] == -1) {
        dfs(i, lowestStepsToNode, stepsToNode, graph, result, i, 0);
      }
    }
    return new ArrayList<>(result);
  }

  private void dfs(int currentNode, int[] lowestStepsToNode, int[] stepsToNode, List<Integer>[] graph, Set<Integer> result, int parent, int steps) {
    steps++;
    stepsToNode[currentNode] = steps;
    lowestStepsToNode[currentNode] = steps;
    for (int child : graph[currentNode]) {
      if (child == parent) {
        continue; // if parent vertex, ignore
      }
      if (stepsToNode[child] == -1) { // if not discovered
        dfs(child, lowestStepsToNode, stepsToNode, graph, result, currentNode, steps);
        lowestStepsToNode[currentNode] = Math.min(lowestStepsToNode[currentNode], lowestStepsToNode[child]);
        if (lowestStepsToNode[child] > stepsToNode[currentNode]) {
          // this parent - child is critical, there is no path for child to reach back to parent or previous vertices of parent
          result.add(currentNode);
        }
      } else { // if child is discovered and is not the parent of its parent, update lowest step
        lowestStepsToNode[currentNode] = Math.min(lowestStepsToNode[currentNode], stepsToNode[child]);
      }
    }
  }

}
