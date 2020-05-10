import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AMZ_Glassdoor_objectGrouping {
  public List<AmazonObject> getTopNObjects(List<AmazonObject> objects, int n) {
    Collections.sort(objects, Comparator.comparing(AmazonObject::getClicks, Collections.reverseOrder()));

    Map<Integer, List<AmazonObject>> categoryMap = objects.stream()
        .collect(Collectors.groupingBy(AmazonObject::getCategory));

    categoryMap.replaceAll((key, values) -> values.stream().limit(n).collect(Collectors.toList()));

    return new ArrayList<>();
  }


}

class AmazonObject {
  private String name;
  private Long id;
  private Integer clicks;
  private Integer category;

  public AmazonObject(String name, Integer clicks, Integer category) {
    this.name = name;
    this.clicks = clicks;
    this.category = category;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getClicks() {
    return clicks;
  }

  public void setClicks(Integer clicks) {
    this.clicks = clicks;
  }

  public Integer getCategory() {
    return category;
  }

  public void setCategory(Integer category) {
    this.category = category;
  }
}
