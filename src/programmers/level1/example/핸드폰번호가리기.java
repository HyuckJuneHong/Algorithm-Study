package programmers.level1.example;

public class 핸드폰번호가리기 {
    public static String solution(String phone_number) {
        String answer = "";

        if(phone_number.length() == 4){
            return "****";
        }
        for(int i=0; i<phone_number.length()-4; i++){
            answer += "*";
        }
        answer += phone_number.substring(phone_number.length()-4, phone_number.length());
        return answer;
    }

    public String solution1(String phone_number) {
        return phone_number.replaceAll(".(?=.{4})", "*");
    }

    public static void main(String[] args) {


        System.out.println(solution("12312321141124232131312312332131234"));
    }
}


