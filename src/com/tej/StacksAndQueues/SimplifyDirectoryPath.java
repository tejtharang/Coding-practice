package com.tej.StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class SimplifyDirectoryPath {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        Scanner s = new Scanner(System.in);
        String directoryPath = s.nextLine();
        String [] listOfPathNames = directoryPath.split("/");
        System.out.print("/" + listOfPathNames[listOfPathNames.length -1]);
    }
}
