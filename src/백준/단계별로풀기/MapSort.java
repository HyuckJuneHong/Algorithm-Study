package 백준.단계별로풀기;

import java.io.*;
import java.util.*;

public class MapSort {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer[] stringTokenizer;

    public void solution(String s) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        s = s.toUpperCase();

        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, ((o1, o2) -> {
            return o2.getValue() - o1.getValue();
        }));

        int count = 0;
        char maxC = '?', maxC2 = '?';

        for(Map.Entry<Character, Integer> c : list){
            if(count == 0){
                maxC = c.getKey();
            }else if(count == 1) {
                maxC2 = c.getKey();
            }else break;
            count++;
        }

        if(map.get(maxC).equals(map.get(maxC2))){
            bufferedWriter.write("?");
        }else{
            bufferedWriter.write(maxC + "");
        }

        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
    public static void main(String[] args) throws IOException {
        MapSort T = new MapSort();

        String s = bufferedReader.readLine();

        T.solution(s);
    }
}
