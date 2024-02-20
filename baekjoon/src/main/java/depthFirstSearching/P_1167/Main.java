package depthFirstSearching.P_1167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    int V;
    List<List<Integer>> record;
    List<List<Integer>> E;
    List<Boolean> visited;
//    List<Integer> max_dist;
    int dist = 0;
    int cur_max_dist = 0;

    private int maximal_dist(int start) {
        visited.set(start, true);
        int local_max = 0;
        for (int i = 1; i < V+1; i++) {
            if (E.get(start).get(i) != 0) {
                if (visited.get(i) == false) {
                    visited.set(i, true);
                    dist += E.get(start).get(i);
//                    max_dist.set(i, dist);
                    int next_max_dist = maximal_dist(i);
                    local_max = Math.max(local_max, next_max_dist + dist);
                    System.out.println("start : "+start+"   i : "+i+"   dist : "+dist+"   local_max : "+local_max);
                    visited.set(i, false);
//                    dist = 0;
                }
            }
        }
//        cur_max_dist = Collections.max(max_dist);
//        System.out.println(cur_max_dist);
        return local_max;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        record = new ArrayList<>();
        for (int j = 0; j <= V ; j++) {
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                sub.add(0);
            }
            record.add(sub);
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> for_record = new ArrayList<>();
            while(st.hasMoreTokens()){
                for_record.add(Integer.parseInt(st.nextToken()));
            }
            record.set(i+1, for_record);
        }
        System.out.println(record.toString());

        E = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            List<Integer> per_node = new ArrayList<>();
            for (int j = 0; j < V+1; j++) {
                per_node.add(0);
            }
            E.add(per_node);
        }

        for (int i = 0; i <=V; i++) {
            for (int j = 1; j < record.get(i).size()-1; j=j+2) {
                int from = record.get(i).get(0);
                int to = record.get(i).get(j);
                int dist = record.get(i).get(j+1);

                E.get(i).set(to, dist);
            }
        }
        System.out.println(E.toString());

        visited = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            visited.add(false);
        }

//        max_dist = new ArrayList<>();
//        for (int i = 0; i <= V; i++) {
//            max_dist.add(0);
//        }

        for (int v = 1; v <= V; v++) {
            int maxDistance = maximal_dist(v);
            cur_max_dist = Math.max(cur_max_dist, maxDistance);
        }
        System.out.println(cur_max_dist);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
