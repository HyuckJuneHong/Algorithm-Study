package java_algorithm_study.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Time2 implements Comparable<Time2>{
    int time;
    int state;

    public Time2(int time, int state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time2 o) {
        if(this.time == o.time) return this.state - o.state;
        else return this.time - o.time;
    }
}
public class 결혼식 {
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        결혼식 T = new 결혼식();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Time2> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int st=scanner.nextInt();
            int et=scanner.nextInt();
            list.add(new Time2(st, 's'));
            list.add(new Time2(et, 'e'));
        }

        System.out.println(T.solution(list));
    }

    private int solution(List<Time2> list) {
        Collections.sort(list);
        int count = 0;

        for(Time2 t2 : list){
            if(t2.state == 's'){
                count++;
            }else{
                count--;
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
