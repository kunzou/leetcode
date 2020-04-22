import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode1268 {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> results = new ArrayList<>();
    List<String> sortedProducts = Arrays.stream(products)
        .sorted()
        .collect(Collectors.toList());

    for(int i = 1; i <= searchWord.length(); i++) {
      String searchPattern = searchWord.substring(0, i);
      List<String> currentResult = sortedProducts.stream()
          .filter(product -> product.startsWith(searchPattern))
          .limit(3)
          .collect(Collectors.toList());
      results.add(currentResult);
    }

    return results;
  }
}
