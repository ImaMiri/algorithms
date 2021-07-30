import algorithms.SearchUtils;
import algorithms.SortUtils;
import interview.Dog;
import interview.DogComparator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Created on 9/06/2016.
 *
 * @author Ima Miri <ima.miri11@gmail.com>
 */
public class Main {

    public static void flattenList(Object[] unflatten, List flatten){
        for(Object o: unflatten) {
            if(o instanceof ArrayList){
                flattenList(((ArrayList) o).toArray(), flatten);
            }else {
                flatten.add(o);
            }
        }

    }

    public static int reverseNum(String s){

        StringBuilder str = new StringBuilder("");
        boolean flag = false;
        for(int i=s.length() - 1; i>=0; i--){
            if(s.charAt(i) != '-'){
                str.append(s.charAt(i));
            }else{
                flag = true;
            }

        }
        Long result = Long.valueOf(str.toString());
        if(flag){
            result *= -1;
        }
        return  (int) result.longValue();
    }
    public static void main(String[] args) {

        System.out.println(reverseNum("1534236469"));

        /*String s = "abcabcbb";

        List<String> list = new ArrayList<String>();

        for(int i=0; i<s.length(); i++){
            StringBuilder sb = new StringBuilder("");
            for(int j=i; j<s.length(); j++){
                if(!sb.equals("") || !(sb.toString()).contentEquals(String.valueOf(s.charAt(j)))){
                    sb.append(s.charAt(j));
                }else{
                    list.add(sb.toString());
                    System.out.println(sb);
                    continue;
                }
            }

        }*/


        // BinaryTree evaluation


//        searchBenchmarking();

        /*
        // [[1,2,[3]],4] -> [1,2,3,4].

        List<Object> l1 = new ArrayList<>();
        l1.add(3);
        List<Object> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(l1);
        List<Object> l3 = new ArrayList<>();
        l3.add(l2);
        l3.add(4);

        List flatten = new ArrayList();
        Object[] unflattenArr = l3.toArray();

        flattenList(unflattenArr, flatten);
        for (int i = 0; i < flatten.size(); i++) {
            Object o = flatten.get(i);

            System.out.println(o);
        }
        */

//        int[] arr = {40,10,30,20,15};
//        SortUtils.quickSort(arr,0,4);
//        for (int a: arr){
//            System.out.print(a + ", ");
//        }
//
//        System.out.println("");
//
//        int[] array = {38,27,43,3,9,82,10};
//        SortUtils.mergeSort(array);
//        for (int a: array){
//            System.out.print(a + ", ");
//        }
//
//        System.out.println("");
//
//        System.out.println(SearchUtils.binarySearch(arr, 10));
//        System.out.println(SearchUtils.binarySearchRecursive(array, 10, 0, 6));

       /* String[] array = new String[4];
        array[0] = "a";
        for (String a : array) {
            System.out.println(a);
        }

        List<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("Fidoo", 1));
        arrayList.add(new Dog("Alphi", 2));
        arrayList.add(new Dog("Pappy", 2));
//        Collections.sort(arrayList);

        List<Dog> linkedList = new LinkedList<Dog>();
        linkedList.add(new Dog("Lucy",1));
        linkedList.add(new Dog("Fiddle",3));
        linkedList.add(new Dog("Puna",2));
        Collections.sort(linkedList, new DogComparator());

        List vector = new Vector();

        List stack = new Stack();

        Queue queue = new PriorityQueue();


        Map hashMap = new HashMap<>();

        Map<String, String> hashTable = new Hashtable();
        hashTable.put("abc","123");
        hashTable.put("abc","1234");

        for (String o : hashTable.keySet()) {
            System.out.println(hashTable.get(o));
        }

        Set hashSet = new HashSet();

        hashSet.add("1");

        String str = "ABC";
        StringBuffer strBuff = new StringBuffer("ABC"); // Synchronised
//        StringBuilder strBuilder = new StringBuilder(); // unsynchronised
        char[] arr = new char[2];
        arr[0] = 'a';

        for(char c: arr) {
            System.out.println(c);
        }*/
    }

    public static void searchBenchmarking(){

        Map map = initialArray();
        for (Iterator<Map.Entry<Integer, int[]>> iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry<Integer, int[]> next = iterator.next();
            int val = next.getKey();
            int[] arr = next.getValue();
            System.out.print(arr.length + "\t");

            long before = System.nanoTime();
            SearchUtils.linearSearch(arr, val);
            long after = System.nanoTime();
            System.out.print(after - before + "\t");

            before = System.nanoTime();
            SearchUtils.binarySearch(arr, val);
            after = System.nanoTime();
            System.out.print(after - before + "\t");

            before = System.nanoTime();
            SearchUtils.binarySearchRecursive(arr, val, 0, arr.length - 1);
            after = System.nanoTime();
            System.out.println(after - before);
        }
    }

    private static Map<Integer, int[]> initialArray(){

        Map<Integer, int[]> map = new TreeMap<Integer, int[]>();
        map.put(1,new int[]{1});
        map.put(2,new int[]{2,3});
        map.put(3,new int[]{1,2,3});
        map.put(4,new int[]{6,7,8,9});
        map.put(5,new int[]{1,2,3,4,5});
        map.put(21,new int[]{11,21,32,43,54,65});
        map.put(23,new int[]{11,23,32323,43324,54321,65320,76320});
        map.put(32,new int[]{12,21,32,4332,6532,7632,8732,8932});
        map.put(80,new int[]{1,2,3,4,5,6,7,80,90});
        map.put(500,new int[]{100,200,300,400,500,600,700,800,900,999});
        map.put(769,new int[]{119,219,329,439,549,659,666,769,777,879,899});
        map.put(965,new int[]{965,976,999,112322,212321,322323,432324,542321,652320,762320,872321,892329});
        map.put(975,new int[]{733,844,944,975,11320,21320,32320,43320,54320,65320,76320,87320,89320});
        map.put(1060,new int[]{18,28,38,48,58,68,78,88,98,1060,6060,7060,8060,9060});
        map.put(2060,new int[]{423,424,544,566,577,655,677,711,722,1060,2060,3060,4060,4230,4240});
        map.put(7111,new int[]{5440,5660,5771,6551,6771,7111,7221,7331,8441,9441,9551,9651,9761,9998,976101,99910});
        map.put(1132,new int[]{11,14,21,23,32,1132,213211,323200,433212,543200,653211,763201,873202,893222,944100,955111,965122});
        map.put(9909,new int[]{34,43,46,54,57,65,67,76,78,87,89,90,96,9404,9505,9605,9706,9909});
        map.put(51771,new int[]{4204,5404,8404,41230,41240,51440,51660,51771,61551,61771,71111,71221,71331,81441,91441,91551,91651,91761,9199});
        map.put(213021,new int[]{5707,6505,6707,7101,7202,7303,113020,213021,3230200,4330212,5430200,6530211,7630201,8730202,8930222,9440100,9550111,9650122,9760101,9990910});
        map.put(213022,new int[]{12,110,140,210,230,320,340,430,460,540,570,650,670,760,780,870,890,900,960,4203,5606});

        return map;
    }
}
