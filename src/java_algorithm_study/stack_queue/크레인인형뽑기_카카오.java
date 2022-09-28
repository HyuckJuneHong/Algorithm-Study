package java_algorithm_study.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기_카카오 {
    public int solution(int[][] arr1, int[] arr2){
        int answer=0;

        Stack<Integer> stack = new Stack<>();
        for(int a : arr2){
            for(int i=0; i<arr1.length; i++){
                if(arr1[i][a-1] != 0){
                    int temp = arr1[i][a-1];
                    arr1[i][a-1] = 0;
                    if(!stack.isEmpty() && temp==stack.peek()){
                        answer += 2;
                        stack.pop();
                    }else{
                        stack.push(temp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        크레인인형뽑기_카카오 T = new 크레인인형뽑기_카카오();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int[][] arr1=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr1[i][j]=kb.nextInt();
            }
        }

        int k=kb.nextInt();
        int[] arr2=new int[k];
        for(int i=0; i<k; i++){
            arr2[i]=kb.nextInt();
        }

        System.out.println(T.solution(arr1, arr2));
    }
}
