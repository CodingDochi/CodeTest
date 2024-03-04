package combinatorics.P_11050;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 이항 계수 : (a+b)^n 에 대해 전개했을 때 a^(n-r)*b^r에 대한 계수
    // 조합 공식 nCr = n! / r!(n-r)!

    private int N;
    private int K;
    private int[][] dp;
    private int calc(int N, int K) {
        if (dp[N][K] > 0) {
            return dp[N][K];
        }
        if (N == K || K == 0) {
            return dp[N][K] = 1;
        }
        return dp[N][K] = calc(N-1, K-1) + calc(N-1, K);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1][K+1];

        System.out.println(calc(N, K));
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
