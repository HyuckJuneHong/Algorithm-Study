package java_algorithm_study.two_pointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 두배열합치기 {
    public List<Integer> solution(int n, int m, int[] a, int[] b){
        List<Integer> list = new ArrayList<>();
        int p1=0, p2=0;

        while(p1<n && p2<m){
            if(a[p1] < b[p2]){
                list.add(a[p1++]);
            }else{
                list.add(b[p2++]);
            }
        }

        while(p1<n){
            list.add(a[p1++]);
        }

        while(p2<m){
            list.add(b[p2++]);
        }

        return list;
    }

    public static void main(String[] args) {
        두배열합치기 T = new 두배열합치기();
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
