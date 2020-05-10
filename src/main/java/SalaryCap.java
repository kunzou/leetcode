public class SalaryCap {
  public void calculateCap(int[] salereis, int cap) {
//    int[] a = {10, 5, 20, 30};
//    int maxValue = 40;
    int average = cap/salereis.length;
    int bonusPoints = 0;
    int substitutions = 0;
    for (int i = 0; i < salereis.length; i++) {
      if (average - salereis[i] > 0)
        bonusPoints += average - salereis[i];
      if (salereis[i] > average)
        substitutions++;
    }
    int x = average + (bonusPoints/substitutions);
    System.out.println("x " + x);
    // DONE!

    // Visual check:
    int finalSum = 0;
    for (int i : salereis) {
      finalSum += Math.min(x, i);
    }
    System.out.println("finalSum " + finalSum);
    System.out.println("maxValue " + cap);
  }
}
