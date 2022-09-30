package java_algorithm_study.dynamic_LIS;

import java.util.Scanner;

public class 최대부분증가수열 {

    static int[] dy;

    public static void main(String[] args) {
        최대부분증가수열 T = new 최대부분증가수열();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(T.solution(arr));
    }

    private int solution(int[] arr) {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;
        answer = dy[0];
        for(int i=1; i<arr.length; i++){
            int max = 0;

            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i] && dy[j] > max){
                    max = dy[j];
                }
            }
            dy[i] = max+1;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }
}
