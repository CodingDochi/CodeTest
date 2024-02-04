package colatz;

class Solution {
    private int makeNumber(long res) {
        int cnt = 0;

        while (res > 1) {
            if (cnt > 500) {
                return -1;
            }
            if (res % 2 == 0) {
                res = res / 2;
            } else {
                res = (res * 3) + 1;
            }
            cnt++;
        }

        return cnt;
    }

    public int solution(int num) {
        return makeNumber(num);
    }
}