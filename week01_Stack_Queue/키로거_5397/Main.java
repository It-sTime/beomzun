package 키로거_5397;

import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                switch(c) {
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                        break;
                }
            }
            for (char c : list) {
                bw.write(c);
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
 * 제한시간 1초 / n = 1,000,000
 * StringBuilder 를 잘 사용하자. 중도 삽입 - insert | 중도 삭제 - deleteCharAt | 초기화 - setLength
 * 시간 초과 원인 : StringBuilder 가 배열이었으므로 삽입 삭제 과정에서 O(n)의 시간 소요.
 *
 * iter.toString() 은 내부 데이터를 String으로 변환하는 것이 아님.
 */