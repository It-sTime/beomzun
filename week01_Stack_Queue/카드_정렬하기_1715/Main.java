package 카드_정렬하기_1715;

import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long sum = 0L;
        long inSum = 0L;
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        if (n == 1) {
            bw.write(String.valueOf(0));
        } else if (n == 2) {
            bw.write(String.valueOf(pq.remove() + pq.remove()));
        } else {
            while (pq.size() != 1) {
                inSum = pq.remove() + pq.remove();
                sum += inSum;
                pq.add(inSum);
            }
            bw.write(String.valueOf(sum));
        }
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
 * 제한시간 2초 / n = 100,000
 * Collections.sort -> n*log(n) | Arrays.sort -> ~n^2
 * 실패 원인 : 정렬 후 순서대로 더할경우, 앞쪽에서 무수히 커진 수와 뒤쪽의 작은수가 만나서 좋지못함.
 * -> 개선 방향 : 우선순위 큐를 사용하여 가장 작은 뭉치 두 개를 합한 뒤 이 뭉치를 다시 큐에 삽입.
 * 실패 원인 : 뭉치가 한 개인 경우 비교하지 않는다..!
 */