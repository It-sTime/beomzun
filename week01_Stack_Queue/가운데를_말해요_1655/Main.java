package 가운데를_말해요_1655;

import java.io.*;
import java.util.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> rQ = new PriorityQueue<>();  //트리의 우측 가지 -> 최소힙
        PriorityQueue<Integer> lQ = new PriorityQueue<>(Comparator.reverseOrder());     //트리의 좌측 가지 -> 최대힙
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            if (lQ.isEmpty()) {
                lQ.add(value);
                bw.write(String.valueOf(value));
            } else if (rQ.isEmpty()) {
                if (value >= lQ.element()) {
                    rQ.add(value);
                    bw.write(String.valueOf(lQ.element()));
                } else {
                    rQ.add(lQ.remove());
                    lQ.add(value);
                    bw.write(String.valueOf(value));
                }
            } else {
                if (lQ.size() > rQ.size()) {
                    if (value < lQ.element()) {
                        rQ.add(lQ.remove());
                        lQ.add(value);
                        bw.write(String.valueOf(lQ.element()));
                    } else {
                        rQ.add(value);
                        bw.write(String.valueOf(lQ.element()));
                    }
                } else if (lQ.size() == rQ.size()) {
                    if (value <= rQ.element()) {
                       lQ.add(value);
                        bw.write(String.valueOf(lQ.element()));
                    } else {
                        rQ.add(value);
                        lQ.add(rQ.remove());
                        bw.write(String.valueOf(lQ.element()));
                    }
                }
            }
            bw.write("\n");
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
 * 제한시간 0.1초 / n=100,000
 * 첫 번째 아이디어 : ListIterator -> 삽입 어려움
 * 두 번째 아이디어 : AVL 트리 -> 높이 차가 1이지 양쪽의 수가 동일한 것은 아님.
 * 세 번째 아이디어 : 큐 두 개 쓰기 -> 트리의 양쪽을 하나씩 큐로 만드는 느낌.
 */