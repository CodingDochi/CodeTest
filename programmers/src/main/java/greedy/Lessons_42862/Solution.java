package greedy.Lessons_42862;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    List<Integer> lost_list;
    List<Integer> reserve_list;
    List<Integer> available;
    int cnt;
    int res;
    public int solution(int n, int[] lost, int[] reserve) {
        available = new ArrayList<>();
        lost_list = new ArrayList<>();
        reserve_list = new ArrayList<>();

        for (int r : reserve) {
            reserve_list.add(r);
        }
        for (int l : lost) {
            lost_list.add(l);
        }

        cnt = n - lost_list.size();

        Iterator<Integer> iterator = lost_list.iterator();
        while (iterator.hasNext()) {
            int l = iterator.next();
            if (reserve_list.contains(l)) {
                cnt++;
                iterator.remove();
                reserve_list.remove(reserve_list.indexOf(l));
            }
        }

        for (int r : reserve_list) {
            available.add(r-1);
            available.add(r+1);
        }

        for (int l : lost_list) {
            if (available.contains(l) && (reserve_list.contains(l + 1) || reserve_list.contains(l - 1))) {
                cnt++;
                if (available.contains(l + 2) && !available.contains(l - 2)) {
                    available.remove(available.indexOf(l + 2));
                } else if (!available.contains(l + 2) && available.contains(l - 2)) {
                    available.remove(available.indexOf(l - 2));
                }
            }
        }

        if (cnt > n) {
            res = n;
//            System.out.println("n : "+res);
        }
        res = cnt;
//        System.out.println("cnt : "+res);

        return res;
    }
    public static void main(String[] args) {
        int n = 3;
        int[] lost = {3};
        int[] reserve = {1};

        new Solution().solution(n, lost, reserve);
    }
}
