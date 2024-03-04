package dfsAndBfs.Lessons_43163;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int solution(String[] words, String begin, String target) {

        for (String elem : words) {
        int cnt = 0;
        while (elem != target) {
            cnt++;
        }
        if (cnt == words.length) {
            return 0;
        }
    }

    List<List<Character>> word_list = new ArrayList<>();

        for (String elem : words) {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < elem.length(); i++) {
            chars.add(elem.charAt(i));
        }
        word_list.add(chars);
    }

    List<Character> begin_char = new ArrayList<>();
        for (int i = 0; i < begin.length(); i++) {
        begin_char.add(begin.charAt(i));
    }

        for (int i = 0; i < begin_char.size(); i++) {
        for (List<Character> elem : word_list) {
            bfs(begin_char.get(i), elem);
        }
    }
    int answer = 0;
        return answer;
}

    int c;
    int cnt;
    private void bfs(Character begin_character, List<Character> word) {

        for (Character c : word) {
            if (begin_character == c) {
                cnt++;
            }
        }
        if (cnt == 2) {

        }
    }

}


