package java_algorithm_study.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Time implements Comparable<Time>{
    int start;
    int time;

    public Time(int start, int time) {
        this.start = start;
        this.time = time;
    }

    @Override
    public int compareTo(Time o) {
        if(this.time == o.time) return this.start - o.start;
        else return this.time - o.time;
    }
}

public class 회의실배정 {
    static int answer = 0;

    public static void main(String[] args) {
        회의실배정 T = new 회의실배정();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Time> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            int s=scanner.nextInt();
            int t=scanner.nextInt();
            list.add(new Time(s, t));
        }

        System.out.println(T.solution(list, n));
    }

    private int solution(List<Time> list, int n) {
        Collections.sort(list);

        int endTime = 0;
        for(Time t : list){
            if(t.start >= endTime){
                answer++;
                endTime = t.time;
            }
        }

        return answer;
    }
}
