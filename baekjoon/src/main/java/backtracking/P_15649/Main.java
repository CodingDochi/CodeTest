package backtracking.P_15649;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    int N;
    int M;
    int[] dp;
    List<List<Integer>> possibility;



    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
        // alphanumeric order


    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
