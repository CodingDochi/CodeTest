package algorithmLesson.breadthFirstSearch.P_24444;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private void bfs(List<Integer> V, List<List<Integer>> E, int R) {

        Queue<Integer> start_vertex_queue = new LinkedList<>();
        List<Boolean> visited = new ArrayList<>();

        for (int i = 0; i < V.size()+1; i++) {
            visited.add(false);
        }
        visited.set(R, true);
        start_vertex_queue.add(R);

        while (!start_vertex_queue.isEmpty()) {
            int u = start_vertex_queue.poll();
            V.remove(Integer.valueOf(u));
            System.out.println(u);

            V.stream().forEach(elem -> System.out.println(" V : "+elem.toString()));
            E.stream().forEach(elem -> System.out.println(" E[u] : "+elem.toString()));

            for (int u_vertex : E.get(u)) {
                if (E.get(u) == null) {
                    continue;
                }
                if (visited.get(u_vertex) == false) {
                    visited.set(u_vertex, true);
                    start_vertex_queue.add(u_vertex);
                }
            }
        }
        if (!V.isEmpty()) {
            V.stream().forEach(elem -> System.out.println(0+"\n"));
        }
    }
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        List<List<Integer>> E = new ArrayList<List<Integer>>();
        for (int i = 0; i < N; i++) {
            E.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            E.get(u).add(v);
        }

        for (List<Integer> u_vertex_list : E) {
            Collections.sort(u_vertex_list);
        }

        List<Integer> V = new ArrayList<>();
        for (int v = 1; v <= N; v++) {
            V.add(v);
        }

        bfs(V, E, R);
    }

    public static void main(String[] args) throws Exception {
        new UsingStringBuilder().solution();
    }

}
