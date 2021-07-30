/**
 * Created by ima on 8/2/19.
 */
public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {
        int jump = 0;
        int flag = 0;
        for(int i=1; i< c.length; i++){
            if(c[i] == 1 ){
                flag = 0;
                continue;
            }else{
                jump++;
            }

            if(c[i-1]==0 && c[i]==0 && (i+1) <c.length && c[i+1]==0){
                flag++;
                if(flag >3){
                    jump--;
                }
            }
        }

        /*
        *  int n= c.length;
        int jumps = 0;
        int cloud = 0;
        while (cloud != n-1) {
            if (cloud+2 < n && c[cloud+2] != 1) {
                cloud = cloud+2;
            } else {
                cloud = cloud+1;
            }
            jumps++;
        }

        * */
        return jump;
    }

    public static void main(String[] args) {
//        System.out.print(jumpingOnClouds(new int[]{0,0,1,0,0,1,0}));
//        System.out.print(jumpingOnClouds(new int[]{0,0,1,0,0,0,0,1,0,0}));
        System.out.print(jumpingOnClouds(new int[]{0,0,0,1,0,0}));

    }
}
