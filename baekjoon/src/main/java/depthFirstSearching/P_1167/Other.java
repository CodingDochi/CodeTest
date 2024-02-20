package depthFirstSearching.P_1167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Other {

    int V;
    List<List<Integer>> record;
    List<Boolean> visited;
    List<List<Integer>> E;

    private void calc_dist (int start) {
        for (int i = 1; i < V+1; i++) {
            for (int j = 1; i < V+1; i++) {
                if (visited.get(j)==false && E.get(i).get(j) != 0) {
                    visited.set(j, true);

                }
            }
        }
    }


    private void dp_max_dist_for_current (int cur, int from) {
        int max_dist_for_cur;
    }



    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        record = new ArrayList<>();

        // 각 줄의 입력을 받음
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> for_record = new ArrayList<>();
            int num = Integer.parseInt(st.nextToken());
            while (num != -1) {
                for_record.add(num);
                num = Integer.parseInt(st.nextToken());
            }
            record.add(for_record);
        }
        System.out.println(record.toString());

        // 간선 정보 별도의 자료 구조에 저장
        E = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            List<Integer> per_node = new ArrayList<>();
            for (int j = 0; j < V + 1; j++) {
                per_node.add(0);
            }
            E.add(per_node);
        }

        for (int i = 0; i < V; i++) {
            for (int j = 1; j < record.get(i).size() - 1; j = j + 2) {
                int from = record.get(i).get(0);
                int to = record.get(i).get(j);
                int dist = record.get(i).get(j + 1);

                E.get(from).set(to, dist);
            }
        }
        System.out.println(E.toString());

        visited = new ArrayList<>();
        for (int i=0; i < V+1; i++) {
            visited.add(false);
        }

    }


    public static void main(String[] args) throws Exception {
        new Other().solution();
    }

}
