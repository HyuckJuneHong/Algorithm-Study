import java_algorithm_study.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] combi;
    static int n, m, len, min = Integer.MAX_VALUE;
    static List<Point> home, pizza;

    private static void DFS(int L, int s) {
        if(L==m){
            int sum = 0;
            for(Point h : home){
                int dis = Integer.MAX_VALUE;
                for(int c : combi){
                    dis = Math.min(dis, Math.abs(h.x-pizza.get(c).x) + Math.abs(h.y - pizza.get(c).y));
                }
                sum += dis;
            }
            min = Math.min(min, sum);
        }else{
            for(int i=s; i<len; i++){
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);

        home = new ArrayList<>();
        pizza = new ArrayList<>();

        String[] arr = new String[n];

        for(int i=0; i<n; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0; j<n; j++){
                int temp = Integer.parseInt(stringTokenizer.nextToken());
                if(temp == 1){
                    home.add(new Point(i, j));
                }else if(temp == 2){
                    pizza.add(new Point(i, j));
                }
            }
        }

        //lenCm
        len = pizza.size();
        combi = new int[m];
        DFS(0, 0);

        System.out.println(min);
        bufferedReader.close();
    }
}

