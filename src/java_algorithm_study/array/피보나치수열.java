package java_algorithm_study.array;

import java.util.ArrayList;
import java.util.Scanner;

public class 피보나치수열 {

    public ArrayList<Integer> solution(int n){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(1);
        answer.add(1);
        answer.add(2);

        for(int i=3; i<n; i++){
            answer.add(answer.get(i-2) + answer.get(i-1));
        }

        return answer;
    }

    public void solution2(int n){
        int a=1, b=1, c;
        System.out.print(a + " " + b + " ");

        for(int i=2; i<n; i++){
            c = a+b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

    public static void main(String[] args) {
        피보나치수열 T = new 피보나치수열();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();

        for(int x: T.solution(n)){
            System.out.print(x+" ");
        }
    }
}
