import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LFUCache {
  int capacity;
  int minFrequency;
  Map<Integer, Node> cache;
  Map<Integer, LinkedList<Node>> frequencyMap;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.minFrequency = 0;
    this.cache = new HashMap<>();
    this.frequencyMap = new HashMap<>();
  }

  public int get(int key) {
    Node curNode = cache.get(key);
    if (curNode == null) {
      return -1;
    }
    updateNode(curNode);
    return curNode.getVal();
  }

  public void put(int key, int value) {
    // corner case: check cache capacity initialization
    if (capacity == 0) {
      return;
    }

    if (cache.containsKey(key)) {
      Node curNode = cache.get(key);
      curNode.setVal(value);
      updateNode(curNode);
    } else {
      Node newNode = new Node(key, value);
      cache.put(key, newNode);
      frequencyMap.computeIfAbsent(1, k -> new LinkedList<>()).addLast(newNode);

      if (cache.size() > capacity) {
        cache.remove(frequencyMap.get(minFrequency).removeFirst().getKey());
      }

      minFrequency = 1;
    }
  }

  public void updateNode(Node curNode) {
    int curFreq = curNode.frequency;
    frequencyMap.get(curFreq).remove(curNode);

    // if current list the the last list which has lowest frequency and current node is the only node in that list
    // we need to remove the entire list and then increase min frequency value by 1
    if (curFreq == minFrequency && frequencyMap.get(curFreq).isEmpty()) {
      minFrequency++;
    }

    curNode.incrementFrequency();
    frequencyMap.computeIfAbsent(curNode.getFrequency(), k -> new LinkedList<>()).add(curNode);
  }

  class Node {
    private int key;
    private int val;
    private int frequency;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
      this.frequency = 1;
    }

    public int getKey() {
      return key;
    }

    public void setKey(int key) {
      this.key = key;
    }

    public int getVal() {
      return val;
    }

    public void setVal(int val) {
      this.val = val;
    }

    public int getFrequency() {
      return frequency;
    }

    public void setFrequency(int frequency) {
      this.frequency = frequency;
    }

    public void incrementFrequency() {
      frequency++;
    }
  }
}

/*
import java.util.HashMap;
import java.util.Map;

//Double linked list

class LFUCache {
  int capacity;
  int minFrequency;
  Map<Integer, Node> cache;
  Map<Integer, DoubleLinkedList> frequencyMap;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.minFrequency = 0;
    this.cache = new HashMap<>();
    this.frequencyMap = new HashMap<>();
  }

  public int get(int key) {
    Node curNode = cache.get(key);
    if (curNode == null) {
      return -1;
    }
    updateNode(curNode);
    return curNode.val;
  }

  public void put(int key, int value) {
    // corner case: check cache capacity initialization
    if (capacity == 0) {
      return;
    }

    if (cache.containsKey(key)) {
      Node curNode = cache.get(key);
      curNode.val = value;
      updateNode(curNode);
    } else {
      Node newNode = new Node(key, value);
      cache.put(key, newNode);
      frequencyMap.computeIfAbsent(1, k -> new DoubleLinkedList()).addNode(newNode);

      if (cache.size() > capacity) {
        cache.remove(frequencyMap.get(minFrequency).removeHead().key);
      }

      minFrequency = 1;
    }
  }

  public void updateNode(Node curNode) {
    int curFreq = curNode.frequency;
    frequencyMap.get(curFreq).removeNode(curNode);

    // if current list the the last list which has lowest frequency and current node is the only node in that list
    // we need to remove the entire list and then increase min frequency value by 1
    if (curFreq == minFrequency && frequencyMap.get(curFreq).isEmpty()) {
      minFrequency++;
    }

    curNode.frequency++;
    frequencyMap.computeIfAbsent(curNode.frequency, k -> new DoubleLinkedList()).addNode(curNode);
  }

  class Node {
    int key;
    int val;
    int frequency;
    Node prev;
    Node next;

    public Node(int key, int val) {
      this.key = key;
      this.val = val;
      this.frequency = 1;
    }
  }

  class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList() {
      this.head = new Node(0, 0);
      this.tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
    }

    private void addNode(Node cur) {
      cur.prev = tail.prev;
      cur.next = tail;
      cur.prev.next = cur;
      tail.prev = cur;
    }

    public void removeNode(Node curNode) {
      curNode.prev.next = curNode.next;
      curNode.next.prev = curNode.prev;
    }

    public Node removeHead() {
      if (isEmpty()) {
        return null;
      }
      Node headNode = head.next;
      removeNode(headNode);
      return headNode;
    }

    public boolean isEmpty() {
      return head.next == tail;
    }
  }
}
*/
