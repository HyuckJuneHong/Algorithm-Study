import java.util.*;

public class ex2 {

    public static class Print {
        int no;
        int requestTime;
        int count;

        public Print(int no, int requestTime, int count) {
            this.no = no;
            this.requestTime = requestTime;
            this.count = count;
        }
    }

    public static int[] solution(int[][] data) {
        ArrayList<Print> printResult = print(data);

        int[] answer = new int[printResult.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = printResult.get(i).no;
        }
        return answer;
    }

    public static ArrayList<Print> print(int[][] data){
        PriorityQueue<Print> readyQueue = new PriorityQueue<>((o1, o2) -> o1.count - o2.count);
        Queue<Print> queue = new LinkedList<>();
        ArrayList<Print> printResult = new ArrayList<>();

        int totalTime = 0;
        boolean isPrint = false;
        int totalFinishTime = data[0][1];

        for (int i=0; i<data.length; i++) {
            totalTime += data[i][1];
            queue.offer(new Print(data[i][0], data[i][1], data[i][2]));
        }

        for (int time=0; time<=totalTime; time++) {
            if (!queue.isEmpty() && time >= queue.peek().requestTime) {
                readyQueue.offer(queue.poll());
            }
            if (!readyQueue.isEmpty()) {
                if (time >= totalFinishTime) {
                    isPrint = false;
                }
                if (!isPrint && time == readyQueue.peek().requestTime) {
                    Print print = readyQueue.poll();
                    printResult.add(print);
                    totalFinishTime += print.count;
                    isPrint = true;
                }
                if (!isPrint) {
                    Print print = readyQueue.poll();
                    printResult.add(print);
                    totalFinishTime += print.count;
                    isPrint = true;
                }
            }
        }

        return printResult;
    }
}
