import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LeetCode1268 {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    List<List<String>> res = new ArrayList<>();
    TreeMap<String, Integer> map = new TreeMap<>();
    Arrays.sort(products);
    List<String> productsList = Arrays.asList(products);

    for (int i = 0; i < products.length; i++) {
      map.put(products[i], i);
    }

    String key = "";
    for (char c : searchWord.toCharArray()) {
      key += c;
      String ceiling = map.ceilingKey(key);
      String floor = map.floorKey(key + "~");
      if (ceiling == null || floor == null) break;
      res.add(productsList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
    }

    while (res.size() < searchWord.length()) res.add(new ArrayList<>());
    return res;
  }

/*    List<List<String>> results = new ArrayList<>();
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
  }*/
}
