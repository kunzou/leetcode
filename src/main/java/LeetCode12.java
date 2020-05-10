import java.util.HashMap;
import java.util.Map;

public class LeetCode12 {
  public String intToRoman(int num) {

    Roman roman1 = new Roman("I",1);
    Roman roman4 = new Roman("IV",4);
    Roman roman5 = new Roman("V",5);
    Roman roman9 = new Roman("IX",9);
    Roman roman10 = new Roman("X",10);
    Roman roman40 = new Roman("XL",40);
    Roman roman50 = new Roman("L",50);
    Roman roman90 = new Roman("XC",90);
    Roman roman100 = new Roman("C",100);
    Roman roman400 = new Roman("CD",400);
    Roman roman500 = new Roman("D",500);
    Roman roman900 = new Roman("CM",900);
    Roman roman1000 = new Roman("M",1000);

    Roman[] numbers = {roman1000, roman900, roman500, roman400, roman100, roman90, roman50, roman40, roman10, roman9, roman5, roman4, roman1};
    int index = 0;
    String result = "";
    for(int i=0;i<numbers.length;i++) {
      while(num >= numbers[i].getValue()) {
        num -= numbers[i].getValue();
        result = String.format("%s%s", result, numbers[i].getSymbol());
      }
    }

    return result;
  }

  class Roman {
    private int value;
    private String symbol;

    public Roman(String symbol, int value) {
      this.value = value;
      this.symbol = symbol;
    }

    public int getValue() {
      return value;
    }

    public String getSymbol() {
      return symbol;
    }
  }
}
