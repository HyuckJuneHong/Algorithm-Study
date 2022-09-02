package programmers.level2.hash;

import java.util.Arrays;

public class 전화번호_목록_시간초과 {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book, (s1, o2) -> s1.length() - o2.length());

        for(int i=0; i<phone_book.length; i++){
            String check1 = phone_book[i];
            for(int j=i+1; j<phone_book.length; j++){
                if(check1.equals(phone_book[j].substring(0, check1.length()))){
                    return false;
                }
            }
        }

        return true;
    }
}
