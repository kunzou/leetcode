import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AMZ_FavoriteGenres {
  public Map<String, List<String>> favoritegenre(Map<String, List<String>> userSongs, Map<String, List<String>> genreSongs) {
    Map<String, List<String>> userGenre = new HashMap<>();

    Map<String, String> songGenre = new HashMap<>();

    genreSongs.forEach((genre, songs) -> songs
        .forEach(song -> {
          songGenre.put(song, genre);
        }));

    userSongs.forEach((user, songs) -> {
      List<String> genres = new ArrayList<>();
      songs.forEach(song -> {
        genres.add(songGenre.get(song));
      });

      List<String> topsGenres = genres.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
          .filter(entrySet -> entrySet.getValue() > 1)
          .map(Map.Entry::getKey)
          .collect(Collectors.toList());

      userGenre.put(user, topsGenres);
    });

    return userGenre;
  }

}
