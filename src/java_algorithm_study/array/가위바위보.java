package java_algorithm_study.array;

import java.util.ArrayList;
import java.util.Scanner;

public class 가위바위보 {

    //1: 가위 , 2: 바위, 3: 보

    //A/B  1  2  3
    //1    0 -1 -2
    //2    1  0 -1
    //3    2  1  0

    //A승 -2  1 1
    //A패 -1 -1 2
    public String solution(int n, int[] arr1, int[] arr2){
        String answer = "";

        for(int i=0; i<n; i++){
            int result = arr1[i] - arr2[i];
            if(result == 0){
                answer += "D";
            }else if(result==-2 || result==1){
                answer += "A";
            }else{
                answer += "B";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        가위바위보 T = new 가위바위보();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i=0; i<n; i++){
            arr1[i] = kb.nextInt();
        }
        for(int i=0; i<n; i++){
            arr2[i] = kb.nextInt();
        }

        for(char c : T.solution(n, arr1, arr2).toCharArray()){
            System.out.println(c);
        }
    }
}
