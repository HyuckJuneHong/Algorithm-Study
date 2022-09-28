package java_algorithm_study.hashMap_treeSet;

import java.util.*;

public class Tree_K번째큰수 {
    private int solution(int n, int k, int[] a) {
        int answer = -1;

        //내림차순
        Set<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int z=j+1; z<n; z++){
                    set.add(a[i] + a[j] + a[z]);
                }
            }
        }
        int count = 0;
        for(int x : set){
            count++;
            if(count==k)
                return x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Tree_K번째큰수 T = new Tree_K번째큰수();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();

        int[] a=new int[n];

        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }

        System.out.println(T.solution(n, k, a));
    }

}
