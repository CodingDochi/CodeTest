package dynamicProgramming.P_1788;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Retry {

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int abs_N = Math.abs(N);
        int[] dp = new int[abs_N+1];
        int mod = 1000000000;

        if (abs_N >= 0) { dp[0] = 0; }
        if (abs_N >= 1) { dp[1] = 1;}
        if (abs_N >= 2) { dp[2] = 1; }

        if (abs_N >= 3) {
            for (int i = 3; i <=abs_N; i++) {
                dp[i] = (dp[i-1]%mod + dp[i-2]%mod)%mod;
            }
        }

        if (N < 0 && abs_N%2 ==0) {
            System.out.println(-1);
        }
        else if (N == 0) {
            System.out.println(0);
        }
        else {
            System.out.println(1);
        }
        System.out.println(dp[abs_N]);

    }
    public static void main(String[] args) throws Exception {
        new Retry().solution();
    }
}
