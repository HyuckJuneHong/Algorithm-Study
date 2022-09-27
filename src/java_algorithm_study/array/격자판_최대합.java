package java_algorithm_study.array;

import java.util.Scanner;

/*
     0  1  2  3  4
  0  00 01 02 03 04
  1  10 11 12 13 14
  2  20 21 22 23 24
  3  30 31 32 33 34
  4  40 41 42 43 44
 */
public class 격자판_최대합 {
    public int solution(int n, int[][] arr){
        int answer=0;
        int sum1, sum2, sum3=0, sum4=0;

        for(int i=0; i<n; i++){
            sum1 = sum2 = 0;
            for(int j=0; j<n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        for(int i=0; i<n; i++){
            sum3 += arr[i][i];
            sum4 += arr[i][n-i-1];
        }
        answer = Math.max(answer, sum3);
        answer = Math.max(answer, sum4);

        return answer;
    }

    public static void main(String[] args) {
        격자판_최대합 T = new 격자판_최대합();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        System.out.println(T.solution(n, arr));
    }
}
