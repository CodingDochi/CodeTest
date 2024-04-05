package dynamicProgramming.P_15988;

/*

dp[n] = dp[n-1], dp[n-2], dp[n-3]에 각각 1, 2, 3을 더한 것
dp[1] = 1 (1)
dp[2] = 2 (1, 1), (2)
dp[3] = 4 (1, 1, 1), (2, 1), (1, 2), (3)
dp[4] = 7 (1, 1, 1, 1), (2, 1, 1), (1, 2, 1), (1, 1, 2), (2, 2), (3, 1), (1, 3)

dp[4] = (dp[3]에 1 더한 것) + (dp[2]에 2 더한 것) + (dp[1]에 3 더한 것) 이므로
dp[n] = dp[n-1] + dp[n-2] + dp[n-3]

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private void printdp(int[] arr) {
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 3) {
                for (int j = 4; j <= arr[i]; j++) {
                    dp[j] = (dp[j - 1] + dp[j - 2] + dp[j - 3]) % 1000000009;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(dp[arr[i]] % 1000000009);
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        printdp(arr);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

}
