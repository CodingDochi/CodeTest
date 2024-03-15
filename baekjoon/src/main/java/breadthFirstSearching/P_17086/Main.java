package breadthFirstSearching.P_17086;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N, M;
    int[][] elem_arr;
    Queue<int[]> traverse;
    List<Integer> safe_loop = new ArrayList<>();
    private void search(List<int[]> shark, int[] shark_loc, Queue<int[]> traverse, int loop) {


        int cnt = 0;

        int[] move = traverse.poll();
        int[] visit = {shark_loc[0] + move[0], shark_loc[1] + move[1]};
        System.out.println("visit : "+Arrays.toString(visit));
        while (!shark.contains(visit)) {
            cnt++;
            if (cnt == 8) {

                loop++;
                traverse = propagation(loop, elem_arr);
                search(shark, shark_loc, traverse, loop);
            }
        }
            System.out.println("loop  "+loop);
            System.out.println("cnt  "+cnt);

            safe_loop.add(loop);
        }



    private Queue<int[]> propagation(int loop, int[][] elem_arr) {
        Queue<int[]> new_traverse = new LinkedList<>();
        for (int[] elem : elem_arr) {
            int[] new_elem = {elem[0]*loop, elem[1]*loop};
            new_traverse.add(new_elem);
        }
        return new_traverse;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//        int[] loc = new int[2];
        List<int[]> shark = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                String str = st.nextToken();
                if (Objects.equals(str, "1")) {
                    int[] loc = {i, j};
                    shark.add(loc);
                }
            }
        }


        elem_arr = new int[][]{{0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}};
        traverse = new LinkedList<>();
        for (int[] elem : elem_arr) {
            traverse.add(elem);
        }


        for (int i = 0; i < shark.size(); i++) {
            int[] shark_loc = shark.get(i);
            System.out.println(Arrays.toString(shark_loc));
            search(shark, shark_loc, traverse, 1);
        }


    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
