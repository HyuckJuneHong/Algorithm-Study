package java_algorithm_study.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환 {
    static int n, m, answer = Integer.MAX_VALUE;

    public void dfs(int level, int sum, Integer[] arr){
        if(sum > m){
            return;
        }
        if(level >= answer){
            return;
        }
        if(sum == m){
            answer = Math.min(answer, level);
        }else{
            for(int i=0; i<n; i++){
                dfs(level+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        동전교환 T = new 동전교환();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt();
        T.dfs(0, 0, arr);
        System.out.println(answer);
    }
}