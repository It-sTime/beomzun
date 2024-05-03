package 문제_추천_시스템_version1_21939;

import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        TreeMap<Integer, TreeSet<Integer>> ps = new TreeMap<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        int num, diff;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            num = Integer.parseInt(st.nextToken());
            diff = Integer.parseInt(st.nextToken());

            if (!ps.containsKey(diff)) {
                ps.put(diff, new TreeSet<>());
            }
            ps.get(diff).add(num);
            map.put(num, diff);
        }

        int inst = Integer.parseInt(br.readLine());
        String word;
        for (int i = 0; i < inst; i++) {
            st = new StringTokenizer(br.readLine());
            word = st.nextToken();
            switch(word) {
                case "recommend":
                    diff = Integer.parseInt(st.nextToken());
                    TreeSet<Integer> set;
                    if (diff == 1) {
                        set = ps.get(ps.lastKey());
                        bw.write(set.last() + "\n");
                    } else {
                        set = ps.get(ps.firstKey());
                        bw.write(set.first() + "\n");
                    }
                    break;
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    diff = Integer.parseInt(st.nextToken());
                    if (!ps.containsKey(diff)) {
                        ps.put(diff, new TreeSet<>());
                    }
                    ps.get(diff).add(num);
                    map.put(num, diff);

                    break;
                case "solved":
                    num = Integer.parseInt(st.nextToken());
                    diff = map.get(num);
                    map.remove(num);
                    ps.get(diff).remove(num);
                    if (ps.get(diff).isEmpty()) {
                        ps.remove(diff);
                    }
                    break;
            }
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
 * 문제 : 문제의 개수 N, 문제 번호와 난이도 P L, 명령어 개수 M, 명령어 M개가 주어진다. 각 명령어에 맞게 출력하라
 * 제한시간 1초
 */
