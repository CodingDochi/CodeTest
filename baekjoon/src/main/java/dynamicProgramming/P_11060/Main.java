package dynamicProgramming.P_11060;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] maze, DP;	//미로에 대한 정보, 메모이제이션 배열
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        maze = new int[N];
        DP = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //미로 정보 저장 및 메모이제이션 초기화
        for(int i=0;i<N;i++) {
            maze[i] = Integer.parseInt(st.nextToken());
            DP[i] = 1001;
        }
        DP[0] = 0;	//왼쪽 끝 칸에서 시작이므로 0으로 초기화
        for(int i=0;i<N-1;i++) {
            if (DP[i] == Integer.MAX_VALUE)	//해당 칸 방문 X
                continue;
            //각 칸에서 점프 가능한 칸 탐색
            for (int j = 1; j <= maze[i]; j++) {
                if(i+j<N){	//미로에 벗어나지 않을 때
                    if(DP[i+j] > DP[i]+1)	//DP를 이용해 해당 칸 최소값 구하기
                        DP[i+j] = DP[i]+1;
                }
            }
        }
        if(DP[N-1]== 1001)	//가장 오른쪽 칸 도달 불가능시.
            bw.write("-1");
        else		//가장 오른쪽 칸 도달시.
            bw.write(DP[N-1] + "");
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}