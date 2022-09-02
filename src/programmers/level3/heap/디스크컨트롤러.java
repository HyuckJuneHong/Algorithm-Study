package programmers.level3.heap;

import java.util.*;

public class 디스크컨트롤러 {
    public static int solution(int[][] jobs) {
        int answer = 0;
        int index = 0, time = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while (index < jobs.length || !pq.isEmpty()) {

            while (index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index++]);
            }

            if (pq.isEmpty()){
                time = jobs[index][0];
            } else {
                int[] job = pq.poll();
                answer += time - job[0] + job[1];
                time += job[1];
            }
        }

        return answer / jobs.length;
    }

    public static void main(String[] args) {
        int[][] i = new int[][]{{0,3},{1,9},{2,6}};
        System.out.println(solution(i));
    }
}
