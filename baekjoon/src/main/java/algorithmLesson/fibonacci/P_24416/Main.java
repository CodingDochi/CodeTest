package algorithmLesson.fibonacci.P_24416;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private int[] f;
    private int N;

    private int fib_recur(int n) {
        if (n==1 | n==2) {
            return 1;
        }
        else return (fib_recur(n-1) + fib_recur(n-2));
    }

    private int fib_dp(int n) {
        f[1] = f[2] = 1;
        for (int i=3; i<=N; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        fib_recur(N);

        fib_dp(N);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }



}
