import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AMZ_TopKFrequentlyMentionedKeywords {
  public List<String> solve(int k, String[] keywords, String[] reviews) {
    Map<String, Integer> keywordsMap = Arrays.stream(keywords).collect(Collectors.toMap(Function.identity(), (v)->0));

    for(String review : reviews) {
      keywordsMap.forEach((keyword, occurrence) -> {
        if(review.toLowerCase().contains(keyword)) {
          occurrence++;
          keywordsMap.put(keyword, occurrence);
        }
      });
    }

    return keywordsMap.entrySet().stream()
        .sorted((entry1, entry2) -> {
          if(!entry1.getValue().equals(entry2.getValue())) {
            return entry1.getValue() - entry2.getValue() > 0?-1:1;
          }
          else if (entry1.getKey().length() != entry2.getKey().length()) {
            return entry1.getKey().length() - entry2.getKey().length() > 0?1:-1;
          }
          else {
            return 0;
          }
        })
        .limit(k)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }
}
