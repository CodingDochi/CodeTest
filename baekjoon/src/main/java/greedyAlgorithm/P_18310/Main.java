package greedyAlgorithm.P_18310;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// 시간 초과
public class Main {

    int N;

    private int calc_index(Queue<Integer> location) {

        List<Long> sum_distance = new ArrayList<>();

        int i = 1;
        while (i < N) {
            long sum = 0;
            int std = location.poll();
            for (int elem : location) {
                sum = sum + Math.abs(std - elem);
            }
            location.add(std);
            sum_distance.add(sum);
            i++;
        }

        int mem = 0;
        long min_distance = Long.MAX_VALUE;
        for (int j = 0; j < sum_distance.size(); j++) {
            if (sum_distance.get(j) < min_distance) {
                min_distance = sum_distance.get(j);
                mem = j;
            }
        }

        return mem;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<Integer> temp = new ArrayList<>();
        Queue<Integer> location = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(temp);

        for (int elem : temp) {
            location.add(elem);
        }

        int res = temp.get(calc_index(location));
        System.out.println(res);
    }
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }


}
