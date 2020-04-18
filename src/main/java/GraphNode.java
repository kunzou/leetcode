import java.util.ArrayList;
import java.util.List;

public class GraphNode {
  int data;
  boolean visited;
  List<GraphNode> neighbours;

  GraphNode(int data) {
    this.data = data;
    this.neighbours = new ArrayList<>();

  }

  public void addneighbours(GraphNode neighbourNode) {
    this.neighbours.add(neighbourNode);
  }

  public List<GraphNode> getNeighbours() {
    return neighbours;
  }

  public void setNeighbours(List<GraphNode> neighbours) {
    this.neighbours = neighbours;
  }
}
