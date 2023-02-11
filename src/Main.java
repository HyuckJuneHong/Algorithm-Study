import java.io.IOException;
import java.util.*;

public class Main {

    //3
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();  //bacaAacba
        String m = scanner.next();  //abc

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> temp = new HashMap<>(); // a, b

        int mSize = m.length() - 1; //a, b

        //str
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //m
        for(int i=0; i<mSize; i++){
            temp.put(m.charAt(i), temp.getOrDefault(m.charAt(i), 0) + 1);
        }

        int count=0;
        int lt=0;
        int rt;

        //rt=2 ; rt<9 ; rt++
        for(rt=mSize; rt<str.length(); rt++){
            //temp {a, b}
            temp.put(str.charAt(rt), temp.getOrDefault(str.charAt(rt), 0) + 1);
            if(map.equals(temp))
                count++;

            temp.put(str.charAt(lt), temp.get(str.charAt(lt))-1);
            if(temp.get(str.charAt(lt))==0)
                temp.remove(str.charAt(lt));

            lt++;
        }
    }
}

