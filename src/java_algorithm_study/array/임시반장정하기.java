package java_algorithm_study.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
00 01 02 03 04
10 11 12 13 14
20 21 22 23 24
30 31 32 33 34
40 41 42 43 44
 */
public class 임시반장정하기 {
    public int solution(int n, int[][] arr){
        int answer = 0;
        int max=Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<n; j++){
                for(int k=0; k<5; k++){
                    if(arr[i][k] == arr[j][k]){
                        count++;
                        break;
                    }
                }
            }

            if(count > max){
                max = count;
                answer=i;
            }
        }
        return answer+1;
    }

    public static void main(String[] args) {
        임시반장정하기 T = new 임시반장정하기();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] arr = new int[n][5];

        for(int i=0; i<n; i++){
            for(int j=0; j<5; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
