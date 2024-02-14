package algorithmLesson.breadthFirstSearch.P_24445;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    int M;
    int R;

    private void bfs(List<Boolean> visited, List<List<Integer>> E, int R) {

        StringBuilder sb = new StringBuilder();
        Queue<Integer> vertex_visit = new LinkedList<Integer>();
        int cnt = 1;

        List<Integer> visited_order = new ArrayList<>();
        for (int v = 1; v <= N+1; v++) {
            visited_order.add(0);
        }

        visited.set(R, true);
        visited_order.set(R, cnt);
        vertex_visit.add(R);

        while (!vertex_visit.isEmpty()) {
            int u = vertex_visit.poll();
            for (int v : E.get(u)) {

                if (v != R &&(!visited.get(v))) {
                    visited.set(v, true);
                    visited_order.set(v, ++cnt);
                    vertex_visit.add(v);
                }
            }
        }
        for (int v = 1; v < N+1; v++) {
            sb.append(visited_order.get(v)).append("\n");
        }
        System.out.println(sb);
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        List<List<Integer>> E = new ArrayList<>();

        for (int i = 1; i <= N+1; i++) {
            E.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            E.get(u).add(v);
            E.get(v).add(u);
        }

        for (List<Integer> list : E) {
            Collections.sort(list, Comparator.reverseOrder());
        }

        List<Boolean> visited = new ArrayList<>();
        for (int v = 1; v <= N+1; v++) {
            visited.add(false);
        }

        bfs(visited, E, R);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
