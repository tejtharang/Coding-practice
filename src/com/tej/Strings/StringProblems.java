package com.tej.Strings;

import java.util.*;

public class StringProblems {
    public static void main(String[] args) {
        //printDuplicateCharacters("character");
        //System.out.println(anagrams("motorr","rotom"));
        //System.out.println(firstNonRepeating("mnpsnmp"));
        //System.out.println(recursiveReverse("mama"));
        //System.out.println(Arrays.toString(vowelsAndConsonants("tharang")));
        //permutationsOfString("hel");
        //System.out.println(rotation("meter","termet"));
        //System.out.println(palindrome("malayalama"));
        //System.out.println(URLify("Mr John Smith    "));
        //System.out.println(palindromePermutation("tact coa"));
        //System.out.println(oneAway("","b "));
        //System.out.println(compression("aaabbttt"));
        //System.out.println(romanToInt("IV"));
        //System.out.println(isValid("(){}[]"));
       // System.out.println(countAndSay(4));
        /*Map<Character,List<String>> map = new HashMap<Character,List<String>>();
        map.put('2',new ArrayList<String>(Arrays.asList("a","b","c")));
        map.put('3',new ArrayList<String>(Arrays.asList("d","e","f")));
        map.put('4',new ArrayList<String>(Arrays.asList("g","h","i")));
        map.put('5',new ArrayList<String>(Arrays.asList("j","k","l")));
        map.put('6',new ArrayList<String>(Arrays.asList("m","n","o")));
        map.put('7',new ArrayList<String>(Arrays.asList("p","q","r","s")));
        map.put('8',new ArrayList<String>(Arrays.asList("t","u","v")));
        map.put('9',new ArrayList<String>(Arrays.asList("w","x","y","z")));
        System.out.println(letterCombinations("23",map));*/
        //String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(groupAnagrams(strs));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> strGroups = new ArrayList<>();
        for(String str : strs){
            boolean flagNew = true;
            for(int i=0;i<strGroups.size();i++){
                List<String> list = strGroups.get(i);
                if(anagram(list.get(0),str)){

                    list.add(str);
                    strGroups.set(i,list);
                    flagNew = false;
                }
            }
            if(flagNew)
                strGroups.add(new ArrayList<String>(Arrays.asList(str)));
        }
        return strGroups;
    }

    public static boolean anagram(String s1,String s2){
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        for(char c : s1.toCharArray()){
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c,1);
        }
        for(char c : s2.toCharArray()){
            if(!map.containsKey(c))
                return false;
            else{
                if(map.get(c) == 0)
                    return false;
                else
                    map.put(c,map.get(c) -1);
            }
        }

        return true;
    }

    public static String multiply(String num1, String num2) {


        int carry = 0, intermediateResult, immediateResult;
        StringBuilder outer = new StringBuilder();

        int l1 = num1.length();
        int l2 = num2.length();


        if(l1 == 0 || l2== 0)
            return null;

        for(int i = l1-1;i>=0;i--){

            // multiplication of elements
            StringBuilder inner = new StringBuilder();
            intermediateResult = 0; carry = 0;
            for(int k=0;k<l1-1-i;k++){
                inner.append("0");
            }
            for(int j=l2-1;j>=0;j--){

                immediateResult = Integer.parseInt(String.valueOf(num1.charAt(i))) * Integer.parseInt(String.valueOf(num2.charAt(j))) + carry;
                carry = immediateResult/10;
                immediateResult = immediateResult % 10;
                inner.append(String.valueOf(immediateResult));

            }
            if(carry != 0)
                inner.append(String.valueOf(carry));
            int innerLength = inner.toString().length();
            int outerLength = outer.toString().length();

            int a = 0;
            int b = 0;
            // adding up the elements
            StringBuilder temp = new StringBuilder();
            if(outerLength == 0){
                outer.append(inner.toString());
            }
            else{
                int addCarry = 0;
                while(a < innerLength && b < outerLength){
                    int result = Integer.parseInt(String.valueOf(inner.toString().charAt(a))) +  Integer.parseInt(String.valueOf(outer.toString().charAt(b))) + addCarry;
                    addCarry = result / 10;
                    result = result % 10;
                    temp.append(String.valueOf(result));
                    a++;
                    b++;
                }
                while(a < innerLength){
                    int result = Integer.parseInt(String.valueOf(inner.toString().charAt(a))) + addCarry;
                    addCarry = result / 10;
                    result = result % 10;

                        temp.append(String.valueOf(result));
                    a++;
                }
                while(b < outerLength){
                    int result = Integer.parseInt(String.valueOf(outer.toString().charAt(b))) + addCarry;
                    addCarry = result / 10;
                    result = result % 10;
                    temp.append(String.valueOf(result));
                    b++;
                }
                if(addCarry!=0){
                    temp.append(String.valueOf(addCarry));
                }
                else{
                    if(temp.toString().endsWith("0"))
                        temp.setLength(temp.length() -1);
                }
                outer = temp;
            }
        }

        return outer.reverse().toString();
    }


    public static List<String> letterCombinations(String digits,Map<Character,List<String>> map) {
        List<String> finalList = new ArrayList<String>();
        if(digits.length() == 0)
            return finalList;
        if(digits.length() == 1){
            for(String s : map.get(digits.charAt(0)))
                finalList.add(s);
            return finalList;
        }
        List<String> prevList = letterCombinations(digits.substring(1),map);
        if(map.containsKey(digits.charAt(0))){
            for(String s1: map.get(digits.charAt(0))){

                for(String s2 : prevList){
                    StringBuilder x = new StringBuilder();
                    x.append(s1);
                    x.append(s2);
                    finalList.add(x.toString());
                }
            }
        }
        return finalList;

    }

    public static String compression(String s){
       boolean flag = false;
       StringBuilder b = new StringBuilder();
       if(s.length() > 0){
           int i=0; int count = 1;
           while(i< s.length()){
               if(!flag){
                   flag = true;
                   b.append(s.charAt(i));
                   flag = true;
               }
               else{
                   if(s.charAt(i) == s.charAt(i-1)){
                       count++;
                   }
                   else{
                       b.append(count);
                       count = 1;
                       b.append(s.charAt(i));
                   }
               }
               i++;
           }
           b.append(count);
           return s.length() >= b.toString().length() ? b.toString() : s;
       }

       return s.length() >= b.toString().length() ? b.toString() : s;
    }

    public static boolean oneAway(String s1,String s2){
        if(s1.length() == s2.length()){
            int i=0,j=0;
            int count = 0;
            while(i < s1.length() && j < s2.length()){
                if(s1.charAt(i) != s2.charAt(j)){
                    count++;
                }
                if(count>1)
                    return false;
                i++;
                j++;
            }
        }
        if(Math.abs(s1.length() - s2.length()) <= 1){
            String smaller;
            String larger;

            if(s1.length() > s2.length()){
                larger = s1;
                smaller = s2;
            }
            else{
                smaller = s1;
                larger = s2;
            }
            int i=0, j=0;
            int count = 0;
            while(i< larger.length() && j < smaller.length()){
               if(larger.charAt(i) != smaller.charAt(j)){
                   count++;
                   i++;
               }
               else{
                   i++;
                   j++;
               }
               if(count > 1){
                   return false;
               }
            }
            return true;
        }
        return false;

    }
    public static boolean palindromePermutation(String s){
        s.replaceAll(" ","");
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()){
            if(!map.containsKey(c))
                map.put(c,1);
            else
                map.put(c,map.get(c) + 1);
        }
        Iterator it = map.entrySet().iterator();
        Map.Entry pair;
        int count = 0;
        while(it.hasNext()){
            pair = (Map.Entry) it.next();
            if((int)pair.getValue() % 2 == 1){
                count++;
                if(count > 1){
                    return false;
                }
            }
        }
        if(count > 1)
            return false;
        return true;
    }
    public static String URLify(String s){
        char [] arr = s.toCharArray();
        int i = s.length() -1;
        int j = s.length() - 1;
        boolean flag = false;
        while( j>0 && j <=i){
            if(!flag && arr[j] != ' '){
                flag = true;
            }
            if(flag){
                if(arr[j] != ' '){
                    arr[i] = arr[j];
                    i--;
                }
                else{
                    arr[i--] = '0';
                    arr[i--] = '2';
                    arr[i--] = '%';
                }
            }
            j--;
        }
        return String.valueOf(arr);

    }
    public static void printDuplicateCharacters(String s){
        Set<Character> set = new HashSet<>();
        for(Character c: s.toCharArray()){
            if(set.contains(c)){
                System.out.println(c);
            }
            else{
                set.add(c);
            }
        }
    }

    public static boolean anagrams(String s1, String s2){
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2))
            return true;
        for(Character c : s1.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+ 1);
            }
            else{
                map.put(c,1);
            }
        }

        for(Character c : s2.toCharArray()){
            if(!map.containsKey(c))
                return false;
            else{
                map.put(c,map.get(c) -1);
            }
        }

        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if(!pair.getValue().equals(0)){
                return false;
            }
        }

        return true;
    }

    public static Character firstNonRepeating(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(Character c : s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c,1);
            }
            else{
                map.put(c,map.get(c) + 1);
            }
        }

        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getValue().equals(1))
                return (Character) pair.getKey();
        }

        return null;
    }

    public static String recursiveReverse(String s){
        char [] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        if(left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            s = new String(arr);
            s = recursiveReverse(s.substring(left + 1, right - 1));
        }
        return s;
    }

    public static int [] vowelsAndConsonants(String s){
        Character [] vowels = {'a','e','i','o','u'};
        List<Character> list = Arrays.asList(vowels);
        int vowelsCount = 0;
        int consonantsCount = 0;
        for(Character c : s.toLowerCase().toCharArray()){
            if(Character.isLetter(c)){
                if(list.contains(c))
                    vowelsCount++;
                else
                    consonantsCount++;
            }
        }
        int [] arr = {vowelsCount,consonantsCount};
        return arr;
    }

    public static void permutationsOfString(String rem, String prefix){
        if(rem.length() == 0){
            System.out.println(prefix);
        }
        else{
            for(int i=0;i<rem.length();i++){
                String str = rem.substring(0,i) + rem.substring(i+1);
                permutationsOfString(str,prefix + rem.charAt(i));
            }
        }

    }

    public static void permutationsOfString(String s){
        permutationsOfString(s,"");
    }

    public static boolean rotation(String s1,String s2){
        for(int i = 0; i < s1.length();i++){
            if(s2.equals(s1.substring(i) + s1.substring(0,i)))
                return true;
        }
        return false;
    }

    public static boolean palindrome(String s){
        int left = 0,right = s.length() -1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }

    public static String swap(String s, int l,int r){
        char [] arr = s.toCharArray();
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        return String.valueOf(arr);
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        Map<Character, Integer> contmap = new HashMap<Character, Integer>();
        contmap.put('I',3);
        contmap.put('V',1);
        contmap.put('X',3);
        contmap.put('L',1);
        contmap.put('C',3);
        contmap.put('D',1);
        contmap.put('M',3);

        Map<Character, Set<Character>> allowed = new HashMap<>();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        set1.add('V');
        set1.add('X');

        set2.add('L');
        set2.add('C');

        set3.add('D');
        set3.add('M');

        allowed.put('I',set1);
        allowed.put('X',set2);
        allowed.put('C',set3);

        Character prevCharacter = null;
        int contcount = 0;
        int value = 0;
        for(int i=s.length()-1;i>=0;i--){
            Character c = s.charAt(i);

            if(c.equals(prevCharacter)){
                contcount++;
                if(contcount > contmap.get(c))
                    return -1;
            }
            else{
                contcount = 1;
                prevCharacter = c;
            }


            if(allowed.containsKey(c)){
                if(i+1 < s.length()){
                    if(allowed.get(c).contains(s.charAt(i+1))){
                        value -= map.get(c);
                    }
                }
                else{
                    value += map.get(c);
                }
            }
            else{
                value += map.get(c);
            }
        }
        return value;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Character c = null;
        List<Character> openBraces = new ArrayList<Character>( Arrays.asList(new Character[]{'{','(','['}) );
        for(int i=0;i<s.length();i++){
            c = s.charAt(i);
            if(openBraces.contains(c)){
                stack.add(c);
            }
            else{
                switch(c){
                    case '}':
                        if(stack.isEmpty() || !stack.peek().equals('{')){
                            return false;
                        }
                        else{
                            stack.pop();
                        }
                        break;
                    case ']':
                        if(stack.isEmpty() || !stack.peek().equals('[')){
                            return false;
                        }
                        else{
                            stack.pop();
                        }
                        break;
                    case ')':
                        if(stack.isEmpty() || !stack.peek().equals('(')){
                            return false;
                        }
                        else{
                            stack.pop();
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        if(n == 1)
            return "1";
        sb.append("1");
        for(int i=1;i<n;i++){
            StringBuilder sb2 = new StringBuilder();
            int count = 0;
            Character prev = null;
            boolean flag = false;
            for(char c : sb.toString().toCharArray()){
                if(flag && !prev.equals(c)){

                    sb2.append(count);
                    sb2.append(prev);
                    count = 1;


                }
                else{
                    flag = true;
                    count++;
                }
                prev = c;
            }
            sb2.append(count);
            sb2.append(prev);
            sb = sb2;
        }

        return sb.toString();
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int l = s.length();
        int max = 1;
        int i=0, j=1;

        while(i<=j && i<l && j<l){
            int index = s.substring(i,j).indexOf(s.charAt(j));
            if(index != -1)
                i = i+index+1;
            j++;
            if(j-i > max)
                max = j-i;
        }

        return max;
    }

    public List<String> generateParantheses(int n){
        if(n == 1)
            return new ArrayList<String>(Arrays.asList("()"));
        Set<String> myList = new HashSet<>();
        List<String> l = generateParantheses(n-1);
        for(String s : l){
            myList.add("(" + s + ")");
            myList.add("()" + s);
            myList.add(s+"()");
        }

        return new ArrayList<>(myList);
    }
}
