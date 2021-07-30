package interview;

import java.util.*;
import java.util.ArrayList;

public class Problems {

    public boolean isUnique(String str){
        char[] arr = str.toCharArray();
        List<Character> unique = new ArrayList<Character>();

        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(!contains(unique, c)){
                unique.add(c);
            }
        }
        if(unique.size() == arr.length) return true;

        // Using HashTable
//        char[] arr = str.toCharArray();
//
//        Hashtable<Character, Character> hashtable = new Hashtable<Character, Character>();
//        for(int i = 0; i< arr.length; i++){
//            hashtable.put(arr[i], new Character(' '));
//        }
//
//        if(hashtable.size() == arr.length) return true;
        return false;
    }

    private boolean contains(List<Character> list, char c){
        if(list.contains(c)){
            return true;
        }
        return false;
    }

    boolean isUniqueChars(String str){
        if(str.length()>128) return false;

        boolean[] char_set = new boolean[128];
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public String urlify(String s, int length){
        char[] str = s.toCharArray();
        StringBuilder sb = new StringBuilder("");

        for(int i= 0; i<length; i++){
            char c = str[i];
            if(c==' '){
                sb.append("%20");
            }else{
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }

    public boolean isPalindromePermutation(String s){
        Hashtable<Character, Integer> strTable = new Hashtable<Character, Integer> ();
        char[] strArr = s.toCharArray();
        int num = 1;
        for(int i=0; i< strArr.length; i++){
            if(strTable.containsKey(strArr[i])){
                int val = strTable.get(strArr[i]);
                strTable.put(strArr[i], val+1);
            }else{
                strTable.put(strArr[i],num);
            }
        }
        if(strTable.size() % 2 == 0){
            for(Iterator itr = strTable.entrySet().iterator(); itr.hasNext(); ){
                Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) itr.next();
                if(entry.getValue() % 2 != 0 ) return false;
            }
        } else{
            int count = 0;
            for(Iterator itr = strTable.entrySet().iterator(); itr.hasNext(); ){
                Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) itr.next();
                if(entry.getValue() % 2 != 0) count++;
            }
            if(count> 1) return false;
        }
        return true;
    }

    public boolean isOneEditWay(String a, String b){

        if(a.length() == b.length()){
            return isOneReplace(a,b);
        }else if(a.length() +1 == b.length()){
            return isOneInsertOrRemove(a,b);
        } else if(a.length() -1 == b.length()){
            return isOneInsertOrRemove(b,a);
        }

        return false;
    }

    private Boolean isOneReplace(String a, String b){

        int numRpl = 0;
        for(int i = 0; i< a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) numRpl++;
        }

        if(numRpl == 1) return true;
        return false;
    }

    private Boolean isOneInsertOrRemove(String a, String b){
        int index1 = 0;
        int index2 = 0;
        while(index2 < b.length() && index1 < a.length()) {
            if(a.charAt(index1) != b.charAt(index2)){
                if(index1 != index2) {
                    return false;
                }
                index2++;
            }else{
                index1++;
                index2++;
            }
        }
        return true;
    }

    public String stringCompressor(String str){
        Map<Character, Integer> strTable = new LinkedHashMap<Character, Integer> ();
        int numChar = 1;
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(strTable.containsKey(ch)){
                int val = strTable.get(ch);
                strTable.put(ch, val+1);
            }else{
                strTable.put(ch, numChar);
            }
        }
        StringBuilder sb = new StringBuilder("");
//        boolean isOriginal = true;
        for(Iterator itr = strTable.entrySet().iterator(); itr.hasNext();){
            Map.Entry<Character, Integer> entrySet = (Map.Entry<Character, Integer>) itr.next();

            int value = entrySet.getValue();
            sb.append(String.valueOf(entrySet.getKey()) + value);
//            if(value > 1) {
//                isOriginal = false;
//            }
        }
        if(sb.toString().length() >= str.length()) {
            return str;
        } else {
            return sb.toString();
        }
    }

    String compress(String str) {
        StringBuilder compressed = new StringBuilder("");
        int countConsecutive = 0;
        for(int i=0; i<str.length(); i++){
            countConsecutive++;
            if(i+1>=str.length() || str.charAt(i) != str.charAt(i+1)) {
                compressed.append(String.valueOf(str.charAt(i)));
                compressed.append(String.valueOf(countConsecutive));
                countConsecutive = 0;
            }
        }
        String compStr = compressed.toString();
        compStr.contains("");
        return compStr.length() < str.length() ? compStr : str;
    }

    public boolean stringRotation(String s1, String s2){
        if(s1 != null && s2 != null && s1.length() == s2.length() ){
            String s = s1+s1;
            if(isSubString(s, s2)){
                return true;
            }
        }
        return false;
    }

    private boolean isSubString(String s1, String s2){
        return s1.contains(s2);
    }

    //8.5
    public int recursiveMultiply(int a, int b){
        if(a == 0 || b == 0) return 0;
        if(a==1 && b >1 ) return b;
        if(a > 1 && b==1) return a;
        return sum(a,b);
    }

    private int sum(int x, int y){
        if(y == 1) return x;
        return x + sum(x, y-1);
    }

    // 8.7
    public void permutationWithoutDups(String s){
        permuteWithoutDups(s, 0, s.length()-1);
    }

    private void permuteWithoutDups(String s, int start, int end){

        if(start == end ){
            System.out.println(s);
        }else {
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                permuteWithoutDups(s, start + 1, end);
                s = swap(s, start, i);
            }
        }
    }

    // 8.8
    public void permutationWithDups(String s){
        Set<String> set = new HashSet<String>();
        set = permuteWithDups(s, 0, s.length()-1, set);

        for (Iterator itr = set.iterator(); itr.hasNext();) {
            String next = (String) itr.next();
            System.out.println(next);
        }
    }

    private Set<String> permuteWithDups(String s, int start, int end, Set<String> set){

        if(start == end && !set.contains(s)) {
            set.add(s);
        }else {
            for (int i = start; i <= end; i++) {
                s = swap(s, start, i);
                if(!set.contains(s)) {
                    permuteWithDups(s, start + 1, end, set);
                }
                s = swap(s, start, i);
            }
        }
        return set;
    }

    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    //10.1
    public void sortedMerge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;

        int indexMerged = lastA + lastB - 1;

        while (indexB >= 0) {
            if (indexA >=0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexA--;
            } else {
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }

    public void groupAnagrams(){

    }


    public static void main(String[] args) {
        Problems obj = new Problems();

//        System.out.println("adsgsdg has all unique chars? " + obj.isUnique("adsgsdg"));
//        System.out.println("adsg4e2 has all unique chars? " + obj.isUniqueChars("adsg4e2"));

//        System.out.println("Unicode of 'test a b   ': " + obj.urlify("test a b   ", 8));
//        System.out.println("Unicode of 'test a b   ': " + obj.urlify("test a biz   ", 10));

//        System.out.println("strlmlrts = " + obj.isPalindromePermutation("strlmlrts"));
//        System.out.println("strlnmlrts = " + obj.isPalindromePermutation("strlnmlrts"));
//        System.out.println("strlnnlrts = " + obj.isPalindromePermutation("strlnnlrts"));

//        System.out.println("Pale, pal = " + obj.isOneEditWay("pale", "pal"));
//        System.out.println("Pale, ale = " + obj.isOneEditWay("pale", "ale"));
//        System.out.println("Pale, pae = " + obj.isOneEditWay("pale", "pae"));
//        System.out.println("Pale, ple = " + obj.isOneEditWay("pale", "ple"));
//        System.out.println("Pale, plee = " + obj.isOneEditWay("pale", "plee"));
//        System.out.println("Pale, paa = " + obj.isOneEditWay("pale", "paa"));

//        System.out.println("aaavvvveeerr : " + obj.stringCompressor("aaavvvveeerr"));
//        System.out.println("atmospher : " + obj.stringCompressor("atmospher"));
//        System.out.println("AAAVEAABBR : " + obj.stringCompressor("AAAVEAABBR"));
//        System.out.println("AAAvveeeAABBR : " + obj.stringCompressor("AAAvveeeAABBR"));
//        System.out.println("aaavvvveeerr : " + obj.compress("aaavvvveeerr"));
//        System.out.println("atmospher : " + obj.compress("atmospher"));
//        System.out.println("AAAVEAABBR : " + obj.compress("AAAVEAABBR"));
//        System.out.println("AAAvveeeAABBR : " + obj.compress("AAAvveeeAABBR"));

//        System.out.println("waterbottle & erbottlewat : " + obj.stringRotation("waterbottle", "erbottlewat"));
//        System.out.println("watebottle & erbottlewat : " + obj.stringRotation("watebottle", "erbottle"));
//        System.out.println("waterbottles & erbottlewat : " + obj.stringRotation("waterbottles", "erbottlewat"));

//        System.out.println("4*3: "+ obj.recursiveMultiply(4,3));
//        System.out.println("5*8: "+ obj.recursiveMultiply(5,8));

//        obj.permutationWithoutDups("ABC");
//        obj.permutationWithDups("AABB");

        int[] a = new int[]{2,3,5,7,0,0,0,0,0};
        int[] b = new int[]{1,4,6,8,9};
        obj.sortedMerge(a, b, 4, 5);

        for (int i=0; i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
