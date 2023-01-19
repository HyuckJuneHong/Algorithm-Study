package java_algorithm_study.sort_LRU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 5 9
 * 1 2 3 2 6 2 3 5 7
 *
 * 1 0 0 0 0
 * 2 1 0 0 0
 * 3 2 1 0 0
 * 2 3 1 0 0
 * 6 2 3 1 0
 * 2 6 3 1 0
 * 3 2 6 1 0
 * 5 3 2 6 1
 * 7 5 3 2 6
 */
public class Least_Recently_Used_카카오_변형_캐시 {
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

        int[] cache = new int[n];
        for(int num : arr){
            int pos = -1;
            for(int i=0; i<n; i++)
                if(num == cache[i])
                    pos=i;

            if(pos==-1)
                for(int i=n-1; i>=1; i--)
                    cache[i] = cache[i-1];
            else
                for(int i=pos; i>=1; i--)
                    cache[i] = cache[i-1];

            cache[0] = num;
        }

        for(int i=0; i<n; i++){
            stringBuilder.append(cache[i]+ " ");
        }

        System.out.println(stringBuilder);
        bufferedReader.close();
    }
}

/**
 * <Queue 로 푼 답>
 *  Queue<Integer> queue = new LinkedList<>();
 *  for(int i=0; i<k; i++){
 *      if(queue.contains(arr[i])){
 *          queue.remove(arr[i]);
 *      }
 *      queue.offer(arr[i]);
 *      if(queue.size() > n){
 *          queue.poll();
 *      }
 *  }
 *
 *  int[] answer = new int[n];
 *  for(int i=n-1; i>=0; i--){
 *      answer[i] = queue.poll();
 *  }
 *  for(int i=0; i<n; i++){
 *    stringBuilder.append(answer[i]+" ");
 *  }
 *  System.out.println(stringBuilder);
 *  bufferedReader.close();
 */
