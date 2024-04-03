package 스택수열_1874;

import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            if (tmp > max) {
                while (tmp != max) {
                    max++;
                    stack.push(max);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                while (true) {
                    int pop = stack.pop();
                    sb.append("-\n");
                    if (tmp < pop) {
                        sb.setLength(0);
                        sb.append("NO");
                        System.out.println(sb);
                        return;
                    } else if (tmp == pop) {
                        break;
                    } else {
                        sb.append("-\n");
                    }
                }
            }
        }
        System.out.println(sb);
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
 * pop 값이 해당 단계에서의 수열의 값보다 크면 NO.
 */