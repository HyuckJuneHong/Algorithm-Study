import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int k = Integer.parseInt(s.split(" ")[1]);
        s = bufferedReader.readLine();
        int[] arr = new int[k];

        StringTokenizer stringTokenizer = new StringTokenizer(s);
        for(int i=0; i<k; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<k; i++){
            if(queue.contains(arr[i])){
                queue.remove(arr[i]);
            }
            queue.offer(arr[i]);
            if(queue.size() > n){
                queue.poll();
            }
        }

        int[] answer = new int[n];
        for(int i=n-1; i>=0; i--){
            answer[i] = queue.poll();
        }
        for(int i=0; i<n; i++){
            stringBuilder.append(answer[i]+" ");
        }
        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}