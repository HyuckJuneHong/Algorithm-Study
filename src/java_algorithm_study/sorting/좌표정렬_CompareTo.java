package java_algorithm_study.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 좌표정렬_CompareTo {

    public static void main(String[] args) {
        좌표정렬_CompareTo T = new 좌표정렬_CompareTo();
        Scanner kb = new Scanner(System.in);

        int n=kb.nextInt();
        List<Point> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = kb.nextInt();
            int y = kb.nextInt();
            list.add(new Point(x, y));
        }
        Collections.sort(list);

        for(Point o : list){
            System.out.println(o.x + " " + o.y);
        }
    }
}

class Point implements Comparable<Point>{

    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x){
            return this.y - o.y;
        }else{
            return this.x - o.x;
        }
    }
}
