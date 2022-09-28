package java_algorithm_study.stack_queue;

import java.util.*;

class Person{
    private int id;
    private int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}

/*
        PriorityQueue<Person> pq = new PriorityQueue<Person>((p1, p2) -> (
                p2.getPriority() - p1.getPriority()
        )); -> 오류 : 같은 위험도 환자는 파악하기 어려움
 */
public class 응급실 {
    private int solution(int n, int k, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();

        for(int i=0; i<n; i++){
            queue.offer(new Person(i, arr[i]));
        }

        while(!queue.isEmpty()) {
            Person temp = queue.poll();
            for (Person p : queue) {
                if (p.getPriority() > temp.getPriority()) {
                    queue.offer(temp);
                    temp = null;
                    break;
                }
            }
            if (temp != null) {
                answer++;
                if (temp.getId() == k) {
                    return answer;
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        응급실 T = new 응급실();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, k, arr));
    }
}
