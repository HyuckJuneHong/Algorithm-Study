package hackerRank.easy;

import java.util.List;

public class ArraySum {
    public static int simpleArraySum(List<Integer> ar) {

        int result = 0;
        for(Integer num: ar){
            result += num;
        }

        return result;
    }
}
