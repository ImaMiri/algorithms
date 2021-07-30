/**
 * Created by ima on 8/2/19.
 */
public class countingValleys {

    static int countingValleys(int n, String s) {
        char[] hike = s.toCharArray();
        int count =0;
        int altitude = 0;
        for(char c: hike){
            if(c=='U'){
                if(altitude == -1){
                    count++;
                }
                altitude++;
            }else{
                altitude--;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        System.out.println(countingValleys(8, "UDDDUDUU"));
    }
}
