package java_algorithm_study.dynamic_LIS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Brick implements Comparable<Brick>{
    public int s, h, w;

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}

public class 가장높은탑쌓기 {

    static int[] dy;

    private int solution(List<Brick> list) {
        int answer = 0;

        Collections.sort(list);
        dy[0] = list.get(0).h;
        answer = dy[0];

        for(int i=1; i<list.size(); i++){
            int maxH = 0;

            for(int j=i-1; j>=0; j--){
                if(list.get(j).w > list.get(i).w && dy[j] > maxH){
                    maxH = dy[j];
                }
            }
            dy[i] = maxH + list.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        가장높은탑쌓기 T = new 가장높은탑쌓기();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Brick> list = new ArrayList<>();
        dy = new int[n];

        for(int i=0; i<n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            list.add(new Brick(a, b, c));
        }

        System.out.println(T.solution(list));
    }
}
