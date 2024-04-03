package 쇠막대기_10799;
import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int count = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                if (s.charAt(i - 1) == ')') {
                    count++;
                    open--;
                    continue;
                }
                open--;
                count += open;
            }
        }
        bw.write(String.valueOf(count));
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
 * 막대기가 종료되는 시점에 한 덩어리를 추가하는 과정이 필요했음
 */