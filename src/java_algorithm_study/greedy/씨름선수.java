package java_algorithm_study.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Body implements Comparable<Body>{
    public int h, w;

    public Body(int h, int w) {
        this.h = h;
        this.w = w;
    }


    @Override //내림차순
    public int compareTo(Body o) {
        return o.h - this.h;
    }
}

public class 씨름선수 {
    public int solution(List<Body> arr, int n){
        int answer = 0;
        Collections.sort(arr);

        int max = Integer.MIN_VALUE;
        for(Body b : arr){
            if(b.w > max){
                max = b.w;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        씨름선수 T = new 씨름선수();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Body> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int h=scanner.nextInt();
            int w=scanner.nextInt();
            list.add(new Body(h, w));
        }

        System.out.println(T.solution(list, n));
    }
}
