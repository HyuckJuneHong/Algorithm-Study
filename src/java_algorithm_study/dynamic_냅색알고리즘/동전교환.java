package java_algorithm_study.dynamic_냅색알고리즘;

import java.util.Arrays;
import java.util.Scanner;

public class 동전교환 {
    static int n, m;
    static int[] dy;

    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;

        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=m; j++){
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args) {
        동전교환 T = new 동전교환();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scanner.nextInt();
        }

        m = scanner.nextInt();
        dy = new int[m+1];
        System.out.println(T.solution(arr));
    }
}
