package java_algorithm_study.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 공통원소구하기 {
    public List<Integer> solution(int n, int m, int[] a, int[] b){
        List<Integer> list = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);

        int i=0, j=0;
        while(i<n && j<m){
            if(a[i] == b[j]){
                list.add(a[i++]);
                j++;
            }else if(a[i] < b[j]){
                i++;
            }else{
                j++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        공통원소구하기 T = new 공통원소구하기();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }

        int m=kb.nextInt();
        int[] b=new int[m];
        for(int i=0; i<m; i++){
            b[i]=kb.nextInt();
        }

        for(int x: T.solution(n, m, a, b)){
            System.out.print(x+ " ");
        }
    }
}


