package stackQueue.Lessons_42587;

import java.util.*;

public class Solution {
    List<Integer> priority_queue = new ArrayList<>();
    private void init(int[] priorities) {
        for (int i=0; i<priorities.length; i++) {
            priority_queue.add(priorities[i]);
        }
    }
    private int calc_order_during_revolve(List<Integer> range, int cur) {
        int cnt = 0;
        int size = range.size();

        while (!range.isEmpty()) {
            int first = range.get(0);
            boolean hasBigger = false;
            for (int i = 1; i < range.size(); i++) {
                if (first < range.get(i)) {
                    hasBigger = true;
                    break;
                }
            }

            if (hasBigger) {
                range.add(range.remove(0));
                if (cur == 0) {
                    cur = size - 1;
                } else {
                    cur--;
                }

            } else {
                range.remove(0);
                cnt++;
                size--;
                if (cur == 0) {
                    return cnt;
                } else {
                    cur--;
                }
            }
        }
        return cnt;
    }
    public int solution(int[] priorities, int location) {

        init(priorities);
        int res = calc_order_during_revolve(priority_queue, location);
        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        new Solution().solution(priorities, location);
    }

}
