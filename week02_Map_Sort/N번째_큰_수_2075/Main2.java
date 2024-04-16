package N번째_큰_수_2075;

import java.util.*;
import java.io.*;

class Solution2 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int value;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int last = set.last();
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                value = Integer.parseInt(st.nextToken());
                if (value > last) {
                    set.remove(last);
                    set.add(value);
                    last = set.last();
                }
            }
        }
        bw.write(String.valueOf(set.last()));
        bw.flush();
        bw.close();
    }
}
public class Main2 {
    public static void main(String[] args) throws IOException {
        Solution2 s = new Solution2();
        s.solution();
    }
}