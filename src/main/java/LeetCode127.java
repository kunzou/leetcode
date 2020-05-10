import java.util.*;

public class LeetCode127 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//    Queue<String>[] queues = new Queue[2];

//    queues[0] = new LinkedList<>();
//    queues[1] = new LinkedList<>();

//    queues[0].add(beginWord);
//    queues[1].add(endWord);

    Queue<String> queue = new LinkedList<>();
    int steps = 0;

    Set<String> words = new HashSet<>(wordList);
    words.remove(beginWord);
    words.remove(endWord);
    Set<String> usedWords = new HashSet<>();
    Map<Integer, Set<Character>> dictionary = new HashMap<>();

    for (int i = 0; i < beginWord.length(); i++) {
      for(String word : wordList) {
        dictionary.computeIfAbsent(i, key->new HashSet<>()).add(word.charAt(i));
      }
    }

//    int index = 0;
//    int queIndex = 0;

    queue.add(beginWord);

    while(!queue.isEmpty()) {
      steps++;
      int size = queue.size();
      for (int element = 0; element < size; element++) {
        String word = queue.poll();
        for (int i = 0; i < word.length(); i++) {
          for(Character character : dictionary.get(i)) {
//          for(char character = 'a'; character <= 'z'; character++) {
            if(character != word.charAt(i)) {
              String newWord = combineCharacter(character, word, i);
              if(!words.contains(newWord)) {
                continue;
              }
              if(newWord.equals(endWord)) {
                return steps+1;
              }
              if(!usedWords.contains(newWord)) {
                queue.add(newWord);
                usedWords.add(newWord);
              }
            }
          }
        }
      }

/*      if(queues[0].size() < queues[1].size()) {
        queIndex = 0;
      }
      else {
        queIndex = 1;
      }*/

    }

    return 0;
  }

  String combineCharacter(Character character, String word, int index) {
    return word.substring(0,index)+character+word.substring(index+1);
  }
}
