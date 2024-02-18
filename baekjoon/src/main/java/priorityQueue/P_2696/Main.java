package priorityQueue.P_2696;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    // 중앙값 : 정렬된 수열이 홀수 개의 원소로 이루어졌다면 가운데,
    // 짝수 개의 원소로 이루어졌다면 가운데 두 수의 평균
    // 수열에는 부호 있는 정수도 포함되어 있다.
    // 중앙값 이전 : 최대힙 / 중앙값 이후 : 최소힙 으로 정렬

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private List<Integer> mid_val_list (int seq_num, List<Integer> seq) {

        StringBuilder sb = new StringBuilder();

        int cnt = 0;
        List<Integer> mid_vals = new ArrayList<>();

        for (int i = 0; i < seq_num; i = i+2) {
            List<Integer> to_sort = (seq.subList(0, i + 1));
            Collections.sort(to_sort);
            mid_vals.add(to_sort.get(i/2));
        }
        for (int elem : mid_vals) {
            sb.append(elem).append(" ");
            cnt++;
            if (cnt == 10) {
                sb.append("\n");
                cnt = 0;
            }
        }
        System.out.println(seq_num/2 +1);
        System.out.println(sb);
        return mid_vals;
    }

    private void cases() throws Exception {

        int case_num = Integer.parseInt(br.readLine());

        for (int i=0; i < case_num; i++) {
            solution();
        }
    }

    private void solution() throws Exception {

        int seq_num = Integer.parseInt(br.readLine());
        List<Integer> seq = new ArrayList<>();

        int br_cnt;
        if (seq_num % 10 != 0) {
            br_cnt = seq_num/10 + 1;
        } else {
            br_cnt = seq_num/10;
        }

        for (int i = 0; i < br_cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                if (st.hasMoreTokens()) {
                    int elem = Integer.parseInt(st.nextToken());
                    seq.add(elem);
                } else {
                    break;
                }
            }
        }
        mid_val_list(seq_num, seq);
    }
    public static void main(String[] args) throws Exception {
        new Main().cases();
    }
}
