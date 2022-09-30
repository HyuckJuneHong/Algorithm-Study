package java_algorithm_study.dfs_조합수_메모이제이션;

import java_algorithm_study.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 조합수_피자배달거리_dfs {

    static int n, m, len, answer=Integer.MAX_VALUE;
    static int[] combination;
    static List<Point> pizza, home;

    public void dfs(int level, int s){
        if(level==m){
            int sum = 0;
            for(Point p : home){
                int dis = Integer.MAX_VALUE;
                for(int i : combination){
                    dis = Math.min(dis, Math.abs(p.x - pizza.get(i).x) + Math.abs(p.y - pizza.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }else{
            for(int i=s; i<len; i++){
                combination[level] = i;
                dfs(level+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        조합수_피자배달거리_dfs T = new 조합수_피자배달거리_dfs();
        Scanner scanner = new Scanner(System.in);

        n=scanner.nextInt();
        m=scanner.nextInt();
        pizza=new ArrayList<>();
        home=new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int temp=scanner.nextInt();
                if(temp==1) home.add(new Point(i, j));
                else if(temp==2) pizza.add(new Point(i, j));
            }
        }

        len = pizza.size();
        combination = new int[m];       //lenCm
        T.dfs(0, 0);
        System.out.println(answer);
    }
}
