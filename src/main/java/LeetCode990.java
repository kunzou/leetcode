import java.util.HashMap;
import java.util.Map;

public class LeetCode990 { /*union find*/
  int[] uf = new int[26];
  public boolean equationsPossible(String[] equations) {
    for (int i = 0; i < 26; ++i) {
      uf[i] = i;
    }
    for (String e : equations) {
      if (e.charAt(1) == '=') {
        uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
      }
    }
    for (String e : equations) {
      if (e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) {
        return false;
      }
    }
    return true;
  }

  public int find(int x) {
    if (x != uf[x]) {
      uf[x] = find(uf[x]);
    }
    return uf[x];
  }
/*
  public boolean equationsPossible(String[] equations) {
    Map<Character, Character> map = new HashMap<>();

    for (String e : equations) {
      map.put(getLeft(e), getLeft(e));
      map.put(getRight(e), getRight(e));
    }

    for (String e : equations) {
      if (getSign(e) == '=') {
        map.put(getLeft(e), getParent(map, getRight(e)));
      }
    }

    for(String e : equations) {
      if (getSign(e) == '!') {
        if(getParent(map, getLeft(e)) == getParent(map, getRight(e))) {
          return false;
        }
      }
    }

    return true;
  }
*/

  Character getParent(Map<Character, Character> map, Character character) {
    Character result = map.getOrDefault(character, character);

    while(map.getOrDefault(result, result) != result) {
      result = map.get(result);
    }

    return result;
  }

  Character getSign(String equation) {
    return equation.charAt(1);
  }

  Character getLeft(String equation) {
    return equation.charAt(0);
  }

  Character getRight(String equation) {
    return equation.charAt(3);
  }
}
