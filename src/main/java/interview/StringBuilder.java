package interview;

public class StringBuilder{
    private char[] array = new char[0];

    StringBuilder(String s) {
        append(s);
    }

    StringBuilder(char c){
        append(String.valueOf(c));
    }

    public StringBuilder append(String str){
        char[] strArray = str.toCharArray();
        
        if(array.length == 0) {
            setArray(array, 0, strArray.length, strArray);
        } else {
            setArray(array, array.length, (array.length + strArray.length), strArray);
        }
        return this;
    }

    private void setArray(char[] destArr, int srcBegin, int srcEnd, char[] strArr) {
        char[] temp = new char[srcEnd];
        if(destArr.length != 0) {
            for (int i = 0; i < destArr.length; i++) {
                temp[i] = destArr[i];
            }
        }
        for(int i = srcBegin, j = 0; i < srcEnd && j < strArr.length; i++, j++) {
            temp[i] = strArr[j];
        }
        array = temp;
    }

    @Override
    public String toString() {
        return new String(array);
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("abc");
        str.append("d");
        str.toString().substring(' ').equals(' ');
        str.append("ef");
        System.out.println(str);

        StringBuilder charStr = new StringBuilder('z');
        charStr.append("y");
        charStr.append("xw");
        System.out.println(charStr);
    }


}

