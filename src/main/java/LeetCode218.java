import java.util.*;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LeetCode218 {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    List<List<Integer>> results = new ArrayList<>();
    PriorityQueue<Integer> eventQueue = new PriorityQueue<>(Comparator.reverseOrder());
    List<Event> events = createEvents(buildings);

    for(Event event:events) {
      if(event.getType() == 1) {
        if(eventQueue.isEmpty() || event.getHeight() > eventQueue.peek()) {
          results.add(createPoint(event));
        }
        eventQueue.add(event.getHeight());
      }

      if(event.getType() == -1) {
        Integer highest = eventQueue.peek();
        if(!eventQueue.isEmpty() && highest == event.getHeight()) {
          eventQueue.poll();
          if(eventQueue.isEmpty() || eventQueue.peek() != event.getHeight()) {
            results.add(Arrays.asList(event.getLocation(), Optional.ofNullable(eventQueue.peek()).orElse(0)));
          }
        }
        else {
          eventQueue.remove(event.getHeight());
        }
      }
    }

    return results;
  }

  List<Event> createEvents(int[][] buildings) {
    List<Event> events = new ArrayList<>();
    for(int i = 0; i < buildings.length; i++) {
      events.add(new Event(buildings[i][0], buildings[i][2], 1));
      events.add(new Event(buildings[i][1], buildings[i][2], -1));
    }

    events.sort(Event.COMPARATOR);
    return events;
  }

  List<Integer> createPoint(Event event) {
    return Arrays.asList(event.getLocation(), event.getHeight());
  }
}

class Event implements Comparable {
  public static final Comparator<Event> COMPARATOR = Comparator.comparing(Event::getLocation).thenComparing(Event::heightComparingFactor);
  private int location;
  private int height;
  private int type; //1 entering, -1 leaving

  public Event(int location, int height, int type) {
    this.location = location;
    this.height = height;
    this.type = type;
  }

  public int getLocation() {
    return location;
  }

  public void setLocation(int location) {
    this.location = location;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public String toString() {
    return String.format("[%s, %s, %s]", location, height, type);
  }

  public int heightComparingFactor() {
    return -height*type;
  }

  @Override
  public int compareTo(Object o) {
    return ((Event)o).getHeight() - this.height;
  }
}

