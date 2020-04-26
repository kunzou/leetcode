import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AMZ_OAS_TRY_1_Q2 {
  public List<String> reorderLines(int logFileSize, List<String> logLines) {
    if(logFileSize == 0) {
      return new ArrayList<>();
    }
    return logLines.stream()
        .sorted((log1, log2) -> {
          String[] logs1 = log1.split("\\s");
          String[] logs2 = log2.split("\\s");
          boolean isDigit1 = Character.isDigit(logs1[1].charAt(0));
          boolean isDigit2 = Character.isDigit(logs2[1].charAt(0));
          if (!isDigit1 && !isDigit2) {

            int cmp = logs1[1].compareTo(logs2[1]);
            if (cmp != 0) {
              return cmp;
            }
            //compare tags if they are the same
            return logs1[0].compareTo(logs2[0]);
          }
          return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        })
        .collect(Collectors.toList());
  }
}
