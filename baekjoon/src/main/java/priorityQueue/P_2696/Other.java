package priorityQueue.P_2696;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Other {

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
    }
    public static void main(String[] args) throws Exception {
        new Other().cases();
    }

}
