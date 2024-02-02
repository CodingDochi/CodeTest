package practiceTest.fruitSeller;

import java.util.Arrays;

public class Other {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);
        System.out.println(Arrays.toString(score));

        for (int i = score.length; i >= m; i -= m) {
            System.out.println(" i : "+i+"   i - m : "+(i-m));
            answer += score[i - m] * m;
            System.out.println("answer : "+answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 1, 2, 3, 1};
        new Other().solution(3, 4, arr);
    }
}
