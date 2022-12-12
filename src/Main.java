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
        StringTokenizer stringTokenizer = new StringTokenizer(s);
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Queue<Person> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            queue.offer(new Person(i, arr[i]));
        }

        int cnt = 1;
        while(!queue.isEmpty()){
            Person temp = queue.poll();
            for(Person p : queue){
                if(p.priority > temp.priority){
                    queue.offer(temp);
                    temp = null;
                    break;
                }
            }

            if(temp != null){
                if(temp.id == k) {
                    stringBuilder.append(cnt);
                    break;
                }else{
                    cnt++;
                }
            }
        }



        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}

class Person{
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}