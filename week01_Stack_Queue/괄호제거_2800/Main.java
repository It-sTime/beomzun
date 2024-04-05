package 괄호제거_2800;
import java.util.*;
import java.io.*;

class Solution {
    static char[] s;
    static Boolean[] visited;
    static ArrayList<Pair> pairs = new ArrayList<>();
    static boolean isFirst = true;
    static TreeSet<String> set = new TreeSet<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = br.readLine().toCharArray();
        visited = new Boolean[s.length];
        Stack<Integer> stack = new Stack<>();

        Arrays.fill(visited, true);

        //주어진 식
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                pairs.add(new Pair(stack.pop(), i));
            }
        }

        hit(0);
        for (String s : set) {
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void hit(int index) {
        if (index == pairs.size()) {
            if (isFirst) {
                isFirst = false;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length; i++) {
                    if (visited[i]) {
                        sb.append(s[i]);
                    }
                }
                set.add(sb.toString());
            }
            return;
        }
        Pair pair = pairs.get(index);
        visited[pair.open] = true;
        visited[pair.close] = true;
        hit(index + 1);

        visited[pair.open] = false;
        visited[pair.close] = false;
        hit(index + 1);
    }

    static class Pair {
        int open;
        int close;
        Pair(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }
}
public class Main {
   public static void main(String[] args) throws IOException {
       Solution s = new Solution();
       s.solution();
   }
}

/**
 * 제한시간 1초 /  N=1~10 N!/r!(n-r!) * 200 = 1024 * 200 => n = 204,800
 * 스택을 사용하여 괄호 쌍 저장까지는 떠올렸으나, 재귀의 상세 과정을 떠올리지 못함.
 */