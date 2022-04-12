package level2.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H_Index {
    public static int solution(int[] citations) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<citations.length; i++){
            list.add(citations[i]);
        }

        Collections.sort(list, Collections.reverseOrder());
        int answer = 0;

        for(int i=1; i<=list.size(); i++){
            if(i<=list.get(i-1)){
                answer++;
            }
        }


        return answer;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 6, 1, 5};
        int result = solution(arr);
        System.out.println(result);
    }
}
