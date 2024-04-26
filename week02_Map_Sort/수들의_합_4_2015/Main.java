package 수들의_합_4_2015;

import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정수의 개수
        int n = Integer.parseInt(st.nextToken());
        //타겟 부분합
        int k = Integer.parseInt(st.nextToken());
        //부분합 배열
        int[] sum = new int[n];
        //부분합을 key, 지금까지의 부분합 개수를 val 로 갖는 map
        Map<Integer, Long> map = new HashMap<>();

        long count = 0;
        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        map.put(sum[0], 1L);
        if (sum[0] == k) {
            count++;
        }

        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            if (sum[i] == k) {
                count++;
            }
            count += map.getOrDefault(sum[i] - k, 0L);
            map.put(sum[i], map.getOrDefault(sum[i], 0L) + 1);
        }

        bw.write(count + "");
        bw.flush();
        bw.close();
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}

/**
 * 문제 : 정수 배열이 주어졌을 때, 부분합이 k인 구간이 몇 군데인지 구하라
 * 제한시간 2초
 * 실패 사유 : 시간 초과 -> 부분합 구간이 어디인지는 중요하지 않다. 개수만 저장하자 \ 부분합 개수는 int 범위를 넘는다
 */
