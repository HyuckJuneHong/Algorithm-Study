package java_algorithm_study.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산_postfix {
    public int solution(String str){
        int answer=0;
        Stack<Integer> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                stack.push(c-48);
            }else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(c == '+') stack.push(lt+rt);
                else if(c == '-') stack.push(lt-rt);
                else if(c == '*') stack.push(lt*rt);
                else if(c == '/') stack.push(lt/rt);
            }
        }
        answer = stack.get(0);
        return answer;
    }

    public static void main(String[] args) {
        후위식연산_postfix T = new 후위식연산_postfix();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        System.out.println(T.solution(str1));
    }
}
