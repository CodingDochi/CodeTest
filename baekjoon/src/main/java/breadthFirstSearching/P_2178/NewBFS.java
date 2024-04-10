package breadthFirstSearching.P_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NewBFS {

    int N;
    int M;
    int[][] dp;
    int[][] maze;

    private void bfs() {

        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];

            if (row < 0 || row >= N || col < 0 || col >= M) {
                return;
            }
            if (maze[row][col] == 0) {
                return;
            }
            if (maze[row][col] == 1) {
                count++;
                if ((dp[row][col] == 0) || (dp[row][col] >= count)) {
                    dp[row][col] = count;
                    queue.add(new int[]{row, col});




        }

    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        maze = new int[N][M];
        for (int i=0; i < N; i++) {
            String content = br.readLine();
            for (int j=0; j < M; j++) {
                int num = Character.getNumericValue(content.charAt(j));
                maze[i][j] = num;
            }
        }
        bfs(maze, 0, 0, 0);
        System.out.println(dp[N-1][M-1]);
    }

    public static void main(String[] args) throws Exception{
        new NewBFS().solution();
    }


}
