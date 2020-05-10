import java.util.*;

public class LeetCode1262 {

  public int networkDelayTime(int[][] times, int N, int K) {
    Map<Integer, Node> network = new HashMap<>();
    PriorityQueue<Node> queue = new PriorityQueue<>(Node.COMPARATOR);

    int travelTime = 0;
    for (int[] time : times) {
      addToNetwork(time[0], time[1], time[2], network);
    }

    if(network.size() < N) {
      return -1;
    }

    network.get(K).setDistanceToOrigin(0);

    queue.add(network.get(K));

    while(!queue.isEmpty()) {
      Node node = queue.poll();
      N--;
      if(node.isVisited()) {
        continue;
      }
      node.setVisited(true);
      for(Map.Entry<Node, Integer> childEntry : node.getChildren().entrySet()) {
        if(!childEntry.getKey().isVisited()) {
          Node child = childEntry.getKey();
          child.setDistanceToOrigin(Math.min(childEntry.getValue()+node.getDistanceToOrigin(), child.getDistanceToOrigin()));
          queue.add(child);
        }
      }
      travelTime = Math.max(travelTime, node.getDistanceToOrigin());
    }

/*    for(Node node : network.values()) {
      if(!node.isVisited()) {
        return -1;
      }
      else {
        travelTime = Math.max(travelTime, node.getDistanceToOrigin());
      }
    }*/

    return N>0?-1:travelTime;
  }

  private void addToNetwork(int node, int child, int distance, Map<Integer, Node> network) {
    network.computeIfAbsent(node, Node::new).addChildren(network.computeIfAbsent(child, Node::new), distance);
//    Node childNode = ;
//    graphNode.addChildren(childNode, distance);
//    network.put(node, graphNode);
  }

  static class Node {
    public static final Comparator<Node> COMPARATOR = Comparator.comparing(Node::getDistanceToOrigin);
    private int value;
    private Map<Node, Integer> children;
    private boolean visited;
    private int distanceToOrigin;

    public Node(int value) {
      this.value = value;
      children = new HashMap<>();
      visited = false;
      distanceToOrigin = Integer.MAX_VALUE;
    }

    public void addChildren(Node child, int distance) {
      getChildren().put(child, distance);
    }

    public int getValue() {
      return value;
    }

    public void setValue(int value) {
      this.value = value;
    }

    public Map<Node, Integer> getChildren() {
      return children == null? new HashMap<>(): children;
    }

    public boolean isVisited() {
      return visited;
    }

    public void setVisited(boolean visited) {
      this.visited = visited;
    }

    public void setDistanceToOrigin(int distanceToOrigin) {
      this.distanceToOrigin = distanceToOrigin;
    }

    public int getDistanceToOrigin() {
      return distanceToOrigin;
    }
  }

/*  // standard Dijkstra question  time O(2V + E), spcace O(V + E)
  public int networkDelayTime(int[][] times, int N, int K) {
    Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    // construct graph
    for (int[] time : times) {
      if (!graph.containsKey(time[0])) graph.put(time[0], new HashMap<Integer, Integer>());
      graph.get(time[0]).put(time[1], time[2]);
    }

    PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.dist));

    Set<Integer> visited = new HashSet<>();
    minHeap.offer(new Pair(K, 0));
    int res = 0;


    // first poll the pair and check if the pair has been added into minHeap
    // If so -> the shortest distnace from root to curNode has been evaluated then skip the node
    // else -> evalue the distance to curNode and it must be the shortest distance
    // then check if curNode has neighbours
    while (!minHeap.isEmpty()) {
      Pair cur = minHeap.poll();

      if (visited.contains(cur.label)) continue;
      visited.add(cur.label);
      res = Math.max(res, cur.dist);
      // check if curNode has neighbours
      if (!graph.containsKey(cur.label)) continue;

      for (int neigh : graph.get(cur.label).keySet()) {
        minHeap.offer(new Pair(neigh, cur.dist + graph.get(cur.label).get(neigh)));
      }
    }
    return visited.size() == N ? res : -1;
  }

  class Pair {
    int label; int dist;

    public Pair(int label, int dist) {
      this.label = label;
      this.dist = dist;
    }
  }*/



/*  public int networkDelayTime(int[][] times, int N, int K) {
    Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
    for(int[] time : times){
      map.putIfAbsent(time[0], new HashMap<>());
      map.get(time[0]).put(time[1], time[2]);
    }

    //distance, node into pq
    Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));

    pq.add(new int[]{0, K});

    boolean[] visited = new boolean[N+1];
    int res = 0;

    while(!pq.isEmpty()){
      int[] cur = pq.remove();
      int curNode = cur[1];
      int curDist = cur[0];
      if(visited[curNode]) continue;
      visited[curNode] = true;
      res = curDist;
      N--;
      if(map.containsKey(curNode)){
        for(int next : map.get(curNode).keySet()){
          pq.add(new int[]{curDist + map.get(curNode).get(next), next});
        }
      }
    }
    return N == 0 ? res : -1;

  }*/

}
