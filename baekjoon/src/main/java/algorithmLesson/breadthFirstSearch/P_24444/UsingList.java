package algorithmLesson.breadthFirstSearch.P_24444;

import java.util.*;
import java.io.*;

public class UsingList {
    static int N, M, R;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> E;

    public static void bfs(int R){
        Queue<Integer> vertex_visit = new LinkedList<>();
        vertex_visit.offer(R);
        int cnt = 1;
        visited[R] = 1;

        while(!vertex_visit.isEmpty()){
            int cur = vertex_visit.poll();
            Collections.sort(E.get(cur));

            for(int i : E.get(cur)){
                if(visited[i] == 0){
                    cnt++;
                    visited[i] = cnt;
                    vertex_visit.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        E = new ArrayList<>();

        for(int i = 0; i <= N; i++){
            E.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++){
            String line = br.readLine();
            String[] split = line.split(" ");

            int n1 = Integer.parseInt(split[0]);
            int n2 = Integer.parseInt(split[1]);

            E.get(n1).add(n2);
            E.get(n2).add(n1);
        }

        bfs(R);

        for(int i = 1; i <= N; i++){
            sb.append(visited[i]).append('\n');
        }

        System.out.println(sb);
    }
}