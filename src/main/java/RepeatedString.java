import java.util.HashMap;
import java.util.Map;

public class RepeatedString {
    static long repeatedString(String s, long n) {

        int length = s.length();
        if(length ==1 && s.equals("a")){
            return n;
        }

        long count=0;
        for(int i = 0; i< length; i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }

        if(length == n){
            return count;
        }else{
            count = (count * (n/ length));
        }

        long repeated = (long) ((n/length) *length);

        if(repeated < n){
            String str = s.substring(0, (int) (n - repeated));
            for(int i = 0; i< str.length(); i++){
                if(str.charAt(i)=='a'){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(repeatedString("kmretasscityylpdhuwjirnqimlkcgxubxmsxpypgzxtenweirknjtasxtvxemtwxuarabssvqdnktqadhyktagjxoanknhgilnm", 736778906));


        String str = "This website is for losers LOL!";
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)== 'a' || str.charAt(i)== 'A' || str.charAt(i)== 'e' ||
                    str.charAt(i)== 'E'|| str.charAt(i)== 'i' || str.charAt(i)== 'I' ||
                    str.charAt(i)== 'o'|| str.charAt(i)== 'O' || str.charAt(i)== 'u' ||
                    str.charAt(i)== 'U'){
                str = str.replace(str.charAt(i),'=');
            }
        }
        String s = str.replaceAll("=","");
        System.out.print(s);
    }
}
