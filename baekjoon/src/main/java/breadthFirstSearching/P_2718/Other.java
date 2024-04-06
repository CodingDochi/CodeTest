package breadthFirstSearching.P_2718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Other {

    static int N;
    static int M;

    static int[][] mazeMap;
    static boolean[][] booleansMaze;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mazeMap = new int[N + 1][M + 1];
        booleansMaze = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), "", true);
            String string = st.nextToken();
            for (int j = 1; j < M + 1; j++) {
                mazeMap[i][j] = Integer.parseInt(string.substring(j - 1, j));
            }
        }

        BFS(1, 1);
        System.out.println(mazeMap[N][M]);
    }

    static void BFS(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            booleansMaze[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int plusX = now[0] + moveX[i];
                int plusY = now[1] + moveY[i];
                if (plusX >= 1 && plusY >= 1 && plusX < N + 1 && plusY < M + 1) {
                    if (mazeMap[plusX][plusY] != 0 && !booleansMaze[plusX][plusY]) {
                        booleansMaze[plusX][plusY] = true;
                        mazeMap[plusX][plusY] = mazeMap[now[0]][now[1]] + 1;
                        queue.add(new int[]{plusX, plusY});
                    }
                }
            }
        }
    }
}