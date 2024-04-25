package 서강근육맨_20300;

import java.util.*;
import java.io.*;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Long> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(arr);

        long max = 0;
        long sum = 0;
        if (n % 2 != 0) {
            n -= 1;
        }
        for (int i = 0; i < (n / 2); i++) {
            sum = arr.get(i) + arr.get((n - 1) - i);
            if (sum > max) {
                max = sum;
            }
        }
        if (arr.size() % 2 != 0 && arr.get(n) > max) {
            max = arr.get(n);
        }
        bw.write(String.valueOf(max));
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
 * 문제 : n개의 수가 주어진다. n개의 수들을 두 개씩 짝지어서 더할 때 나올 수 있는 최소값을 구하라. n이 홀수인 경우, 하나 남은 수를 합으로 생각한다
 * 제한시간 : 1초
 * ArrayList.getLast() 는 Java21부터 지원한다.
 */
