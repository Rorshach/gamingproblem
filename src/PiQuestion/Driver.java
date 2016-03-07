package PiQuestion;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by MnkyB on 2016-02-16.
 */
public class Driver {
    public static void main(String[] args) {
        //f("123", 2);
//        ArrayList<String> temp = permutation("1234+5");
//        for(int i=0; i<temp.size(); i++){
//            System.out.println(temp.get(i));
//        }
        //f("123+", 23);

        ArrayList<String> permutations = allValuePermutations("123");
    }

    public static ArrayList<String> allValuePermutations(String input) {
        //System.out.println(p(input, 1));
        return p(input, 1);
    }


    //Refactor repeated code.
    public static ArrayList<String> p(String input, int offset) {
        ArrayList<String> all = new ArrayList<>();
        if(offset < input.length()){
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();

            sb1.append(input);
            sb2.append(input);
            sb3.append(input);
            sb4.append(input);

            ArrayList<String> a = p(input, offset + 1);
            ArrayList<String> b = p(sb1.insert(offset, "+").toString(), offset+2);
            ArrayList<String> c = p(sb2.insert(offset, "-").toString(), offset+2);
            ArrayList<String> d = p(sb3.insert(offset, "*").toString(), offset+2);
            ArrayList<String> e = p(sb4.insert(offset, "/").toString(), offset+2);

            all.addAll(a);
            all.addAll(b);
            all.addAll(c);
            all.addAll(d);
            all.addAll(e);

            all.add(sb1.toString());
            all.add(sb2.toString());
            all.add(sb3.toString());
            all.add(sb4.toString());

        }
        return all;
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

        if(!isValidNumberedString(listNum)) {
            throw new IllegalArgumentException();
        }

        ArrayList<String> allPermutations = allValuePermutations(listNum);
        ArrayList<String> allOrderedPermutations = allOrderedPermutations(allPermutations);
        ArrayList<String> validPermutation = allValidPermutations(allOrderedPermutations, target);

        int j=0;
        while(j<validPermutation.size()){
            System.out.println(validPermutation.get(j));
            j++;
        }
    }

    //Ex. given 12+3/4+6, allOrderedPermutations will output (12+3)/4+6, 12+(3/4)+6, 12+3/(4+6), (12+3)/(4+6)
    public static ArrayList<String> allOrderedPermutations(ArrayList<String> permutations) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        ArrayList<Character> ops = new ArrayList<Character>();

        int x = -1;
        int y;
        char op;
        StringBuilder sb = new StringBuilder();
        String s = permutations.get(0); //TEMPORARY
        //Get the list of integers and ops from the permutation string
        for(int i=0; i<s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            } else {
                ops.add(s.charAt(i));
                int integer = Integer.valueOf(sb.toString());
                integers.add(integer);
                sb.delete(0, sb.length()-1);
            }
        }

        //Create permutations of order of operations and calculate each. If that permuations is valid, return it

        //return(calculate(1,2,'+') == target);
        return permutations; //TEMP
    }

    public static ArrayList<String> allValidPermutations(ArrayList<String> orderedPermutations, int target) {
        //calculate and check if valid
        return orderedPermutations;
    }


    //calculate functions goes from left to right. The order of operations should be specified before.
    public static int calculate(int x, int y, char op) throws IllegalArgumentException{
        if(!isValidOp(op)) {
            throw new IllegalArgumentException();
        }
        switch(Character.toString(op)){
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": if(x%y == 0) { return x / y;}
            default: throw new IllegalArgumentException();
        }
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
