package java_algorithm_study.greedy_priority_queue_프림;

import java.util.*;

class Lecture implements Comparable<Lecture>{
    int money;
    int time;

    public Lecture(int money, int time) {
        this.money = money;
        this.time = time;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.time - this.time; //내림
    }
}
public class 최대수입스케줄_greedy_Pq {
    static int n, max=Integer.MIN_VALUE;
    static int answer = 0;

    public int solution(List<Lecture> list){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(list);

        int j=0;
        for(int i=max; i>=1; i--){
            for(;j<n; j++){
                if(list.get(j).time<i){
                    break;
                }else{
                    pq.offer(list.get(j).money);
                }
            }

            if(!pq.isEmpty()){
                answer+=pq.poll();
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        최대수입스케줄_greedy_Pq T = new 최대수입스케줄_greedy_Pq();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        List<Lecture> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int m = scanner.nextInt();
            int day = scanner.nextInt();
            list.add(new Lecture(m, day));
            if(day>max) max=day;
        }
        System.out.println(T.solution(list));
    }
}
