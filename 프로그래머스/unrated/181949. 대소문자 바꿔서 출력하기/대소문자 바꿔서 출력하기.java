import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char tmp;
        for(int i=0; i<a.length(); i++){
            tmp = a.charAt(i);
            //대문자인 경우
            if(tmp >= 65 && tmp <=90) 
                System.out.print((char)(tmp+32));
            else
            //소문자인 경우 
                System.out.print((char)(tmp-32));
        }
    }
}