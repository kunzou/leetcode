import java.util.HashMap;
import java.util.Map;

public class LeetCode273 {
  private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

  public String numberToWords1(int num) {
    if(num == 0) {
      return "Zero";
    }
    else {
      return getSubThousandHelper(num);
    }
  }


  public String getSubThousandHelper(int num) {

    if(num == 0) {
      return "";
    }
    String result = "";
    if(num < 20) {
      result = LESS_THAN_20[num];
    }
    else if(num < 100) {
      result = TENS[num/10] + " " + LESS_THAN_20[num % 10];
    }
    else if(num < 1000){
      result = LESS_THAN_20[num / 100] + " Hundred " + getSubThousandHelper(num % 100);
    }
    else if(num < 1000000) {
      result = getSubThousandHelper(num/1000) + " Thousand " + getSubThousandHelper(num%1000);
    }
    else if(num < 1000000000){
      result = getSubThousandHelper(num/1000000) + " Million " + getSubThousandHelper(num%1000000);
    }
    else {
      result = getSubThousandHelper(num/1000000000) + " Billion " + getSubThousandHelper(num%1000000000);
    }
    return result.trim();
  }

  public String numberToWords(int num) {
    if(num == 0) {
      return "Zero";
    }
    else {
      int i = 0;
      String result = "";
      while(num > 0) {
        if(num % 1000 != 0) {
          result = getSubThousand(num % 1000).trim() + " " + THOUSANDS[i] + " " + result;
        }
        i ++;
        num = num / 1000;
      }

      return result.trim();
    }
  }

  public String getSubThousand(int num) {
    if(num == 0) {
      return "";
    }
    if(num < 20) {
      return LESS_THAN_20[num];
    }
    else if(num < 100) {
      return TENS[num/10] + " " + LESS_THAN_20[num % 10];
    }
    else {
      return LESS_THAN_20[num / 100] + " Hundred " + getSubThousand(num % 100);
    }
  }

}
