package java_algorithm_study.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class stack_크레인인형뽑기_카카오 {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] s = new String[n];
        for (int i = 0; i < n; i++)
            s[i] = bufferedReader.readLine();

        Stack<Integer>[] stacks = new Stack[n];
        for (int i = 0; i < n; i++)
            stacks[i] = new Stack<>();

        //나는 세로줄 기준으로 스택을 쌓았음.
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(s[n - i - 1]);
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                if (num != 0) stacks[j].push(num);
            }
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        String move = bufferedReader.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(move);

        //출력 받고
        int[] moves = new int[m];
        for (int i = 0; i < m; i++)
            moves[i] = Integer.parseInt(stringTokenizer.nextToken());

        //점수 계산
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : moves) {
            if (!stacks[i - 1].isEmpty()) {

                if (!stack.isEmpty()) {

                    if (stack.peek() == stacks[i - 1].peek()) {
                        cnt++;
                        stack.pop();
                        stacks[i - 1].pop();
                    } else if (stack.peek() != stacks[i - 1].peek()) {
                        stack.push(stacks[i - 1].pop());
                    }

                } else {
                    stack.push(stacks[i - 1].pop());
                }

            }
        }

        stringBuilder.append(cnt * 2);
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}
