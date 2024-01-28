package algorithmLesson.asymtoticNotation.P_24314;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int a1;
    private int a0;
    private int c;
    private int n0;
    private int result;

    /*

    빅 오메가 표기법 : 빅 오메가는 주어진 함수의 하한을 나타내므로, 해당 함수의 실행 시간의 하한을 추정하는 데 사용될 수 있습니다. 그것은 최선의 경우 시나리오를 나타냅니다. 함수 g(n)이 함수 f(n)의 하한을 나타내려면 다음과 같이 표현합니다.

    Ω(g(n)) = {f(n) | 모든 n ≥ n0에 대하여 c × g(n) ≤ f(n)인 양의 상수 c와 n0가 존재한다}

    (1 ≤ c ≤ 100),
    (1 ≤ n0 ≤ 100),
    (0 ≤ |ai| ≤ 100)

    f(n) = a1 * n + a0
    g(n) = n

    a0 >= (c - a1) * n

    (i) c - a1 == 0 일 때,
    n 값과 무관하게 항상 0
    a0 >= 0 이어야 성립

    (ii) c - a1 > 0 일 때,
    n은 양수이므로 우항 최소값은 1
    a0 >= n 이어야 성립, 그러나 n의 범위 최소값이 1이므로 성립 불가

    (iii) c - a1 < 0 일 때,
    n은 양수이므로 우항 최대값은 -1
    a0 >= -n 이어야 성립, a0의 범위 내에서 성립.

    (iii)의 결과부분이 (i)의 결과부분을 포함하고
    (i)의 조건부분이 (iii)의 조건부분을 포함하므로
    (i)와 (iii)를 결합하여 (c <= a1)로 정리 가능

     */

    private int f(int n) {
        return a1 * n + a0;
    }

    private int g(int n) {
        return n;
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a1 = Integer.parseInt(st.nextToken());
        a0 = Integer.parseInt(st.nextToken());

        c = Integer.parseInt(br.readLine());
        n0 = Integer.parseInt(br.readLine());


        if ((f(n0)>= c * g(n0)) && (c <= a1)) {
            result = 1;
        }
        else {
            result = 0;
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
