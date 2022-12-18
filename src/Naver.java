import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Naver {
    //A:3 B:2 C:5  -> 10
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Integer[][] a = new Integer[][]{
                {4, 1},
                {5, 0},
                {2, 3},
                {3, 2}
        };

        Integer[] b = new Integer[]{
                3, 0, 2
        };

        System.out.println(solution(a, b));
        bufferedReader.close();
    }

    public static List solution(Integer[][] gates, Integer[] airlines){
        List<Integer> answer = new ArrayList<>();
        Arrays.sort(airlines, Collections.reverseOrder());

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<airlines.length; i++){
            map.put(i, airlines[i]);
        }

        int idx = 1;
        for(Integer[] gate : gates){
            Arrays.sort(gate, Collections.reverseOrder());
            int count = 0;
            List<Integer> temp = new ArrayList<>(map.values());
            for(int i=0; i<gate.length; i++){
                int result = gate[i] - temp.get(count);
                if(result >= 0){
                    temp.remove(count);
                } else if(result < 0){
                    temp.remove(count);
                    temp.add(count, result*-1);
                    Collections.sort(temp, Collections.reverseOrder());
                }

                if(temp.isEmpty()) {
                    answer.add(idx);
                    break;
                }
            }
            idx++;
        }
        return answer;
    }
}
