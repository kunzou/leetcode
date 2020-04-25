import java.util.*;
import java.util.stream.Collectors;

public class AMZ_BattleShip {
  public String solution(int N, String S, String T) {
    List<Ship> ships = Arrays.stream(S.split(","))
        .map(this::createShip)
        .collect(Collectors.toList());

    int hit = 0;
    int sunk = 0;

    Arrays.stream(T.split(" "))
        .map(Coordinate::new)
        .forEach(attack -> ships.forEach(ship -> ship.hit(attack)));

    for (Ship ship : ships) {
      sunk+= (ship.isSunk()?1:0);
      hit+= (ship.isHit()?1:0);
    }

    return String.format("%s,%s", hit, sunk);
  }

  private Ship createShip(String cords) {
    Coordinate head = new Coordinate(cords.substring(0,2));
    Coordinate tail = new Coordinate(cords.substring(3,5));

    Set<Coordinate> shipCords = new HashSet<>();

    for (int row = head.getRow(); row <=tail.getRow(); row++) {
      for (int col = head.getCol(); col <= tail.getCol(); col++) {
        shipCords.add(new Coordinate(row, col));
      }
    }

    return new Ship(shipCords);
  }
}

class Ship {
  private Set<Coordinate> coordinates;
  int size;

  public Ship(Set<Coordinate> coordinates) {
    this.coordinates = coordinates;
    size = this.coordinates.size();
  }

  public void hit(Coordinate coordinate) {
    this.coordinates.remove(coordinate);
  }

  public boolean isSunk() {
    return coordinates.isEmpty();
  }

  public boolean isHit() {
    return !coordinates.isEmpty() && coordinates.size() < size;
  }
}

class Coordinate {
  private int row;
  private int col;

  public Coordinate(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public Coordinate(String s) {
    this.row = s.charAt(0)-'1';
    this.col = s.charAt(1)-'A';
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Coordinate)) return false;
    Coordinate that = (Coordinate) o;
    return getRow() == that.getRow() &&
        getCol() == that.getCol();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRow(), getCol());
  }
}
