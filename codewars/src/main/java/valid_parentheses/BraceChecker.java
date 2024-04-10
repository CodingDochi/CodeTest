package valid_parentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BraceChecker {

    public boolean isValid(String braces) {

        if (braces.length() % 2 != 0) {
            return false;
        }

        List<Character> openList = new ArrayList<>(Arrays.asList('(', '{', '['));
        List<Character> closeList = new ArrayList<>(Arrays.asList(')', '}', ']'));

        List<Character> braceList = new ArrayList<>();
        for (Character elem : braces.toCharArray()) {
            braceList.add(elem);
        }

        int cnt = 0;
        int limit = braceList.size();
        while (!braceList.isEmpty()) {
            for (int i = 0; i < braceList.size()-1; i++) {
                if (openList.contains(braceList.get(i)) && (closeList.contains(braceList.get(i + 1)) && closeList.indexOf(braceList.get(i + 1)) == openList.indexOf(braceList.get(i)))) {
                    braceList.remove(i);
                    braceList.remove(i);
                }
            }
            cnt++;
            if (cnt > limit / 2) {
                return false;
            }
        }
        return true;
    }
}