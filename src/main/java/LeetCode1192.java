import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1192 {
/*critical bridge/node*/
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    int[] stepsToNode = new int[n];
    int[] lowestStepsToNode = new int[n];
    List<Integer>[] graph = new ArrayList[n];
    List<List<Integer>> result = new ArrayList<>();
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
    return result;
  }

  private void dfs(int currentNode, int[] lowestStepsToNode, int[] stepsToNode, List<Integer>[] graph, List<List<Integer>> result, int parent, int steps) {
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
          result.add(Arrays.asList(currentNode, child));
        }
      } else { // if child is discovered and is not the parent of its parent, update lowest step
        lowestStepsToNode[currentNode] = Math.min(lowestStepsToNode[currentNode], stepsToNode[child]);
      }
    }
  }




/*  List<List<Integer>> res = new ArrayList<>(); // 返回结果
  int[] deepArray; // 深度数组
  ArrayList<Integer>[] map; // 结构图

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>>connections){
    deepArray = new int[n]; // 初始化深度数组
    Arrays.fill(deepArray, -1); // 所有节点初始深度为-1
    map = new ArrayList[n]; // 初始化结构图map[i]代表节点i可以连通哪些节点
    for (int i = 0; i < n; i++) {
      map[i] = new ArrayList<>();
    }
    // 构建路径图
    for (List<Integer> connection : connections) {
      map[connection.get(0)].add(connection.get(1));
      map[connection.get(1)].add(connection.get(0));
    }
    dfs(0, 0, 0); // 开始dfs
    return res;
  }

  // current为当前节点
// previous为前节点
// deep为当前深度
// 返回值为当前节点所有dfs路径终点的最小深度
  private int dfs(int current, int previous, int deep){
    deepArray[current] = deep; // 将当前深度存入深度数组
    int result = Integer.MAX_VALUE; // 返回值
    for(int i : map[current]){ // 遍历当前节点能走的所有节点
      if(i == previous){ // 不能走回头路
        continue;
      }
      int endDeep; // dfs终点深度
      if(deepArray[i]==-1){ // 深度为-1的点没走过，可以dfs
        endDeep = dfs(i, current, deep+1);
        // 如果深度大于当前深度，说明当前点不在闭环上
        // 当前点与下一节点i之间的连线为答案之一
        if(endDeep > deep){
          List<Integer> list = new ArrayList<>();
          list.add(current);
          list.add(i);
          res.add(list);
        }
      }else{
        // i节点深度不为-1，说明已经走过，i节点为dfs终点
        endDeep = deepArray[i];
      }
      // 更新最小深度
      result = Math.min(result, endDeep);
    }
    return result; // 返回最小深度
  }*/
}

