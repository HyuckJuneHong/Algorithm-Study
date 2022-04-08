package level1.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class k번째수 {
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];;
            int[] result;

            for(int i=0; i<commands.length; i++){
                result = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(result);
                answer[i] = result[commands[i][2]-1];
            }

            return answer;
        }
    }
}
