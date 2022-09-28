package java_algorithm_study.sorting;

import java.util.Scanner;

public class LRU_캐시_카카오변형 {

    public static void main(String[] args) {
        LRU_캐시_카카오변형 T = new LRU_캐시_카카오변형();
        Scanner kb = new Scanner(System.in);

        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for(int x : T.solution(s, n, arr))
            System.out.print(x + " ");
    }

    private int[] solution(int s, int n, int[] arr) {
        int[] cache = new int[s];

        for(int x : arr){
            int index = -1;

            //cache hit
            for(int i=0; i<s; i++){
                if(x==cache[i]){
                    index = i;
                }
            }

            //cache miss
            if(index == -1){
                for(int i=s-1; i>=1; i--){
                    cache[i] = cache[i-1];
                }
                cache[0] = x;
            }else{//cache hit
                for(int i=index; i>=1; i--){
                    cache[i] = cache[i-1];
                }
                cache[0] = x;
            }
        }
        return cache;
    }
}
