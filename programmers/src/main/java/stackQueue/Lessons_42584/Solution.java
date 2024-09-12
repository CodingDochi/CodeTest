package stackQueue.Lessons_42584;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] prices) {

        Queue<Integer> result_queue = new LinkedList<>();
        Queue<Integer> price_queue = new LinkedList<>();

        // 주어진 prices 배열을 큐에 추가
        for (int price : prices) {
            price_queue.offer(price);
        }

        // 큐가 빌 때까지 처리
        while (!price_queue.isEmpty()) {
            int currentPrice = price_queue.poll();  // 현재 가격
            int cnt = 0;  // 가격이 유지된 시간

            // 현재 가격 이후의 가격들과 비교
            for (Integer nextPrice : price_queue) {
                cnt++;
                if (currentPrice > nextPrice) {  // 가격이 떨어지면 멈춤
                    break;
                }
            }
            result_queue.offer(cnt);  // 유지된 시간 결과 저장
        }

        // 결과를 int[]로 변환
        int[] answer = new int[result_queue.size()];
        int i = 0;
        for (Integer res : result_queue) {
            answer[i++] = res;
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {

        int[] prices = new int[] {1, 2, 3, 2, 3};
        new Solution().solution(prices);
    }
}