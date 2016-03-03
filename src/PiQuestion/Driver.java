package PiQuestion;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.*;

/**
 * Created by MnkyB on 2016-02-16.
 */
public class Driver {
    public static void main(String[] args) {
        //f("123", 2);
        ArrayList<String> temp = permutation("1234+5");
        for(int i=0; i<temp.size(); i++){
            System.out.println(temp.get(i));
        }
        //f("123+", 23);
    }

    public static Integer[] getDigits(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[]{});
    }

    private static void collectDigits(int num, List<Integer> digits) {
        if(num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }


    public static void f(String listNum, int target) throws IllegalArgumentException {
//        ArrayList<String> listSubstrings = getListSubstrings(listNum);

        if(!isValidNumberedString(listNum)) {
            throw new IllegalArgumentException();
        }

        int val = Integer.parseInt(listNum);
        Integer[] digits = getDigits(val);
        //test
        System.out.println(Arrays.toString(digits));

        int index = 0;
        while(index < digits.length - 1) {
            StringBuffer sb = new StringBuffer();
            int index2 = index + 1;
            while(index2 < digits.length) {
                if ((digits[index] + digits[index2]) < target) {

                }
            }
        }


        String solutionString = "";
    }

    public static ArrayList<String> getListSubstrings(String listNum) {
        ArrayList<String> stringArr = new ArrayList<String>();

        ArrayList<String> tempStringArr = new ArrayList<String>();
        for(int i=0; i<listNum.length(); i++) {

//            StringBuffer sb = new StringBuffer();
            String firstPart = listNum.substring(0,i);
            tempStringArr.add(firstPart);
            for (int j=1; j<=listNum.length()-1-i; j++){


            }
        }
        return tempStringArr;

    }

    // Permutations should be made by ops being inserted in the str. opcount is str.length()-1
    // permutation first half and permutation second half. first half opcount + second half opcount = total opcount

    public static ArrayList<String> permutation(String str) {
        int len = str.length();
        ArrayList<String> permutations = new ArrayList<String>();

        Deque<String> stack = new ArrayDeque<String>();
        StringBuffer sb = new StringBuffer();


        if (len == 1){
            permutations.add(sb.toString());
            sb.delete(0, sb.length());
        } else {
            int charCount = 1;
            int opPos = 0;

            int opID = 0;

            while(charCount < len) {
                for(int i=0; i < len; i++) {    //check that opID is not 5
                    sb.append(str.charAt(i));

                    if(isValidOp(str.charAt(i))) {

                    } else if((opPos == i) && !isValidOp(str.charAt(i)) && !isValidOp(str.charAt(i+1))) { //check if op is available
                        sb.append("+"); //push opID 1 to 4
                    }
                }
                opPos++;
                charCount++;

                permutations.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        System.out.println(permutations);
        return permutations;
    }

    public static ArrayList<String> permutations(String str, int iterations) {
        ArrayList<String> permutations = new ArrayList<String>();

        return permutations;
    }
    public static boolean isValidOp(char c) {
        return ((Character.compare(c, '+') == 0) ||
                (Character.compare(c, '-') == 0) ||
                (Character.compare(c, '*') == 0) ||
                (Character.compare(c, '/') == 0));
    }

    public static boolean isValidNumberedString(String s) {
        boolean containsOnlyNumbers = true;
        if(s != null && !s.isEmpty()) {
            for(char c : s.toCharArray()) {
                if(!Character.isDigit(c)) {
                    containsOnlyNumbers = false;
                }
            }
        }
        return containsOnlyNumbers;
    }



}
