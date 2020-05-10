import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode295 {
  public void runner() {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);
    medianFinder.addNum(2);
//    medianFinder.addNum(3);
    System.out.println(medianFinder.findMedian());
  }

}
class MedianFinder {

  private PriorityQueue<Integer> lowerQueue;
  private PriorityQueue<Integer> higherQueue;
  /** initialize your data structure here. */
  public MedianFinder() {
    lowerQueue = new PriorityQueue<>(Comparator.reverseOrder());
    higherQueue = new PriorityQueue<>();
  }

  public void addNum(int num) {
    if(lowerQueue.isEmpty()) {
      lowerQueue.add(num);
    }
    else if(num > lowerQueue.peek()) {
      higherQueue.add(num);
    }
    else {
      lowerQueue.add(num);
    }

    if(higherQueue.size() - lowerQueue.size() == 2) {
      lowerQueue.add(higherQueue.poll());
    }
    else if(lowerQueue.size() - higherQueue.size() == 2) {
      higherQueue.add(lowerQueue.poll());
    }

  }

  public double findMedian() {
    if(lowerQueue.size() > higherQueue.size()) {
      return lowerQueue.peek();
    }
    else if(higherQueue.size() > lowerQueue.size()) {
      return higherQueue.peek();
    }
    else {
      return (double)(higherQueue.peek()+lowerQueue.peek())/2;
    }
  }
}
