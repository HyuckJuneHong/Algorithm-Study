package java_algorithm_study.dynamic_programming;

import java.util.Scanner;

public class 돌다리건너기 {
    static int[] dy;
    public int solution(int n){
        dy[1] = 1;
        dy[2] = 2;

        for(int i=3; i<=n+1; i++){
            dy[i] = dy[i-2] + dy[i-1];
        }

        return dy[n+1];
    }

    public static void main(String[] args) {
        돌다리건너기 T = new 돌다리건너기();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        dy = new int[n+2];
        System.out.println(T.solution(n));

    }
}

