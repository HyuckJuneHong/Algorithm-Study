package programmers.level1.stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 같은숫자는싫어 {
    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for(int n : arr){
            if(stack.peek()!=n){
                stack.push(n);
            }
        }

        int[] answer = new int[stack.size()];

        for(int i=stack.size()-1; i>=0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 3, 3, 0, 0, 1};


        System.out.println(solution(a));
    }
}
