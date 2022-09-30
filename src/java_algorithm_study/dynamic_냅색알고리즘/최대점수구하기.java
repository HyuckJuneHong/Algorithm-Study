package java_algorithm_study.dynamic_냅색알고리즘;

import java.util.Scanner;

public class 최대점수구하기 {

    public static void main(String[] args) {
        최대점수구하기 T = new 최대점수구하기();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] dy = new int[m+1];

        for(int i=0; i<n; i++){
            int pScore = scanner.nextInt();
            int pTime = scanner.nextInt();

            for(int j=m; j>=pTime; j--){
                dy[j] = Math.max(dy[j], dy[j-pTime] + pScore);
            }
        }
        System.out.println(dy[m]);
    }
}
