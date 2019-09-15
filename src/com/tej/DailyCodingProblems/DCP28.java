package com.tej.DailyCodingProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DCP28 {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"));
        System.out.println(justifyText(words, 16));
    }

    public static  List<String> justifyText(List<String> words, int k){
        List<String> justifiedLines = new ArrayList<>();
        List<String> wordsInLine = new ArrayList<>();
        int lengthOfLine = 0;
        int sumOfLengthsOfWords = 0;
        for(String word : words){
            if(lengthOfLine + 1 + word.length() > k){
                justifiedLines.add(justifyLine(wordsInLine, k - sumOfLengthsOfWords));
                wordsInLine = new ArrayList<>();
                lengthOfLine = 0;
                sumOfLengthsOfWords = 0;
            }
            wordsInLine.add(word);
            if(lengthOfLine !=0) lengthOfLine++;
            lengthOfLine += word.length();
            sumOfLengthsOfWords += word.length();
        }

        justifiedLines.add(justifyLine(wordsInLine, k - sumOfLengthsOfWords));

        return justifiedLines;
    }

    public static String justifyLine(List<String> words, int spaces){
        int gaps = words.size() - 1;
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word);
            if(gaps == 0) break;
            int space = spaces/gaps;

            for(int i=0; i < space; i++){
                sb.append(" ");
            }

            --gaps;
            spaces -= space;
        }
        return sb.toString();
    }
}
