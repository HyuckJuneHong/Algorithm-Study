package programmers.level1.hash;

import java.util.HashMap;
import java.util.Map;

public class 폰켓몬 {
    public static int solution(int[] nums) {
        int possible = nums.length/2;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], 0);
        }
        if(possible < map.size()){
            return possible;
        }else{
            return map.size();
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 2, 3};
        System.out.println(solution(a));
    }
}
