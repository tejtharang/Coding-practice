package com.tej.DailyCodingProblems;

public class DCP29 {
    // implement run length encoding
    public static void main(String[] args) {
        System.out.println(runLengthEncode("AAAABBBCCDAA"));
    }

    public static String runLengthEncode(String string){
        if(string.length() == 0 || string == null)
            return null;
        char prev = string.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<string.length();i++){
            if(prev != string.charAt(i)){

                sb.append(count);
                sb.append(prev);
                prev = string.charAt(i);
                count = 1;
            }
            else{
                count++;
            }
        }
        sb.append(count);
        sb.append(prev);

        return sb.toString();
    }
}
