package algorithmLesson.breadthFirstSearch.P_24444;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Other {

    int N;
    int M;
    int R;

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());


        int[] V = new int[N + 1];
        for (int v = 1; v < N + 1; v++) {
            V[v] = v;
        }

        int[][] E = new int[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            E[i] = new int[N];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            E[u][v] = 1;
        }

        bfs(V, E, R);
    }

    private void bfs (int[] V, int[][] E, int R) {

        Queue<Integer> vertex_to_go = new LinkedList<Integer> ();

        boolean[] visited = new boolean[N + 1];
        for (int v = 1; v < N + 1; v++) {
            visited[v] = false;
        }

        visited[R] = true;
        vertex_to_go.add(R);

        while (!vertex_to_go.isEmpty()) {

        }




    public static void main(String[] args) throws Exception {
        new Other().solution();
    }

}


}
