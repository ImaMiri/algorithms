package interview;

public class Permutation {

    private String firstStr;
    private String secondStr;

    Permutation(String firstStr, String secondStr) {
        this.firstStr = firstStr;
        this.secondStr = secondStr;
    }

    public boolean compareStr() {
        if(firstStr.length() != secondStr.length()){
            return false;
        } else {
            char[] first = firstStr.toCharArray();
            char[] second = secondStr.toCharArray();
            int len = first.length;
            for (int i=0, j=len -1; i<len && j>=0;i++, j--){
                if(first[i] != second[j]){
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Permutation one = new Permutation("dog", "god   ");
        System.out.println("'dog' and 'god   ' permutaion? " + one.compareStr());
        Permutation two = new Permutation("dog", "god");
        System.out.println("'dog' and 'god' permutaion? " + two.compareStr());
        Permutation three = new Permutation("dog", "got");
        System.out.println("'dog' and 'got' permutaion? " + three.compareStr());
    }
 }
