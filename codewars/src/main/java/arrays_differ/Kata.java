package arrays_differ;

import java.util.ArrayList;
import java.util.List;

public class Kata {

    /*
    Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
     */
    public static int[] arrayDiff(int[] a, int[] b) {

        if (b.length == 0) {
            return a;
        }

        List<Integer> a_list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            a_list.add(a[i]);
        }

        List<Integer> b_list = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            b_list.add(b[i]);
        }

        List<Integer> difference = new ArrayList<>();
        for (int i = 0; i < a_list.size(); i++) {
            for (int j = 0; j < b_list.size(); j++) {
                if (a_list.get(i) != b_list.get(j)) {
                    difference.add(a_list.get(i));
                }
            }
        }

        int[] answerArray = new int[difference.size()];
        for (int i = 0; i < answerArray.length; i++) {
            answerArray[i] = difference.get(i);
        }

        return answerArray;
    }

}