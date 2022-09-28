package java_algorithm_study.hashMap_treeSet;

import java.util.*;

public class Hash_매출액의종류_sliding_window {

    private List<Integer> solution(int n, int k, int[] a) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<k-1; i++){
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        int lt=0;

        for(int rt=k-1; rt<n; rt++){
            map.put(a[rt], map.getOrDefault(a[rt], 0) + 1);
            answer.add(map.size());

            map.put(a[lt], map.get(a[lt]) - 1);
            if(map.get(a[lt]) == 0){
                map.remove(a[lt]);
            }
            lt++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Hash_매출액의종류_sliding_window T = new Hash_매출액의종류_sliding_window();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();

        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        for(int x : T.solution(n, k, a))
            System.out.print(x + " ");
    }
}
